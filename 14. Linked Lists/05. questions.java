public class Main {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        public void addLast(int val) {
            Node n = new Node();
            n.data = val;
            n.next = null;

            if (size == 0) {
                head = n;
                tail = n;
            } else {
                tail.next = n;
                tail = n;
            }

            size++;
        }

        public int getFirst() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return head.data;
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


        //kth node from last
        public int kthFromLast(int k) {
            Node slow = head;
            Node fast = head;

            for (int i = 0; i < k; i++) {
                fast = fast.next;
            }

            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow.data;
        }

        //remove duplicates from a sorted list
        public void removeDuplicates() {
            LinkedList nl = new LinkedList();

            while (this.size != 0) {
                int val = this.getFirst();
                this.removeFirst();

                if (nl.size == 0 || nl.tail.data != val) {
                    nl.addLast(val);
                }
            }

            this.head = nl.head;
            this.tail = nl.tail;
            this.size = nl.size;
        }
    }

    public static void main(String[] args) {
        //input can be managed
    }

}