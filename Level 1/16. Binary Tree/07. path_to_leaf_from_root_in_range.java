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


    public static void pathToLeafFromRoot(Node node, String path, int sum, int lo, int hi) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            path += node.data;
            sum += node.data;
            if (sum > lo && sum < hi) {
                System.out.println(path);
            }
            return;
        }

        pathToLeafFromRoot(node.left, path + node.data + " ", sum + node.data, lo, hi);
        pathToLeafFromRoot(node.right, path + node.data + " ", sum + node.data, lo, hi);
    }

    //using arraylist as path
    public static void pathToLeafFromRoot2(Node node, ArrayList < Integer > path, int sum, int lo, int hi) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            path.add(node.data);
            sum += node.data;

            if (sum > lo && sum < hi) {
                for (int i = 0; i < path.size(); i++) {
                    System.out.print(path.get(i) + " ");
                }
                System.out.println();
            }

            path.remove(path.size() - 1);
            return;
        }

        path.add(node.data);
        pathToLeafFromRoot2(node.left, path, sum + node.data, lo, hi);
        pathToLeafFromRoot2(node.right, path, sum + node.data, lo, hi);
        path.remove(path.size() - 1);
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

        int lo = Integer.parseInt(br.readLine());
        int hi = Integer.parseInt(br.readLine());

        Node root = construct(arr);
        pathToLeafFromRoot(root, "", 0, lo, hi);
    }

}