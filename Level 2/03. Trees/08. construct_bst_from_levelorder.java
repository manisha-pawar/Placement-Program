import java.util.Scanner;
import java.util.ArrayDeque;

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

    public static class Pair {
        TreeNode par;
        int lr = Integer.MIN_VALUE;
        int rr = Integer.MAX_VALUE;

        Pair() {

        }

        Pair(TreeNode par, int lr, int rr) {
            this.par = par;
            this.lr = lr;
            this.rr = rr;
        }
    }



    public static TreeNode constructBSTFromLevelOrder(int[] LevelOrder) {
        ArrayDeque < Pair > q = new ArrayDeque < > ();
        int n = LevelOrder.length;

        q.add(new Pair());
        TreeNode root = null;

        int idx = 0;

        while (q.size() > 0 && idx < n) {
            Pair rem = q.remove();

            int val = LevelOrder[idx];

            if (val < rem.lr || val > rem.rr) {
                continue;
            }

            TreeNode node = new TreeNode(val);
            idx++;

            if (rem.par == null) {
                root = node;
            } 
            else {
                if (rem.par.val > node.val) {
                    rem.par.left = node;
                } 
                else if (rem.par.val < node.val) {
                    rem.par.right = node;
                }
            }

            Pair lcp = new Pair(node, rem.lr, node.val);
            Pair rcp = new Pair(node, node.val, rem.rr);

            q.add(lcp);
            q.add(rcp);

        }

        return root;

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
        int[] level = new int[n];
        for (int i = 0; i < n; i++)
            level[i] = scn.nextInt();

        TreeNode root = constructBSTFromLevelOrder(level);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}