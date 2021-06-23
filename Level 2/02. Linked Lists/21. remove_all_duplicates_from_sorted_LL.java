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

    public static ListNode removeDuplicates(ListNode head) {
        ListNode dh = new ListNode(-1);
        ListNode dt = dh;
        ListNode curr = head;
        boolean isDup = false;

        while (curr != null) {
            isDup = false;

            ListNode next = curr.next;
            while (curr != null && next != null) {
                if (curr.val != next.val) {
                    break;
                }
                isDup = true;
                curr = next;
                next = next.next;
            }

            if (isDup == false) {
                //we should use curr
                dt.next = curr;
                dt = dt.next;
            }

            curr = next;
        }

        dt.next = null;

        return dh.next;
    }

    // InFput_code===================================================

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode makeList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = makeList(scn.nextInt());

        ListNode ans = removeDuplicates(head);
        printList(ans);
    }

}