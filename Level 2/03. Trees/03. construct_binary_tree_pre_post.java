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

    public static TreeNode buildTree(int[] preorder, int prs, int pre, int[] postorder, int pos, int poe) {
        if (prs > pre || pos > poe) {
            return null;
        }

        if (prs == pre) {
            return new TreeNode(preorder[prs]);
        }

        TreeNode node = new TreeNode(preorder[prs]);

        int idx = pos;

        while (postorder[idx] != preorder[prs + 1]) {
            idx++;
        }

        int colse = idx - pos + 1;

        node.left = buildTree(preorder, prs + 1, prs + colse, postorder, pos, idx);
        node.right = buildTree(preorder, prs + colse + 1, pre, postorder, idx + 1, poe - 1);

        return node;
    }

    public static TreeNode constructFromPrePost(int[] pre, int[] post) {
        int n = pre.length;
        return buildTree(pre, 0, n - 1, post, 0, n - 1);
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
        int[] post = new int[n];
        for (int i = 0; i < n; i++)
            post[i] = scn.nextInt();

        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = constructFromPrePost(pre, post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}