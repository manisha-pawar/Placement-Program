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

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "n";
        }

        String ls = serialize(root.left);
        String rs = serialize(root.right);

        return root.val + " " + ls + " " + rs;
    }

    // Decodes your encoded data to tree.
    static int idx;

    public static TreeNode deserialize(String str) {
        String[] token = str.split(" ");
        idx = 0;

        return deserialize(token);
    }

    public static TreeNode deserialize(String[] token) {
        if (token[idx].equals("n") == true) {
            idx++;
            return null;
        }
        else {
            int val = Integer.parseInt(token[idx]);
            TreeNode node = new TreeNode(val);
            idx++;
            node.left = deserialize(token);
            node.right = deserialize(token);

            return node;
        }

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

        String s = serialize(root);
        display(deserialize(s));
    }

    public static void main(String[] args) {
        solve();
    }
}