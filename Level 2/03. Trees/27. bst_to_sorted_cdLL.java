import java.util.Scanner;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class Node {
        int val = 0;
        Node left = null;
        Node right = null;

        Node(int val) {
            this.val = val;
        }
    }

    static Node prev;

    public static void helper(Node node) {
        if (node == null) {
            return;
        }

        helper(node.left);

        //work & update
        prev.right = node;
        node.left = prev;
        prev = node;

        helper(node.right);

    }


    //1. using recursion
    public static Node bToDLL(Node root) {
        Node dummy = new Node(-1);
        prev = dummy;

        helper(root);

        //work
        Node head = dummy.right;
        Node tail = prev;

        //to convert dll to cdll
        head.left = tail;
        tail.right = head;

        return head;

    }



    //2. using morris traversal
    public static Node rightMostNode(Node node, Node curr) {
        Node temp = node;

        while (temp.right != null && temp.right != curr) {
            temp = temp.right;
        }

        return temp;
    }

    public static Node bToDLL(Node root) {
        Node dummy = new Node(-1);
        Node prev = dummy;

        Node curr = root;

        while (curr != null) {
            Node ln = curr.left;

            if (ln == null) {
                //links
                prev.right = curr;
                curr.left = prev;

                //move
                prev = curr;
                curr = curr.right;
            } else {
                Node rmn = rightMostNode(ln, curr);

                if (rmn.right == null) {
                    //create a thread then go to left subtree
                    rmn.right = curr;
                    curr = curr.left;
                } else if (rmn.right == curr) {
                    //left subtree is done, break the link and then go to right
                    rmn.right = null;

                    //links
                    prev.right = curr;
                    curr.left = prev;

                    //move
                    prev = curr;
                    curr = curr.right;
                }
            }
        }


        //work
        Node head = dummy.right;
        Node tail = prev;

        //to convert dll to cdll
        head.left = tail;
        tail.right = head;

        return head;
    }


    // input_section=================================================

    public static void display(Node node) {
        Node head = node;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.right;
            if (node == head)
                break;
        }

    }

    public static Node constructFromInOrder_(int[] in , int si, int ei) {
        if (si > ei)
            return null;

        int mid = (si + ei) / 2;
        Node node = new Node( in [mid]);

        node.left = constructFromInOrder_( in , si, mid - 1);
        node.right = constructFromInOrder_( in , mid + 1, ei);

        return node;
    }

    public static Node constructFromInOrder(int[] inOrder) {
        int n = inOrder.length;
        return constructFromInOrder_(inOrder, 0, n - 1);
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in [i] = scn.nextInt();

        Node root = constructFromInOrder( in );
        root = bToDLL(root);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}