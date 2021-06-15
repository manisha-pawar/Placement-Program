import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverseOfLL(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null) {
            //preserve
            ListNode next = curr.next;
            
            //links
            curr.next = prev;
            
            //move
            prev = curr;
            curr = next;
        }
        
        return prev;
    }

    public static void unfold(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }
        
        ListNode h1 = head;
        ListNode h2 = head.next;
        
        ListNode p1 = h1;
        ListNode p2 = h2;
        
        while(p2 != null && p2.next != null) {
            //preserve
            ListNode n1 = p1.next;
            ListNode n2 = p2.next;
            
            //links
            p1.next = n2;
            p2.next = n2.next;
            
            //move
            p1 = p1.next;
            p2 = p2.next;
        }
        
        p1.next = null;
        h2 = reverseOfLL(h2);
        p1.next = h2;
        
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
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

        ListNode head = dummy.next;
        unfold(head);
        printList(head);
    }
}