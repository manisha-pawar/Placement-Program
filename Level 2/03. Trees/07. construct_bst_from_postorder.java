import java.util.Scanner;

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


    //we can use a static idx as well
    public static TreeNode buildTree(int[] postorder, int lr, int rr, int[] posn) {
        int idx = posn[0];

        if (idx < 0 || postorder[idx] < lr || postorder[idx] > rr) {
            return null;
        } 
        else {
            TreeNode node = new TreeNode(postorder[idx]);
            posn[0]--;
            node.right = buildTree(postorder, node.val, rr, posn);
            node.left = buildTree(postorder, lr, node.val, posn);

            return node;
        }
    }

    public static TreeNode bstFromPostorder(int[] postorder) {
        int n = postorder.length;
        int[] posn = new int[1];
        posn[0] = n - 1;

        return buildTree(postorder, Integer.MIN_VALUE, Integer.MAX_VALUE, posn);
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static void solve() {
        int n = scn.nextInt();
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = bstFromPostorder(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}