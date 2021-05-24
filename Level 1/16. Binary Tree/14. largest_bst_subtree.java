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

    public static class BSTPair {
        int min;
        int max;
        boolean isBST;
        int size;
        Node root;

        BSTPair() {

        }

        BSTPair(int min, int max, boolean isBST, int size, Node root) {
            this.min = min;
            this.max = max;
            this.isBST = isBST;
            this.size = size;
            this.root = root;
        }
    }

    public static BSTPair largestBSTSubtree(Node node) {
        if (node == null) {
            return new BSTPair(Integer.MAX_VALUE, Integer.MIN_VALUE, true, 0, null);
        }

        BSTPair lp = largestBSTSubtree(node.left);
        BSTPair rp = largestBSTSubtree(node.right);

        boolean isBST = (lp.max < node.data && rp.min > node.data) && lp.isBST && rp.isBST;
        int min = Math.min(Math.min(lp.min, rp.min), node.data);
        int max = Math.max(Math.max(lp.max, rp.max), node.data);

        Node root = null;
        int size = 0;

        if (isBST == true) {
            root = node;
            size = lp.size + rp.size + 1;
        } else if (lp.size > rp.size) {
            root = lp.root;
            size = lp.size;
        } else {
            root = rp.root;
            size = rp.size;
        }

        BSTPair np = new BSTPair(min, max, isBST, size, root);
        return np;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        Node root = construct(arr);

        BSTPair ans = largestBSTSubtree(root);
        System.out.print(ans.root.data + "@" + ans.size);
    }

}