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
    public static ArrayList < ArrayList < Integer >> rootToAllLeafPath(TreeNode root) {
        if (root == null) {
            ArrayList < ArrayList < Integer >> bl = new ArrayList < > ();
            return bl;
        }

        if (root.left == null && root.right == null) {
            //leaf node
            ArrayList < ArrayList < Integer >> bl = new ArrayList < > ();
            ArrayList < Integer > list = new ArrayList < > ();
            list.add(root.val);
            bl.add(list);
            return bl;
        }

        ArrayList < ArrayList < Integer >> r2lp = new ArrayList < > ();
        ArrayList < ArrayList < Integer >> lans = rootToAllLeafPath(root.left);
        ArrayList < ArrayList < Integer >> rans = rootToAllLeafPath(root.right);

        for (ArrayList < Integer > lctoleafpath: lans) {
            lctoleafpath.add(0, root.val);
            r2lp.add(lctoleafpath);
        }

        for (ArrayList < Integer > rctoleafpath: rans) {
            rctoleafpath.add(0, root.val);
            r2lp.add(rctoleafpath);
        }

        return r2lp;
    }



    
    //2. recursion on the way up
    public static ArrayList < ArrayList < Integer >> rootToAllLeafPath(TreeNode root) {

        ArrayList < ArrayList < Integer >> ans = new ArrayList < > ();
        ArrayList < Integer > list = new ArrayList < > ();

        r2lp_helper(root, list, ans);
        return ans;
    }


    public static void r2lp_helper(TreeNode node, ArrayList < Integer > asf, ArrayList < ArrayList < Integer >> ans) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            //leaf node
            asf.add(node.val);
            ArrayList < Integer > list = new ArrayList < > (asf);
            ans.add(list);
            asf.remove(asf.size() - 1);
            return;
        }

        asf.add(node.val);
        r2lp_helper(node.left, asf, ans);
        r2lp_helper(node.right, asf, ans);
        asf.remove(asf.size() - 1);
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

        ArrayList < ArrayList < Integer >> ans = rootToAllLeafPath(root);
        if (ans.size() == 0)
            System.out.println();
        for (ArrayList < Integer > al: ans) {
            for (Integer ele: al)
                System.out.print(ele + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}