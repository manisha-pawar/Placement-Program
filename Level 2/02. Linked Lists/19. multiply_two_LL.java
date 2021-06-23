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

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static ListNode singleDigitWithLLMult(ListNode l1, int d) {
        ListNode dh = new ListNode(-1);
        ListNode itr = dh;

        ListNode c1 = l1;
        int carry = 0;

        while (c1 != null || carry != 0) {
            int mult = carry;

            if (c1 != null) {
                mult += c1.val * d;
                c1 = c1.next;
            }

            int val = mult % 10;
            carry = mult / 10;

            itr.next = new ListNode(val);
            itr = itr.next;
        }

        return dh.next;

    }

    public static void addTwoLL(ListNode spdll, ListNode ptr) {

        ListNode c2 = spdll;
        ListNode c1 = ptr;

        int carry = 0;

        //c1.next and c2 will interact
        while (c1.next != null || c2 != null || carry != 0) {
            int sum = carry;

            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }

            if (c1.next != null) {
                sum += c1.next.val;
            } else {
                c1.next = new ListNode(0);
            }

            int val = sum % 10;
            carry = sum / 10;

            c1.next.val = val;
            c1 = c1.next;
        }


    }

    public static ListNode multiplyTwoLL(ListNode l1, ListNode l2) {
        ListNode oah = new ListNode(-1);
        ListNode ptr = oah;

        ListNode c1 = reverse(l1);
        ListNode c2 = reverse(l2);

        while (c2 != null) {
            int d = c2.val;
            c2 = c2.next;

            ListNode spdll = singleDigitWithLLMult(c1, d);

            addTwoLL(spdll, ptr);

            ptr = ptr.next;
        }

        return reverse(oah.next);
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
        ListNode head1 = makeList(scn.nextInt());
        ListNode head2 = makeList(scn.nextInt());

        ListNode ans = multiplyTwoLL(head1, head2);
        printList(ans);
    }

}