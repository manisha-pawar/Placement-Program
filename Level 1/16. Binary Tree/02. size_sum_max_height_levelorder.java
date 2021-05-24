import java.util.*;

public class construct {

    public static class Node {
        int data;
        Node left;
        Node right;

        Node() {

        }

        Node(int data) {
            this.data = data;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair() {

        }

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0]);

        Stack < Pair > st = new Stack < > ();
        Pair root_pair = new Pair(root, 1);

        st.push(root_pair);
        int idx = 1;

        while (st.size() > 0) {
            Pair top = st.peek();

            if (top.state == 1) {
                //waiting for left child
                top.state++;
                if (arr[idx] != null) {
                    Node lc = new Node(arr[idx]);
                    top.node.left = lc;

                    Pair lcp = new Pair(lc, 1);
                    st.push(lcp);
                }
                idx++;
            } else if (top.state == 2) {
                //waiting for right child
                top.state++;
                if (arr[idx] != null) {
                    Node rc = new Node(arr[idx]);
                    top.node.right = rc;

                    Pair rcp = new Pair(rc, 1);
                    st.push(rcp);
                }
                idx++;
            } else if (top.state == 3) {
                st.pop();
            }
        }

        return root;

    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = " <- " + node.data + " -> ";

        String left = (node.left == null) ? "." : "" + node.left.data;
        String right = (node.right == null) ? "." : "" + node.right.data;

        str = left + str + right;

        System.out.println(str);

        display(node.left);
        display(node.right);
    }
    

    //size of binary tree
    public static int size(Node node) {
        if (node == null) {
            return 0;
        }

        int ls = size(node.left);
        int rs = size(node.right);

        return ls + rs + 1;
    }


    //sum of binary tree
    public static int sum(Node node) {
        if (node == null) {
            return 0;
        }

        int lsum = sum(node.left);
        int rsum = sum(node.right);

        return lsum + rsum + node.data;
    }


    //max of binary tree
    public static int max(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        int lmax = max(node.left);
        int rmax = max(node.right);

        return Math.max(node.data, Math.max(lmax, rmax));
    }


    //height of binary tree
    public static int height(Node node) {
        if (node == null) {
            return -1;
        }

        int lht = height(node.left);
        int rht = height(node.right);

        return Math.max(lht, rht) + 1;
    }


    //level-order linewise
    public static void levelOrder(Node node) {
        Queue < Node > q = new ArrayDeque < > ();

        q.add(node);

        while (q.size() > 0) {
            int s = q.size();

            for (int i = 0; i < s; i++) {
                Node rem = q.remove();
                System.out.print(rem.data + " ");

                //left child
                if (rem.left != null) {
                    q.add(rem.left);
                }

                //right child
                if (rem.right != null) {
                    q.add(rem.right);
                }
            }

            System.out.println();

        }
    }


    public static void main(String[] args) {
        Integer[]arr = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};

        Node root = construct(arr);

        display(root);
    }
}