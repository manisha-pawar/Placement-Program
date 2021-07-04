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

    public static void width_helper(TreeNode root, int hl, int[] minmaxhl) {
        if (root == null) {
            return;
        }

        minmaxhl[0] = Math.min(minmaxhl[0], hl); //minhl
        minmaxhl[1] = Math.max(minmaxhl[1], hl); //maxhl

        width_helper(root.left, hl - 1, minmaxhl);
        width_helper(root.right, hl + 1, minmaxhl);
    }

    public static int width(TreeNode root) {
        int[] minmaxhl = new int[2];
        width_helper(root, 0, minmaxhl); //min max horizontal level

        int minhl = minmaxhl[0];
        int maxhl = minmaxhl[1];
        int w = maxhl - minhl + 1;

        return w;
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

        System.out.println(width(root));
    }

    public static void main(String[] args) {
        solve();
    }
}