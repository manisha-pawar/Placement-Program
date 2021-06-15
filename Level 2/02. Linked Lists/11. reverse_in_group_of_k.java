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

    static ListNode ch = null;
    static ListNode ct = null;
    
    public static void addFirst(ListNode node) {
        if(ch == null) {
            ch = node;
            ct = node;
        }
        else {
            node.next = ch;
            ch = node;
        }
    } 
    
    public static int size(ListNode head) {
        ListNode temp = head;
        int s = 0;
        
        while(temp != null) {
            temp = temp.next;
            s++;
        }
        
        return s;
    }
    
    public static ListNode reverseInKGroup2(ListNode head, int k) {
        ListNode oh = new ListNode(-1);
        ListNode ot = oh;

        ListNode curr = head;
        int nrsf = size(head);
        
        if(k == 0) {
            return head;
        }
        
        while(nrsf >= k) {
            //work on k nodes
            int temp = k;
            ch = null;
            ct = null;
            
            while(temp-- > 0) {
                ListNode next = curr.next;
                
                curr.next = null; 
                
                //addfirst
                addFirst(curr);
                
                curr = next;
            }
            
            if(oh == ot) {
                //this is first group
                oh.next = ch;
                ot = ct;
            }
            else {
                ot.next = ch;
                ot = ct;
            }
            
            nrsf -= k;
        }
        
        if(nrsf > 0) {
            ot.next = curr;
        }
        
        return oh.next;
    }

     public static ListNode reverseInKGroup1(ListNode head, int k) {
        ListNode ansH = null;
        ListNode ansT = null;
        ListNode curr = head;
        
        int nrsf = size(head);
        
        if(nrsf < k || k == 0) {
            return head;
        }
        
        while(nrsf >= k) {
            //work for k nodes
            ListNode prev = null;
            ListNode oc = curr;
            
            int temp = k;
            while(temp-- > 0) {
                //preserve
                ListNode next = curr.next;
                
                //links
                curr.next = prev;
                
                //move
                prev = curr;
                curr = next;
            }
            
            if(ansH == null) {
                //this is first group
                ansH = prev;
                ansT = oc;
            }
            else {
                //make connection between ans so far & current group
                ansT.next = prev;
                ansT = oc;
            }
            
            nrsf -= k;
        }
        
        
        if(nrsf > 0) {
            ansT.next = curr;
        }
        
        return ansH;

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

        int k = scn.nextInt();
        h1 = reverseInKGroup1(h1, k);
        printList(h1);
    }
}