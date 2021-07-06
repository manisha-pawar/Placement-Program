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

    public static void width(TreeNode root,int hl,int[]mmhl) {
        
        if(root == null) {
            return;
        }
        
        mmhl[0] = Math.min(mmhl[0],hl);  //minhl
        mmhl[1] = Math.max(mmhl[1],hl); //maxhl
        
        width(root.left,hl-1,mmhl);
        width(root.right,hl+1,mmhl);
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
    

    //1.using levelorder
    public static ArrayList<Integer> verticalOrderSum(TreeNode root) {
        Queue<Pair>q = new ArrayDeque<>();
        ArrayList<Integer>ans = new ArrayList<>();
        
        int[]minmaxhl = new int[2];
        width(root,0,minmaxhl);
        
        int minhl = minmaxhl[0];
        int maxhl = minmaxhl[1];
        
        int w = maxhl - minhl + 1;
        
        for(int i=0; i < w;i++) {
            ans.add(0);
        }
        
        int blev = -minhl;
        
        q.add(new Pair(root,blev));
        
        while(q.size() > 0) {
            //remove
            Pair rem = q.remove();
            
            //work
            int ps = ans.get(rem.hl); //prev sum
            ans.set(rem.hl,ps + rem.node.val);
            
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
    



    public static class ListNode {
        int data;
        ListNode prev;
        ListNode next;
        
        ListNode() {
            
        }
        
        ListNode(int data) {
            this.data = data;
        }
    }
    
    public static void vos_helper(TreeNode node,ListNode curr) {
        curr.data += node.val;   //contribution
        
        if(node.left != null) {
            if(curr.prev == null) {
                //add first in linkedlist
                ListNode nn = new ListNode(0);
                nn.next = curr;
                curr.prev = nn;
            }
            //call to left
            vos_helper(node.left,curr.prev);
        }
        
        if(node.right != null) {
            if(curr.next == null) {
                //add last in linkedlist
                ListNode nn = new ListNode(0);
                curr.next = nn;
                nn.prev = curr;
            }
            //call to right
            vos_helper(node.right,curr.next);
        }
    }
    

    //2.using recursion (linked list method)
    public static ArrayList<Integer> verticalOrderSum(TreeNode root) {
        ListNode curr = new ListNode(0);
        
        vos_helper(root,curr);
        
        ListNode temp = curr;
        
        while(temp.prev != null) {
            temp = temp.prev;
        }
        
        //temp stores our linkedlist head
        ArrayList<Integer>ans = new ArrayList<>();
        
        while(temp != null) {
            ans.add(temp.data);
            temp = temp.next;
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

        ArrayList<Integer> ans = verticalOrderSum(root);
        for (Integer j : ans)
            System.out.println(j);

    }

    public static void main(String[] args) {
        solve();
    }
}