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
    
    public static class ParPair {
        ListNode lh;
        ListNode lt; //pivot node's prev
        ListNode pn;
        
        ParPair() {
            
        }
        
        ParPair(ListNode lh,ListNode lt,ListNode pn) {
            this.lh = lh;
            this.lt = lt;
            this.pn = pn;
        }
    }
    
    public static class QSPair {
        ListNode head;
        ListNode tail;
        
        QSPair() {
            
        }
        
        QSPair(ListNode head,ListNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }
    
    public static QSPair merge(QSPair lp,ListNode pn,QSPair rp) {
        
        if(lp.head == null && rp.head == null) {
            return new QSPair(null,null);
        }
        else if(lp.head == null) {
            //use only pivot and right pair
            pn.next = rp.head;
            return new QSPair(pn,rp.tail);
        }
        else if(rp.head == null) {
            //use only left pair and pivot node
            lp.tail.next = pn;
            return new QSPair(lp.head,pn);
        }
        else {
            //use left pair , pivot node, right pair
            lp.tail.next = pn;
            pn.next = rp.head;
            return new QSPair(lp.head,rp.tail);
        }
    }
    
    public static QSPair quickSortH(ListNode head) {
        if(head == null || head.next == null) {
            return new QSPair(head,head);
        }
        
        ParPair p = partition(head);
        
        
        if(p.lt != null) {
            p.lt.next = null;
        }
        else {
            p.lh = null;
        }
        
        ListNode rh = p.pn.next;
        
        p.pn.next = null;
        
        QSPair lp = quickSortH(p.lh);
        QSPair rp = quickSortH(rh);
        
        QSPair ap = merge(lp,p.pn,rp);
        return ap;
        
    }
    
    public static ListNode quickSort(ListNode head) {
        QSPair ap = quickSortH(head);  
        return ap.head;
    }
    
    public static ParPair partition(ListNode head) {
        
        ListNode tail = getTail(head);
        int data = tail.val;
        
        ListNode sh = new ListNode(-1);
        ListNode gh = new ListNode(-1);
        
        
        ListNode st = sh;
        ListNode gt = gh;
        ListNode stp = null; //smaller tail prev
        
        ListNode curr = head;
        
        while(curr != null) {
            if(curr.val <= data) {
                st.next = curr;
                stp = st;
                st = st.next;
            }
            else {
                gt.next = curr;
                gt = gt.next;
            }
            curr = curr.next;
        }
        
        if(stp == sh) {
            stp = null;
        }
        
        st.next = gh.next;
        gt.next = null;
        
        ParPair p = new ParPair(sh.next,stp,st);
        return p;
    }

    public static ListNode getTail(ListNode head) {
        ListNode temp = head;
        
        while(temp.next != null) {
            temp = temp.next;
        }
        
        return temp;
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

        ListNode head = quickSort(h1);
        printList(head);
    }
}