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

        if (data > node.data) {
            return find(node.right, data);
        } else if (data < node.data) {
            return find(node.left, data);
        } else {
            return true;
        }
    }

    //method 1 -> using find (time - nlogn, space - logn)
    public static void targetSumPair1(Node node, int target, Node oroot) {
        if (node == null) {
            return;
        }

        targetSumPair1(node.left, target, oroot);

        int comp = target - node.data;
        if (comp > node.data) {
            boolean fit = find(oroot, comp);
            if (fit == true) {
                System.out.println(node.data + " " + comp);
            }
        }

        targetSumPair1(node.right, target, oroot);

    }


    //method 2 -> using arraylist (time - n, space - n)
    public static void targetSumPair2(Node node, int target) {
        ArrayList < Integer > list = new ArrayList < > ();
        inorder(node, list);

        int lo = 0;
        int hi = list.size() - 1;

        while (lo < hi) {

            if (list.get(lo) + list.get(hi) < target) {
                lo++;
            } else if (list.get(lo) + list.get(hi) > target) {
                hi--;
            } else {
                System.out.println(list.get(lo) + " " + list.get(hi));
                lo++;
                hi--;
            }
        }

    }

    public static void inorder(Node node, ArrayList < Integer > list) {
        if (node == null) {
            return;
        }

        inorder(node.left, list);
        list.add(node.data);
        inorder(node.right, list);
    }



    //method 3 -> using iterative traversal (time - n, space - logn)
    public static void targetSumPair3(Node node, int target) {

        Stack < Pair > ls = new Stack < > ();
        Stack < Pair > rs = new Stack < > ();

        ls.push(new Pair(node, 0));
        rs.push(new Pair(node, 0));

        int left = inorder(ls);
        int right = reverse_inorder(rs);

        while (left < right) {

            if (left + right < target) {
                left = inorder(ls);
            } else if (left + right > target) {
                right = reverse_inorder(rs);
            } else {
                System.out.println(left + " " + right);

                left = inorder(ls);
                right = reverse_inorder(rs);
            }
        }
    }

    public static int inorder(Stack < Pair > st) {

        while (st.size() > 0) {
            Pair top = st.peek();

            if (top.state == 0) {
                if (top.node.left != null) {
                    Pair lp = new Pair(top.node.left, 0);
                    st.push(lp);
                }
                top.state++;
            } else if (top.state == 1) {
                //inorder
                if (top.node.right != null) {
                    Pair rp = new Pair(top.node.right, 0);
                    st.push(rp);
                }
                top.state++;
                return top.node.data;
            } else if (top.state == 2) {
                st.pop();
            }
        }

        return -1;
    }

    public static int reverse_inorder(Stack < Pair > st) {
        while (st.size() > 0) {
            Pair top = st.peek();

            if (top.state == 0) {
                if (top.node.right != null) {
                    Pair rp = new Pair(top.node.right, 0);
                    st.push(rp);
                }
                top.state++;
            } else if (top.state == 1) {
                //inorder
                if (top.node.left != null) {
                    Pair lp = new Pair(top.node.left, 0);
                    st.push(lp);
                }
                top.state++;
                return top.node.data;
            } else if (top.state == 2) {
                st.pop();
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        //input can be managed
    }

}