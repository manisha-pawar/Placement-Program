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

    //pst -> preorder start
    //pet -> preorder end
    //ist -> inorder start
    //iet -> inorder end

    public static TreeNode buildTree(int[] preorder, int pst, int pet, int[] inorder, int ist, int iet) {
        if (ist > iet || pst > pet) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[pst]);

        int idx = ist;

        while (inorder[idx] != preorder[pst]) {
            idx++;
        }

        int colse = idx - ist; //count of left subtree elements

        node.left = buildTree(preorder, pst + 1, pst + colse, inorder, ist, idx - 1);
        node.right = buildTree(preorder, pst + colse + 1, pet, inorder, idx + 1, iet);

        return node;
    }


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        //preorder, pre start,pre end,inorder,in start,in end
        return buildTree(preorder, 0, n - 1, inorder, 0, n - 1);
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

        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in [i] = scn.nextInt();

        TreeNode root = buildTree(pre, in );
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}