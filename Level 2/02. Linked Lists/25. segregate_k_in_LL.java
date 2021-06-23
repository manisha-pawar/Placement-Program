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


    public static ListNode segregateK(ListNode head, int k) {

        ListNode[] dh = new ListNode[k]; //array of dummy heads
        ListNode[] dt = new ListNode[k]; //array of dummy tails

        for (int i = 0; i < k; i++) {
            dh[i] = new ListNode(-1);
            dt[i] = dh[i];
        }

        ListNode curr = head;

        while (curr != null) {
            int d = curr.val;

            dt[d].next = curr;
            dt[d] = dt[d].next;
            curr = curr.next;
        }

        dt[k - 1].next = null;

        int idx = k - 1;

        while (idx > 0) {
            ListNode im1t = dt[idx - 1]; //(i-1)th tail
            ListNode ih = dh[idx]; //ith head

            im1t.next = ih.next;
            idx--;
        }

        return dh[0].next;
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
        h1 = segregateK(h1, 6);
        printList(h1);
    }
}