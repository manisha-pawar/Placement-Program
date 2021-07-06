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


    //1. using queue
    public static ArrayList < Integer > diagonalOrderSum(TreeNode root) {
        Queue < TreeNode > q = new ArrayDeque < > ();
        ArrayList < Integer > ans = new ArrayList < > ();


        q.add(root);

        while (q.size() > 0) {
            int count = q.size();

            int sum = 0;
            //to travel all the components
            while (count-- > 0) {
                //remove
                TreeNode rem = q.remove();

                //to travel a single component
                while (rem != null) {
                    sum += rem.val;

                    if (rem.left != null) {
                        q.add(rem.left);
                    }

                    rem = rem.right;
                }
            }
            ans.add(sum);
        }
        return ans;
    }



    //2. using recursion
    public static void dos_helper(TreeNode node, int dl, ArrayList < Integer > ans) {
        if (node == null) {
            return;
        }

        if (dl == ans.size()) {
            ans.add(0);
        }
        
        ans.set(dl, ans.get(dl) + node.val);

        dos_helper(node.left, dl + 1, ans);
        dos_helper(node.right, dl, ans);
    }

    public static ArrayList < Integer > diagonalOrderSum(TreeNode root) {

        ArrayList < Integer > ans = new ArrayList < > ();

        dos_helper(root, 0, ans);

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

        ArrayList < Integer > ans = diagonalOrderSum(root);
        for (Integer j: ans)
            System.out.print(j + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}