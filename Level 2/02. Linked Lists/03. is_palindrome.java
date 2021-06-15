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
    
    public static boolean isPalindrome(ListNode head) {
        if(head == null) {
            return true;
        }
        
        ListNode mid = middleOfLL(head);
        ListNode nh = mid.next;
        
        mid.next = null;
        
        nh = reverseOfLL(nh);
        
        ListNode p1 = head;
        ListNode p2 = nh;
        boolean isPal = true;
        
        while(p2 != null) {
            if(p1.val != p2.val) {
               isPal = false;
               break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        
        
        //to undo our change in original linked list
        nh = reverseOfLL(nh);
        mid.next = nh;
        
        return isPal;
        
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

        System.out.println(isPalindrome(dummy.next));
    }
}