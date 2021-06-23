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
    
    public static ListNode getTail(ListNode head) {
        ListNode temp = head;
        
        while(temp.next != null) {
            temp = temp.next;
        }
        
        return temp;
    }
    
    public static ListNode segregateOnLastIndex(ListNode head) {
        ListNode sh = new ListNode(-1); //smaller head
        ListNode gh = new ListNode(-1); //greater head
        
        ListNode st = sh; // smaller tail
        ListNode gt = gh; //greater tail
        
        ListNode pivot = getTail(head);
        int data = pivot.val;
        
        ListNode curr = head;
        
        while(curr != null) {
            if(curr.val <= data) {
                st.next = curr;
                st = st.next;
            }
            else {
                gt.next = curr;
                gt = gt.next;
            }
            
            curr = curr.next;
        }
        
        st.next = gh.next;
        gt.next = null;
        
        return st;
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
        h1 = segregateOnLastIndex(h1);
        printList(h1);
    }
}