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

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        
        ListNode dm = new ListNode(-1); //dummy
        ListNode ansH = dm;
        ListNode p1 = l1;
        ListNode p2 = l2;
        
        while(p1 != null && p2 != null) {
            if(p1.val <= p2.val) {
                dm.next = p1;
                p1 = p1.next;
                dm = dm.next;
            }
            else {
                dm.next = p2;
                p2 = p2.next;
                dm = dm.next;
            }
        }
        
        if(p1 != null) {
            dm.next = p1;
        }
        
        if(p2 != null) {
            dm.next = p2;
        }
        
        return ansH.next;
        
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
        int m = scn.nextInt();
        ListNode h2 = createList(m);


        ListNode head = mergeTwoLists(h1, h2);
        printList(head);
    }
}