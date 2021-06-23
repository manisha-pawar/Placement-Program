import java.util.*;

class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregate01(ListNode head) {
        ListNode dzh = new ListNode(-1); //dummy zero head
        ListNode dzt = dzh; //dummy zero tail

        ListNode doh = new ListNode(-1); //dummy one head
        ListNode dot = doh; //dummy one tail

        ListNode curr = head;

        while (curr != null) {
            if (curr.val == 1) {
                dot.next = curr;
                dot = dot.next;
            } else {
                dzt.next = curr;
                dzt = dzt.next;
            }
            curr = curr.next;
        }

        dot.next = null;
        dzt.next = doh.next;

        return dzh.next;

    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode createList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode h1 = createList(n);
        h1 = segregate01(h1);
        printList(h1);
    }
}