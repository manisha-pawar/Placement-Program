import java.util.*;

public class Main {

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

        Pair(Node node,int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[]arr) {
        Node root = new Node(arr[0]);

        Stack<Pair>st = new Stack<>();
        Pair root_pair = new Pair(root,1);

        st.push(root_pair);
        int idx = 1;

        while(st.size() > 0) {
            Pair top = st.peek();

            if(top.state == 1) {
                //waiting for left child
                top.state++;
                if(arr[idx] != null) {
                    Node lc = new Node(arr[idx]);
                    top.node.left = lc;

                    Pair lcp = new Pair(lc,1);
                    st.push(lcp);
                }
                idx++;
            }
            else if(top.state == 2) {
                //waiting for right child
                top.state++;
                if(arr[idx] != null) {
                    Node rc = new Node(arr[idx]);
                    top.node.right = rc;

                    Pair rcp = new Pair(rc,1);
                    st.push(rcp);
                }
                idx++;
            }
            else if(top.state == 3) {
                st.pop();
            }
        }

        return root;

    }

    public static void display(Node node) {
        if(node == null) {
            return;
        }

        String str = " <- " + node.data + " -> ";

        String left = (node.left == null) ? "." :  "" + node.left.data;
        String right = (node.right == null) ? "." : "" + node.right.data;

        str = left + str + right;

        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static void traversal(Node node) {
        if(node == null) {
            return;
        }

        System.out.println(node.data + " pre");
        traversal(node.left);
        System.out.println(node.data + " in");
        traversal(node.right);
        System.out.println(node.data + " post");
    }

    public static void main(String[]args) {
        Integer[]arr = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};

        Node root = construct(arr);

        traversal(root);
    }
}