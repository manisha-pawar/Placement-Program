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
        ListNode fo = null; //first one
        ListNode curr = head;

        while (curr != null) {
            if (curr.val == 1) {
                if (fo == null) {
                    //this is first one
                    fo = curr;
                }
            } else {
                if (fo != null) {
                    //swap curr(0) with first one node(1)
                    fo.val = 0;
                    curr.val = 1;
                    fo = fo.next;
                }
            }
            curr = curr.next;
        }

        return head;
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