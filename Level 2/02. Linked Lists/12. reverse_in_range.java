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

    static ListNode ch;
    static ListNode ct;

    public static void addFirst(ListNode node) {
        if (ch == null) {
            ch = ct = node;
        } else {
            node.next = ch;
            ch = node;
        }
    }

    public static ListNode reverseInRange(ListNode head, int n, int m) {
        ListNode prev = null;
        ListNode curr = head;
        int idx = 1;

        //   if(n <= 0 || m > size(head)) {
        //       return head;
        //   }

        while (idx <= m + 1) {
            if (idx < n) {
                //pre working area
                prev = curr;
                curr = curr.next;
            } 
            else if (idx >= n && idx <= m) {
                //working area -> reverse
                ListNode next = curr.next;
                curr.next = null;
                addFirst(curr);
                curr = next;
            } 
            else if (idx > m) {
                if (prev == null) {
                    //when n == 1
                    ct.next = curr;
                    return ch;
                }

                prev.next = ch;
                ct.next = curr;
            }
            idx++;
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
        int sz = scn.nextInt();
        ListNode h1 = createList(sz);

        int m = scn.nextInt();
        int n = scn.nextInt();

        h1 = reverseInRange(h1, m, n);
        printList(h1);
    }
}