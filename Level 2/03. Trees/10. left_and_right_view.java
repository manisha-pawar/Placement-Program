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

    //left view
    public static ArrayList < Integer > leftView(TreeNode root) {
        ArrayList < Integer > ans = new ArrayList < > ();
        ArrayDeque < TreeNode > q = new ArrayDeque < > ();

        q.add(root);

        while (q.size() > 0) {
            int count = q.size();
            ans.add(q.peek().val);

            for (int i = 0; i < count; i++) {
                TreeNode rem = q.remove();

                if (rem.left != null) {
                    q.add(rem.left);
                }

                if (rem.right != null) {
                    q.add(rem.right);
                }
            }
        }

        return ans;
    }



    //right view
    public static ArrayList < Integer > rightView(TreeNode root) {
        ArrayList < Integer > ans = new ArrayList < > ();
        ArrayDeque < TreeNode > q = new ArrayDeque < > ();

        q.add(root);

        while (q.size() > 0) {
            int count = q.size();
            ans.add(q.peek().val);

            for (int i = 0; i < count; i++) {
                TreeNode rem = q.remove();

                if (rem.right != null) {
                    q.add(rem.right);
                }

                if (rem.left != null) {
                    q.add(rem.left);
                }

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

        ArrayList < Integer > ans = leftView(root);
        for (Integer i: ans) System.out.println(i);
    }

    public static void main(String[] args) {
        solve();
    }
}