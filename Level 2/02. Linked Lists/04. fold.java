import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

     public static ListNode middleOfLL(ListNode head) {
        if(head == null) {
            return null;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
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
    
    public static void fold(ListNode head) {
        if(head == null) {
            return;    
        }
        
        ListNode mid = middleOfLL(head);
        ListNode nh = mid.next;
        mid.next = null;
        nh = reverseOfLL(nh);
        
        ListNode p1 = head;
        ListNode p2 = nh;
        
        while(p2 != null) {
            //preserve
            ListNode n1 = p1.next;
            ListNode n2 = p2.next;
            
            //links
            p1.next = p2;
            p2.next = n1;
            
            //move
            p1 = n1;
            p2 = n2;
        }
        
        
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
        fold(head);
        printList(head);
    }
}