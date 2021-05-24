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

    //node to root path
    public static ArrayList < Integer > nodeToRootPath(Node node, int data) {
        if (node.data == data) {
            ArrayList < Integer > base = new ArrayList < > ();
            base.add(data);
            return base;
        }

        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);

            ArrayList < Integer > n2cp = nodeToRootPath(child, data); //node to child path

            if (n2cp.size() > 0) {
                n2cp.add(node.data); //node to child path -> node to root path
                return n2cp;
            }
        }

        return new ArrayList < > ();
    }


    //5-04-2021
    //lowest common ancestor
    public static int lca(Node node, int d1, int d2) {
        ArrayList < Integer > p1 = nodeToRootPath(node, d1);
        ArrayList < Integer > p2 = nodeToRootPath(node, d2);

        int i = p1.size() - 1;
        int j = p2.size() - 1;

        while (i >= 0 && j >= 0 && p1.get(i) == p2.get(j)) {
            i--;
            j--;
        }

        return p1.get(i + 1);
    }


    //distance between two nodes
    public static int distanceBetweenNodes(Node node, int d1, int d2) {
        ArrayList < Integer > p1 = nodeToRootPath(node, d1);
        ArrayList < Integer > p2 = nodeToRootPath(node, d2);

        int i = p1.size() - 1;
        int j = p2.size() - 1;

        while (i >= 0 && j >= 0 && p1.get(i) == p2.get(j)) {
            i--;
            j--;
        }

        i++;
        j++;

        return i + j;
    }


    //are trees similar in shape
    public static boolean areSimilar(Node n1, Node n2) {
        if (n1.children.size() != n2.children.size()) {
            return false;
        }

        for (int i = 0; i < n1.children.size(); i++) {
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(i);

            boolean areSC = areSimilar(c1, c2);

            if (areSC == false) {
                return false;
            }
        }

        return true;
    }


    //are trees mirror in shape
    public static boolean areMirror(Node n1, Node n2) {
        if (n1.children.size() != n2.children.size()) {
            return false;
        }


        for (int i = 0; i < n1.children.size(); i++) {
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(n2.children.size() - i - 1);

            boolean areMirrorC = areMirror(c1, c2);

            if (areMirrorC == false) {
                return false;
            }
        }

        return true;
    }


    //is generic tree symmetric
    public static boolean IsSymmetric(Node node) {
        return areMirror(node, node);
    }


    //multisolver
    static int size;
    static int max;
    static int min;
    static int height;

    public static void multisolver(Node node,int lev) {
        size++;
        max = Math.max(max,node.data);
        min = Math.min(min,node.data);
        height = Math.max(height,lev);

        for(int i=0;i < node.children.size();i++) {
            Node child = node.children.get(i);
            multisolver(child,lev+1);
        }
    }


    //predecessor & successor
    static Node predecessor;
    static Node successor;

    //method 1 - prev & curr
    static Node prev;
    static Node curr;

    public static void predecessorAndSuccessor1(Node node, int data) {
        prev = curr;
        curr = node;

        if (curr.data == data) {
            predecessor = prev;
        }

        if (prev != null && prev.data == data) {
            successor = curr;
        }

        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            predecessorAndSuccessor1(child, data);
        }
    }


    //method 2 - state method
    static int state;

    public static void predecessorAndSuccessor2(Node node, int data) {
        if (state == 0) {
            if (node.data == data) {
                state = 1;
            } else {
                predecessor = node;
            }
        } else if (state == 1) {
            successor = node;
            state = 2;
        }

        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            predecessorAndSuccessor2(child, data);
        }
    }

    //6-04-2021
    //ceil and floor
    static int ceil;
    static int floor;

    public static void ceilAndFloor(Node node, int data) {
        //ceil
        if (node.data > data && ceil > node.data) {
            ceil = node.data;
        }

        //floor
        if (node.data < data && floor < node.data) {
            floor = node.data;
        }

        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            ceilAndFloor(child, data);
        }
    }


    //kth largest element
    public static int kthLargest(Node node, int k) {
        int data = Integer.MAX_VALUE;

        for (int i = 0; i < k; i++) {
            floor = Integer.MIN_VALUE;
            ceilAndFloor(node, data);
            data = floor;
        }

        return data;
    }


    //node with maximum subtree sum
    static int maxSSum;
    static Node mssNode;
    
    public static void maxSubtreeSum(Node root) {
        maxSSum = Integer.MIN_VALUE; //max subtree sum
        mssNode = null; //mas subtree sum node

        subtreeSum(root);
    }

    public static int subtreeSum(Node node) {
        int sum = 0;

        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            int chss = subtreeSum(child); //child subtree sum

            sum += chss;
        }

        sum += node.data;

        if (sum > maxSSum) {
            maxSSum = sum;
            mssNode = node;
        }

        return sum;

    }


    //diameter of a generic subtree
    static int dia;
    public static void diameter(Node root) {
        dia = 0;
        height(root);
    }

    public static int height(Node node) {
        int chbht = -1;
        int chsbht = -1;

        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            int cht = height(child);

            if (cht > chbht) {
                chsbht = chbht;
                chbht = cht;
            } else if (cht > chsbht) {
                chsbht = cht;
            }
        }

        int dist = chbht + chsbht + 2;

        if (dist > dia) {
            dia = dist;
        }

        return chbht + 1;
    }


    //iterative pre-order & post-order
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


    public static void IterativePreAndPostOrder(Node node) {
        Stack < Pair > st = new Stack < > ();
        Pair bp = new Pair(node, -1);
        st.push(bp);

        String pre = "";
        String post = "";

        while (st.size() > 0) {
            Pair top = st.peek();

            if (top.state == -1) {
                //pre
                pre += (top.node.data + " ");
                top.state++;
            } else if (top.state == top.node.children.size()) {
                //post
                post += (top.node.data + " ");
                st.pop();
            } else {
                Node child = top.node.children.get(top.state);
                Pair cp = new Pair(child, -1);
                st.push(cp);
                top.state++;
            }
        }

        System.out.println(pre);
        System.out.println(post);
    }


    public static void main(String[] args) {
       //input can be managed, must initialise static variables with their identity value before function call
       int[]arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

       Node root = construct(arr);
       size = 0;
       max = Integer.MIN_VALUE;
       min = Integer.MAX_VALUE;
       height = 0;

       multisolver(root,0);

       System.out.println("Size = " + size);
       System.out.println("Max = " + max);
       System.out.println("Min = " + min);
       System.out.println("Height = " + height);
    }
}