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



    //1. using return type
    public static ArrayList < TreeNode > nodeToRootPath(TreeNode node, int data) {
        if (node == null) {
            return new ArrayList < > ();
        }

        if (node.val == data) {
            ArrayList < TreeNode > bl = new ArrayList < > ();
            bl.add(node);
            return bl;
        }

        ArrayList < TreeNode > n2lcp = nodeToRootPath(node.left, data); //node to left child path

        if (n2lcp.size() != 0) {
            n2lcp.add(node);
            return n2lcp;
        }

        ArrayList < TreeNode > n2rcp = nodeToRootPath(node.right, data); //node to right child path

        if (n2rcp.size() != 0) {
            n2rcp.add(node);
            return n2rcp;
        }

        return new ArrayList < > ();
    }



    //2nd method
    public static ArrayList < TreeNode > nodeToRootPath(TreeNode node, int data) {
        ArrayList < TreeNode > ans = new ArrayList < > ();

        n2rp_helper(node, data, ans);
        return ans;
    }

    public static boolean n2rp_helper(TreeNode node, int data, ArrayList < TreeNode > ans) {
        if (node == null) {
            return false;
        }

        if (node.val == data) {
            ans.add(node);
            return true;
        }

        boolean lc = n2rp_helper(node.left, data, ans);

        if (lc == true) {
            ans.add(node);
            return true;
        }

        boolean rc = n2rp_helper(node.right, data, ans);

        if (rc == true) {
            ans.add(node);
            return true;
        }

        return false;
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

        int data = scn.nextInt();
        ArrayList < TreeNode > ans = nodeToRootPath(root, data);
        if (ans.size() == 0) System.out.println();
        for (TreeNode node: ans)
            System.out.print(node.val + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}