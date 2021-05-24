import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack < Pair > st = new Stack < > ();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    //method 1 -> create a static variable
    static boolean isBal;
    public static void isBalanced1(Node root) {
        isBal = true;
        height(root);
    }

    public static int height(Node node) {
        if (node == null) {
            return 0;
        }

        int lht = height(node.left);
        int rht = height(node.right);

        int bf = Math.abs(lht - rht); //balancing factor

        if (bf > 1) {
            isBal = false;
        }

        return Math.max(lht, rht) + 1;
    }

    //method 2 -> return BalPair from childs
    public static class BalPair {
        boolean isBal;
        int ht;

        BalPair() {

        }

        BalPair(boolean isBal, int ht) {
            this.isBal = isBal;
            this.ht = ht;
        }
    }

    public static BalPair isBalanced2(Node node) {
        if (node == null) {
            BalPair bp = new BalPair(true, 0);
            return bp;
        }

        BalPair lp = isBalanced2(node.left);
        BalPair rp = isBalanced2(node.right);

        int bf = Math.abs(lp.ht - rp.ht);

        boolean isBal = (bf <= 1) && (lp.isBal == true) && (rp.isBal == true);
        int ht = Math.max(lp.ht, rp.ht) + 1;

        BalPair np = new BalPair(isBal, ht);

        return np;
    }

    public static void main(String[] args) throws Exception {
        //input can be managed
    }

}