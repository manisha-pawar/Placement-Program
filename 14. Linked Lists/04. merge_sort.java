import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        void addLast(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;

            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }

            size++;
        }

        public int size() {
            return size;
        }

        public void display() {
            for (Node temp = head; temp != null; temp = temp.next) {
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }

        //mid of a linked list
        public int mid() {
            Node slow = head;
            Node fast = head;

            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow.data;
        }

        //merge two sorted linked lists
        public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
            LinkedList l3 = new LinkedList();
            Node head1 = l1.head;
            Node head2 = l2.head;

            while (head1 != null && head2 != null) {
                if (head1.data < head2.data) {
                    l3.addLast(head1.data);
                    head1 = head1.next;
                } else {
                    l3.addLast(head2.data);
                    head2 = head2.next;
                }
            }

            while (head1 != null) {
                l3.addLast(head1.data);
                head1 = head1.next;
            }

            while (head2 != null) {
                l3.addLast(head2.data);
                head2 = head2.next;
            }

            return l3;
        }

        //special mid
        public static Node midNode(Node head, Node tail) {
            Node slow = head;
            Node fast = head;

            while (fast != tail && fast.next != tail) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }

        //merge sort on a linked list
        public static LinkedList mergeSort(Node head, Node tail) {
            if (head == tail) {
                LinkedList base = new LinkedList();
                base.addLast(head.data);

                return base;
            }

            Node m = midNode(head, tail);

            LinkedList left = mergeSort(head, m);
            LinkedList right = mergeSort(m.next, tail);

            LinkedList merged = mergeTwoSortedLists(left, right);

            return merged;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n1 = Integer.parseInt(br.readLine());
        LinkedList l1 = new LinkedList();
        String[] values1 = br.readLine().split(" ");
        for (int i = 0; i < n1; i++) {
            int d = Integer.parseInt(values1[i]);
            l1.addLast(d);
        }

        LinkedList sorted = LinkedList.mergeSort(l1.head, l1.tail);
        sorted.display();
        l1.display();
    }
}