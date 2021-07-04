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

    public static void width(TreeNode node, int hl, int[] mmhl) {
        if (node == null) {
            return;
        }

        mmhl[0] = Math.min(mmhl[0], hl); //minhl
        mmhl[1] = Math.max(mmhl[1], hl); //maxhl

        width(node.left, hl - 1, mmhl);
        width(node.right, hl + 1, mmhl);
    }

    public static class Pair {
        TreeNode node;
        int hl;

        Pair() {

        }

        Pair(TreeNode node, int hl) {
            this.node = node;
            this.hl = hl;
        }
    }



    //using hashmap
    public static ArrayList < ArrayList < Integer >> verticalOrderTraversal(TreeNode root) {
        Queue < Pair > q = new ArrayDeque < > ();
        HashMap < Integer, ArrayList < Integer >> map = new HashMap < > ();

        q.add(new Pair(root, 0));
        int minhl = 0;
        int maxhl = 0;

        while (q.size() > 0) {
            //remove
            Pair rem = q.remove();
            minhl = Math.min(minhl, rem.hl);
            maxhl = Math.max(maxhl, rem.hl);

            //work
            if (map.containsKey(rem.hl) == true) {
                ArrayList < Integer > list = map.get(rem.hl);
                list.add(rem.node.val);
            } else {
                ArrayList < Integer > list = new ArrayList < > ();
                list.add(rem.node.val);
                map.put(rem.hl, list);
            }

            //add children
            if (rem.node.left != null) {
                q.add(new Pair(rem.node.left, rem.hl - 1));
            }
            if (rem.node.right != null) {
                q.add(new Pair(rem.node.right, rem.hl + 1));
            }
        }

        ArrayList < ArrayList < Integer >> ans = new ArrayList < > ();
        for (int hl = minhl; hl <= maxhl; hl++) {
            ans.add(map.get(hl));
        }

        return ans;
    }



    //without using hashmap
    public static ArrayList < ArrayList < Integer >> verticalOrderTraversal(TreeNode root) {
        int[] mmhl = new int[2];
        width(root, 0, mmhl);

        int w = mmhl[1] - mmhl[0] + 1;

        ArrayList < ArrayList < Integer >> ans = new ArrayList < > ();

        for (int i = 0; i < w; i++) {
            ans.add(new ArrayList < > ());
        }

        Queue < Pair > q = new ArrayDeque < > ();
        int blev = -mmhl[0]; //-minhl

        q.add(new Pair(root, blev));

        while (q.size() > 0) {
            //remove
            Pair rem = q.remove();

            //work
            int hl = rem.hl;
            ans.get(hl).add(rem.node.val);

            //add children
            if (rem.node.left != null) {
                q.add(new Pair(rem.node.left, rem.hl - 1));
            }
            if (rem.node.right != null) {
                q.add(new Pair(rem.node.right, rem.hl + 1));
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

        ArrayList < ArrayList < Integer >> ans = verticalOrderTraversal(root);
        int idx = 0;
        for (ArrayList < Integer > i: ans) {
            System.out.print(idx++ + " -> ");
            for (Integer j: i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}