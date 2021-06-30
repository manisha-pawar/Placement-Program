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

    static int idx;
    //lr -> left range
    //rr -> right range

    public static TreeNode buildTree(int[] preorder, int lr, int rr) {
        if (idx >= preorder.length || preorder[idx] < lr || preorder[idx] > rr) {
            return null;
        } 
        else {
            TreeNode node = new TreeNode(preorder[idx]);
            idx++;
            node.left = buildTree(preorder, lr, node.val);
            node.right = buildTree(preorder, node.val, rr);

            return node;
        }
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        idx = 0;
        return buildTree(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
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

        TreeNode root = bstFromPreorder(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}