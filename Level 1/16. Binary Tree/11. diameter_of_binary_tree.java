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

    public static int height(Node node) {
        if (node == null) {
            return -1;
        }

        int lh = height(node.left);
        int rh = height(node.right);

        int dist = lh + rh + 2;

        if (dist > dia) {
            dia = dist;
        }

        return Math.max(lh, rh) + 1;
    }

    //method 1 -> creating a static variable 
    static int dia;
    public static void diameter1(Node node) {
        dia = 0;
        height(node);
    }

    //method 2 -> return diameter from childs, call height (n^2 complexity)
    public static int diameter2(Node node) {
        if (node == null) {
            return 0;
        }

        int ldia = diameter2(node.left);
        int rdia = diameter2(node.right);

        int dist = height(node.left) + height(node.right) + 2;

        int dia = Math.max(Math.max(ldia, rdia), dist);
        return dia;
    }

    //method 3 -> return DiaHeight pair from childs
    public static class DiaHt {
        int dia;
        int ht;

        DiaHt() {

        }

        DiaHt(int dia, int ht) {
            this.dia = dia;
            this.ht = ht;
        }
    }

    public static DiaHt diameter3(Node node) {
        if (node == null) {
            DiaHt bp = new DiaHt(0, -1);
            return bp;
        }

        DiaHt lp = diameter3(node.left);
        DiaHt rp = diameter3(node.right);

        int dist = lp.ht + rp.ht + 2;

        int dia = Math.max(Math.max(lp.dia, rp.dia), dist);
        int ht = Math.max(lp.ht, rp.ht) + 1;

        DiaHt np = new DiaHt(dia, ht);
        return np;
    }


    public static void main(String[] args) throws Exception {
        //input can be managed
    }

}