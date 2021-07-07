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




    //fill single child parent nodes in arraylist
    public static void exactlyOneChild(TreeNode node, ArrayList < Integer > ans) {
        if (node == null) {
            return;
        }

        if ((node.left != null && node.right == null) || (node.left == null && node.right != null)) {
            //single child parent node
            ans.add(node.val);
        }

        exactlyOneChild(node.left, ans);
        exactlyOneChild(node.right, ans);
    }

    public static ArrayList < Integer > exactlyOneChild(TreeNode root) {
        ArrayList < Integer > ans = new ArrayList < > ();
        exactlyOneChild(root, ans);
        return ans;
    }




    //count single child parent nodes
    public static int countExactlyOneChild(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int lc = countExactlyOneChild(node.left);
        int rc = countExactlyOneChild(node.right);

        int ans = lc + rc;

        if ((node.left != null && node.right == null) ||
            (node.left == null && node.right != null)) {
            //node is a single child parent
            ans++;
        }

        return ans;
    }


    // input_section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode Treenode = new TreeNode(arr[IDX[0]++]);
        Treenode.left = createTree(arr, IDX);
        Treenode.right = createTree(arr, IDX);

        return Treenode;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        ArrayList < Integer > ans = exactlyOneChild(root);
        if (ans.size() == 0)
            System.out.println();
        for (Integer ele: ans)
            System.out.print(ele + " ");
    }

    public static void main(String[] args) {
        solve();
    }
}