import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int minhl;
    static int maxhl;
    
    public static void width(TreeNode node,int hl) {
        if(node == null) {
            return;
        }
        
        minhl = Math.min(minhl,hl);
        maxhl = Math.max(maxhl,hl);
        
        width(node.left,hl-1);
        width(node.right,hl+1);
    }
    
    public static class Pair {
        TreeNode node;
        int hl;
        
        Pair() {
            
        }
        
        Pair(TreeNode node,int hl) {
            this.node = node;
            this.hl = hl;
            
        }
    }


    //top view of binary tree
    public static ArrayList<Integer> TopView(TreeNode root) {
        
        ArrayList<Integer>ans = new ArrayList<>();
        minhl = 0;
        maxhl = 0;
        width(root,0);
        
        int w = maxhl - minhl + 1;
        
        for(int i=0; i < w;i++) {
            ans.add(null);
        }
        
        Queue<Pair>q = new ArrayDeque<>();
        int blev = -minhl; //base level
        
        q.add(new Pair(root,blev));
        
        while(q.size() > 0) {
            //remove
            Pair rem = q.remove();
            
            //work
            if(ans.get(rem.hl) == null) {
                ans.set(rem.hl,rem.node.val);
            }
            
            //add children
            if(rem.node.left != null) {
                q.add(new Pair(rem.node.left,rem.hl-1));
            }
            if(rem.node.right != null) {
                q.add(new Pair(rem.node.right,rem.hl+1));
            }
        }
        
        return ans;

    }



    //bottom view of binary tree
    public static ArrayList<Integer> BottomView(TreeNode root) {
        
        ArrayList<Integer>ans = new ArrayList<>();
        minhl = 0;
        maxhl = 0;
        width(root,0);
        
        int w = maxhl - minhl + 1;
        
        for(int i=0; i < w;i++) {
            ans.add(null);
        }
        
        Queue<Pair>q = new ArrayDeque<>();
        int blev = -minhl; //base level
        
        q.add(new Pair(root,blev));
        
        while(q.size() > 0) {
            //remove
            Pair rem = q.remove();
            
            //work
            ans.set(rem.hl,rem.node.val);

            //add children
            if(rem.node.left != null) {
                q.add(new Pair(rem.node.left,rem.hl-1));
            }
            if(rem.node.right != null) {
                q.add(new Pair(rem.node.right,rem.hl+1));
            }
        }
        
        return ans;

    }



    // input_section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        ArrayList<Integer> ans = TopView(root);
        for (Integer i : ans)
            System.out.print(i + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}