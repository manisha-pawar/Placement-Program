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

        public void addLast(int val) {
            Node n = new Node(val, null);

            if (size == 0) {
                head = n;
                tail = n;
            } else {
                tail.next = n;
                tail = n;
            }

            size++;
        }

        public int size() {
            return size;
        }

        public void display() {
            if (size == 0) {
                return;
            }

            Node temp = head;

            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }

            System.out.println();
        }

        public void addFirst(int val) {
            Node n = new Node();
            n.data = val;
            n.next = null;

            if (size == 0) {
                head = n;
                tail = n;
            } else {
                n.next = head;
                head = n;
            }
            size++;
        }

        public void addAt(int idx, int val) {

            if (idx == 0) {
                addFirst(val);
            } else if (idx == size) {
                addLast(val);
            } else if (idx < 0 || idx > size) {
                System.out.println("Invalid arguments");
            } else {
                //find idx-1 node
                Node temp = head;

                for (int i = 1; i < idx; i++) {
                    temp = temp.next;
                }

                Node n = new Node();
                n.data = val;
                n.next = null;

                n.next = temp.next;
                temp.next = n;

                size++;
            }
        }

        public int getFirst() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return head.data;
            }
        }

        public int getLast() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return tail.data;
            }
        }

        public int getAt(int idx) {
            if (idx == 0) {
                return getFirst();
            } else if (idx == size - 1) {
                return getLast();
            } else if (idx < 0 || idx >= size) {
                System.out.println("Invalid arguments");
                return -1;
            } else {
                Node temp = head;

                for (int i = 1; i <= idx; i++) {
                    temp = temp.next;
                }

                return temp.data;
            }
        }

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

        public void removeFirst() {
            if (size == 0) {
                System.out.println("List is empty");
                return;
            } else if (size == 1) {
                head = tail = null;
            } else {
                head = head.next;
            }

            size--;
        }

        public void removeLast() {
            if (size == 0) {
                System.out.println("List is empty");
                return;
            } else if (size == 1) {
                head = null;
                tail = null;
            } else {
                Node sln = getNodeAt(size - 2);
                sln.next = null;

                tail = sln;
            }
            size--;
        }

        public void removeAt(int idx) {
            if (idx == 0) {
                removeFirst();
            } else if (idx == size - 1) {
                removeLast();
            } else if (idx < 0 || idx >= size) {
                System.out.println("Invalid arguments");
            } else {
                Node prev = getNodeAt(idx - 1);
                prev.next = prev.next.next;

                size--;
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList list = new LinkedList();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("addLast")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addLast(val);
            } else if (str.startsWith("size")) {
                System.out.println(list.size());
            } else if (str.startsWith("display")) {
                list.display();
            } else if (str.startsWith("removeFirst")) {
                list.removeFirst();
            } else if (str.startsWith("getFirst")) {
                int val = list.getFirst();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("getLast")) {
                int val = list.getLast();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("getAt")) {
                int idx = Integer.parseInt(str.split(" ")[1]);
                int val = list.getAt(idx);
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("addFirst")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addFirst(val);
            } else if (str.startsWith("addAt")) {
                int idx = Integer.parseInt(str.split(" ")[1]);
                int val = Integer.parseInt(str.split(" ")[2]);
                list.addAt(idx, val);
            } else if (str.startsWith("removeLast")) {
                list.removeLast();
            } else if (str.startsWith("removeAt")) {
                int idx = Integer.parseInt(str.split(" ")[1]);
                list.removeAt(idx);
            }
            str = br.readLine();
        }
    }
}