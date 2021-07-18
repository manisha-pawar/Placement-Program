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

    public static TreeNode rightMostNode(TreeNode node, TreeNode curr) {
        TreeNode temp = node;

        while (temp.right != null && temp.right != curr) {
            temp = temp.right;
        }

        return temp;
    }



    //in order morris traversal
    public static ArrayList < Integer > morrisInTraversal(TreeNode root) {
        ArrayList < Integer > list = new ArrayList < > ();

        TreeNode curr = root;

        while (curr != null) {
            TreeNode ln = curr.left; //left node

            if (ln == null) {
                list.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode rmn = rightMostNode(ln, curr);

                if (rmn.right == null) {
                    //need to create a thread
                    rmn.right = curr;
                    curr = curr.left;
                } else if (rmn.right == curr) {
                    //left subtree is done, break the thread
                    rmn.right = null;
                    list.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return list;
    }



    //pre order morris traversal
    public static ArrayList < Integer > morrisPreTraversal(TreeNode root) {
        ArrayList < Integer > list = new ArrayList < > ();

        TreeNode curr = root;

        while (curr != null) {
            TreeNode ln = curr.left;

            if (ln == null) {
                list.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode rmn = rightMostNode(ln, curr);

                if (rmn.right == null) {
                    //create a thread before going left-subtree
                    list.add(curr.val);
                    rmn.right = curr;
                    curr = curr.left;
                } else {
                    //left subtree is done
                    rmn.right = null;
                    curr = curr.right;
                }
            }
        }

        return list;
    }


    
    public static TreeNode leftMostNode(TreeNode node, TreeNode curr) {
        TreeNode temp = node;

        while (temp.left != null && temp.left != curr) {
            temp = temp.left;
        }

        return temp;
    }


    //post order morris traversal
    public static List < Integer > postorderTraversal(TreeNode root) {
        List < Integer > list = new ArrayList < > ();

        TreeNode curr = root;

        while (curr != null) {
            TreeNode rn = curr.right; //right node

            if (rn == null) {
                list.add(curr.val);
                curr = curr.left;
            } else {
                TreeNode lmn = leftMostNode(rn, curr); //left most node

                if (lmn.left == null) {
                    list.add(curr.val);
                    lmn.left = curr;
                    curr = curr.right;
                } else {
                    lmn.left = null;
                    curr = curr.left;
                }
            }
        }

        //list -> NLR (rev euler preorder)
        //post -> rev(NRL) = LRN 

        Collections.reverse(list);

        return list;
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

        ArrayList < Integer > ans = morrisInTraversal(root);
        for (Integer i: ans)
            System.out.print(i + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}