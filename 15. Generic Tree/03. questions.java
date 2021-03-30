import java.util.*;

public class Main {

    public static class Node {
        int data;
        ArrayList < Node > children = new ArrayList < > ();
    }

    public static Node construct(int[] data) {
        Stack < Node > st = new Stack < > ();
        Node root = null;

        for (int i = 0; i < data.length; i++) {
            int val = data[i];

            if (val == -1) {
                st.pop();
            } else {
                //creata a node
                Node n = new Node();
                n.data = val;

                if (st.size() > 0) {
                    st.peek().children.add(n);
                } else {
                    //first node
                    root = n;
                }
                st.push(n);
            }
        }

        return root;
    }

    public static void display(Node node) {
        //print node and its children
        System.out.print(node.data + "->");
        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            System.out.print(child.data + ",");
        }
        System.out.println(".");

        //faith on node's children
        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            display(child);
        }
    }

    //preorder & postorder traversals
    public static void traversals(Node node) {
        //node pre
        System.out.println("Node Pre " + node.data);

        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            //edge pre
            System.out.println("Edge Pre " + node.data + "--" + child.data);

            //call -> edge
            traversals(child);

            //edge post
            System.out.println("Edge Post " + node.data + "--" + child.data);
        }

        //node post
        System.out.println("Node Post " + node.data);
    }


    //level-order traversal
    public static void levelOrder(Node node) {
        Queue < Node > q = new ArrayDeque < > ();

        q.add(node);

        while (q.size() > 0) {
            Node rem = q.remove(); // remove

            System.out.print(rem.data + " "); // print

            // add children
            for (int i = 0; i < rem.children.size(); i++) {
                Node rch = rem.children.get(i);
                q.add(rch);
            }
        }
        System.out.println(".");

    }


    //level-order linewise traversal
    public static void levelOrderLinewise(Node node) {
        Queue < Node > mq = new ArrayDeque < > ();
        Queue < Node > cq = new ArrayDeque < > ();

        mq.add(node);

        while (mq.size() > 0) {
            Node rem = mq.remove();

            System.out.print(rem.data + " ");

            for (int i = 0; i < rem.children.size(); i++) {
                Node rch = rem.children.get(i);
                cq.add(rch);
            }

            if (mq.size() == 0) {
                mq = cq;
                cq = new ArrayDeque < > ();
                System.out.println();
            }
        }
    }


    //levelorder zigzag traversal
    public static void levelOrderLinewiseZZ(Node node) {
        Stack < Node > ms = new Stack < > ();
        Stack < Node > cs = new Stack < > ();
        int lev = 1;
        ms.push(node);

        while (ms.size() > 0) {
            Node rem = ms.pop();

            System.out.print(rem.data + " ");

            if (lev % 2 == 1) {
                //odd level -> left ro right
                for (int i = 0; i < rem.children.size(); i++) {
                    Node rch = rem.children.get(i);
                    cs.push(rch);
                }
            } else {
                //even level -> right to left
                for (int i = rem.children.size() - 1; i >= 0; i--) {
                    Node rch = rem.children.get(i);
                    cs.push(rch);
                }
            }

            if (ms.size() == 0) {
                ms = cs;
                cs = new Stack < > ();
                lev++;
                System.out.println();
            }
        }
    }


    //mirror of a generic tree
    public static void mirror(Node node) {
        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            mirror(child);
        }

        //reverse node's children arraylist
        int lo = 0;
        int hi = node.children.size() - 1;

        while (lo < hi) {
            Node left = node.children.get(lo);
            Node right = node.children.get(hi);

            node.children.set(lo, right);
            node.children.set(hi, left);

            lo++;
            hi--;
        }

    }


    //remove leaves from a generic tree
    public static void removeLeaves(Node node) {
        for (int i = node.children.size() - 1; i >= 0; i--) {
            Node child = node.children.get(i);

            if (child.children.size() == 0) {
                node.children.remove(i);
            }

        }

        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            removeLeaves(child);
        }
    }

    public static void main(String[] args) {
        //input can be managed
        int[]arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

        Node root = construct(arr);
        display(root);
    }
}