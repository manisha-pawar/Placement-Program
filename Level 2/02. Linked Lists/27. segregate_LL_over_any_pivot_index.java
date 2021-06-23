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

    public static ListNode getNodeAt(ListNode head, int idx) {
        ListNode temp = head;

        while (idx-- > 0) {
            temp = temp.next;
        }

        return temp;
    }
    public static ListNode segregate(ListNode head, int pivotIdx) {
        ListNode sh = new ListNode(-1); //smaller head
        ListNode gh = new ListNode(-1); //greater head

        ListNode st = sh; //smaller tail
        ListNode gt = gh; //greater

        ListNode pn = getNodeAt(head, pivotIdx); //pivot node
        int data = pn.val;

        ListNode curr = head;

        while (curr != null) {
            if (pn == curr) {
                //ignore this node
            } else if (curr.val <= data) {
                st.next = curr;
                st = st.next;
            } else if (curr.val > data) {
                gt.next = curr;
                gt = gt.next;
            }
            curr = curr.next;
        }

        st.next = pn;
        pn.next = gh.next;
        gt.next = null;

        return sh.next;
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
        int idx = scn.nextInt();
        h1 = segregate(h1, idx);
        printList(h1);
    }
}