import java.util.*;

class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode implements Comparable<ListNode>{
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
        
        //-ve return -> this < o
        //+ve return -> this > o
        //0 return -> this == o
        public int compareTo(ListNode o) {
            return this.val - o.val;
        }
    }
    
    public static ListNode mergeTwoSortedLists(ListNode l1,ListNode l2) {
        ListNode dm = new ListNode(-1); //dummy
        ListNode ansH = dm;
        ListNode p1 = l1;
        ListNode p2 = l2;
        
        while(p1 != null && p2 != null)  {
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
    
    //1. divide and conquer
    public static ListNode mergeKLists1(ListNode[] lists) {
        ListNode ml = mergeKListsHelper(lists,0,lists.length-1);
        return ml;
    }
    
    
    public static ListNode mergeKListsHelper(ListNode[]lists,int lo,int hi) {
        if(lo == hi) {
            return lists[lo];
        }
        
        int mid = (lo + hi)/2;
        
        ListNode left = mergeKListsHelper(lists,lo,mid);
        ListNode right = mergeKListsHelper(lists,mid+1,hi);
        
        ListNode ml = mergeTwoSortedLists(left,right);
        return ml;
    }



    //2. using priority queue
    public static ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<ListNode>pq = new PriorityQueue<>();
        
        for(int i=0; i < lists.length;i++) {
            if(lists[i] != null) {
                pq.add(lists[i]);
            }
        }
        
        ListNode dm = new ListNode(-1); // dummy node
        ListNode ansH = dm;
        
        while(pq.size() > 0) {
            ListNode node = pq.remove();
            
            dm.next = node;
            dm = dm.next;
            
            if(node.next != null) {
                pq.add(node.next);
            }
            
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
        ListNode[] list = new ListNode[n];
        for (int i = 0; i < n; i++) {
            int m = scn.nextInt();
            list[i] = createList(m);
        }

        ListNode head = mergeKLists1(list);
        printList(head);
    }
}