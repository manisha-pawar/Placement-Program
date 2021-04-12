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

    public static boolean find(Node node, int data) {
        if (node == null) {
            return false;
        }

        //self check
        if (node.data == data) {
            return true;
        }

        //left child
        boolean fil = find(node.left, data);

        if (fil == true) {
            return true;
        }

        //right child
        boolean fir = find(node.right, data);

        if (fir == true) {
            return true;
        }

        return false;
    }

    public static ArrayList < Integer > nodeToRootPath(Node node, int data) {
        if (node == null) {
            ArrayList < Integer > bl = new ArrayList < > ();
            return bl;
        }

        //self check
        if (node.data == data) {
            ArrayList < Integer > list = new ArrayList < > ();
            list.add(node.data);

            return list;
        }

        //left child
        ArrayList < Integer > n2lcp = nodeToRootPath(node.left, data);

        if (n2lcp.size() > 0) {
            n2lcp.add(node.data); //node to left child path -> node to root path
            return n2lcp;
        }

        //right child
        ArrayList < Integer > n2rcp = nodeToRootPath(node.right, data);

        if (n2rcp.size() > 0) {
            n2rcp.add(node.data); //node to right child path -> node to root path
            return n2rcp;
        }

        return new ArrayList < > ();
    }


    //find and node to root path combined
    public static boolean find2(Node node, int data) {
        if (node == null) {
            return false;
        }

        //self check
        if (node.data == data) {
            n2rp.add(node.data);
            return true;
        }

        //left child
        boolean fil = find2(node.left, data);

        if (fil == true) {
            n2rp.add(node.data);
            return true;
        }

        //right child
        boolean fir = find2(node.right, data);

        if (fir == true) {
            n2rp.add(node.data);
            return true;
        }

        return false;
    }

    static ArrayList < Integer > n2rp;

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

        int data = Integer.parseInt(br.readLine());

        Node root = construct(arr);
        boolean found = find(root, data);
        System.out.println(found);

        ArrayList < Integer > path = nodeToRootPath(root, data);
        System.out.println(path);
    }

}