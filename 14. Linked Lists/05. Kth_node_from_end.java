public class Main {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;


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
    }

    public static void main(String[]args) {
        //input can be managed
    }

}