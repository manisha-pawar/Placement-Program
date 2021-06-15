import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateEvenOdd(ListNode head) {
        ListNode eh = new ListNode(-1);
        ListNode oh = new ListNode(-1);

        ListNode et = eh;
        ListNode ot = oh;

        ListNode curr = head;

        while (curr != null) {
            if (curr.val % 2 == 0) {
                et.next = curr;
                et = et.next;
            } else {
                ot.next = curr;
                ot = ot.next;
            }
            curr = curr.next;
        }

        ot.next = null; //to avoid cycle creation
        et.next = oh.next;


        return eh.next;

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = segregateEvenOdd(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}