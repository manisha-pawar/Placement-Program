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


    static TreeNode prev;

    public static boolean helper(TreeNode node) {
        if (node == null) {
            return true;
        }

        boolean lans = helper(node.left);

        //work
        if (prev != null && prev.val > node.val) {
            //inorder is not sorted
            return false;
        }

        prev = node;

        boolean rans = helper(node.right);

        return lans && rans;
    }


    //1. using recursion
    public static boolean isValidBST(TreeNode root) {
        prev = null;
        return helper(root);
    }



    public static TreeNode rightMostNode(TreeNode node, TreeNode curr) {
        TreeNode temp = node;

        while (temp.right != null && temp.right != curr) {
            temp = temp.right;
        }
        return temp;
    }


    //2. using morris traversal
    public static boolean isValidBST(TreeNode root) {
        //morris inorder traversal

        TreeNode curr = root;
        TreeNode prev = null;

        while (curr != null) {
            TreeNode ln = curr.left;

            if (ln == null) {
                if (prev != null && prev.val >= curr.val) {
                    return false;
                }
                prev = curr;
                curr = curr.right;
            } else {
                TreeNode rmn = rightMostNode(ln, curr);

                if (rmn.right == null) {
                    //before going to left, create a thread
                    rmn.right = curr;
                    curr = curr.left;
                } else if (rmn.right == curr) {
                    //left is done, break the thread and go to right
                    if (prev.val >= curr.val) {
                        return false;
                    }
                    rmn.right = null;
                    prev = curr;
                    curr = curr.right;
                }
            }
        }

        return true;
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
        System.out.println(isValidBST(root));
    }

    public static void main(String[] args) {
        solve();
    }
}