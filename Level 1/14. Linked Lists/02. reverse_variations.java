import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int data;
        Node next;

        Node() {

        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        private Node getNodeAt(int idx) {
            if (size == 0) {
                System.out.println("List is empty");
                return null;
            } else if (idx < 0 || idx >= size) {
                System.out.println("Invalid arguments");
                return null;
            } else {
                Node temp = head;
                for (int i = 0; i < idx; i++) {
                    temp = temp.next;
                }
                return temp;
            }
        }

        //reverse data iteratively
        public void reverseDI() {
            int li = 0;
            int ri = size - 1;

            while (li < ri) {
                Node left = getNodeAt(li);
                Node right = getNodeAt(ri);

                int temp = left.data;
                left.data = right.data;
                right.data = temp;

                li++;
                ri--;
            }

        }

        //reverse pointer iteratively
        public void reversePI() {
            Node prev = null;
            Node curr = head;

            while (curr != null) {
                Node next = curr.next;
                curr.next = prev;

                prev = curr;
                curr = next;

            }

            //swapping head & tail
            Node temp = head;
            head = tail;
            tail = temp;
        }

        //reverse data recursively
        public void reverseDR() {
            //reverseDRHelper1(head,head,0);
            left = head;
            reverseDRHelper2(head, 0);

        }

        private Node reverseDRHelper1(Node head, Node right, int flag) {
            if (right == null) {
                return head;
            }

            Node left = reverseDRHelper1(head, right.next, flag + 1);

            if (flag >= size / 2) {
                int temp = left.data;
                left.data = right.data;
                right.data = temp;
            }

            return left.next;
        }

        Node left;
        private void reverseDRHelper2(Node right, int flag) {
            if (right == null) {
                return;
            }

            reverseDRHelper2(right.next, flag + 1);

            if (flag >= size / 2) {
                int temp = left.data;
                left.data = right.data;
                right.data = temp;
            }

            left = left.next;
        }

        //reverse pointer recursively
        public void reversePR() {

            reversePRHelper(head);
            head.next = null;

            Node temp = head;
            head = tail;
            tail = temp;
        }

        private void reversePRHelper(Node node) {
            if (node == tail) {
                return;
            }

            reversePRHelper(node.next);

            Node c = node;
            Node n = node.next;

            n.next = c;
        }

        //display linked list in reverse order
        public void displayReverse() {
            displayReverseHelper(head);
            System.out.println();
        }

        private void displayReverseHelper(Node node) {
            if (node == null) {
                return;
            }

            displayReverseHelper(node.next);
            System.out.print(node.data + " ");

        }

    }

    public static void main(String[] args) throws Exception {
        LinkedList list = new LinkedList();
        //input can be managed as per question requirements
    }
}