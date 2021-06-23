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

   
    static ListNode th = null;
    static ListNode tt = null;
    
    public static void addLast(ListNode node) {
        if(th == null) {
            th = tt = node;
        }    
        else {
            tt.next = node;
            tt = tt.next;
        }
    }
    
    //using addLast
    public static ListNode removeDuplicates1(ListNode head) {
        
        ListNode curr = head;
        
        while(curr != null) {
            
            ListNode next = curr.next;
            curr.next = null;
            
            if(tt == null || tt.val != curr.val) {
                addLast(curr);
            }
            
            curr = next;
        }
        
        return th;
    }


    //using dummy node
    public static ListNode removeDuplicates2(ListNode head) {
        ListNode dh = new ListNode(Integer.MAX_VALUE);
        ListNode dt = dh;

        ListNode curr = head;

        while (curr != null) {
            if (curr.val != dt.val) {
                dt.next = curr;
                dt = dt.next;
            }
            curr = curr.next;
        }

        dt.next = null;

        return dh.next;
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
        ListNode head = makeList(scn.nextInt());

        ListNode ans = removeDuplicates(head);
        printList(ans);
    }

}