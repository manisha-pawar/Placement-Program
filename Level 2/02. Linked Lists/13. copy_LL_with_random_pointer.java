import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;
        ListNode random = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    //1. using space, i.e with the help of hashmap
     public static ListNode copyRandomList1(ListNode head) {
        //1. copy values and next pointer
        ListNode dm = new ListNode(-1); //dummy
        ListNode dh = dm;
        
        HashMap<ListNode,ListNode>map = new HashMap<>();
        ListNode curr = head;
        
        while(curr != null) {
            ListNode nn = new ListNode(curr.val);
            dm.next = nn;
            dm = dm.next;
            
            map.put(curr,nn); //a -> a'
            curr = curr.next;
        }
        
        //2. to set random pointers
        ListNode p1 = head;
        ListNode p2 = dh.next;
        
        while(p1 != null) {
            ListNode p1r = p1.random;
            p2.random = map.get(p1r);

            p1 = p1.next;
            p2 = p2.next;
        }
        
        return dh.next;
        
    }


    //2. without using extra space
    public static ListNode copyRandomList2(ListNode head) {
        //1. introduce new nodes between old nodes
        ListNode curr = head;
        
        while(curr != null) {
            //preserve
            ListNode next = curr.next;
            
            //create copy node
            ListNode nn = new ListNode(curr.val);
            
            //links
            curr.next = nn;
            nn.next = next;
            
            //move
            curr = next;
        }
        
        
        //2. set random pointers
        ListNode c1 = head;
        ListNode c2 = head.next;
        
        while(c1 != null) {
            c2.random = (c1.random != null) ? c1.random.next : null;
            
            c1 = c1.next.next;
            
            if(c2.next != null) {
                c2 = c2.next.next;
            }
        }
        
        
        //3. segregate original list and copied list
        c1 = head;
        c2 = head.next;
        ListNode clh = c2;
        
        while(c1 != null) {
            ListNode n1 = c1.next.next;
            
            ListNode n2 = null;
            
            if(c2.next != null) {
                n2 = c2.next.next;
            }
            
            c1.next = n1;
            c2.next = n2;
            
            c1 = n1;
            c2 = n2;
        }
        
        return clh;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        ListNode[] arr = new ListNode[n];
        ListNode prev = null;

        for (int i = 0; i < n; i++) {
            arr[i] = new ListNode(0);
            if (prev != null)
                prev.next = arr[i];
            prev = arr[i];
        }

        for (int i = 0; i < n; i++) {
            int val = scn.nextInt();
            int idx = scn.nextInt();

            arr[i].val = val;
            if(idx != -1) arr[i].random = arr[idx];
        }

        ListNode head = copyRandomList(arr[0]);
        while (head != null) {
            System.out.print("(" + head.val + ", " + (head.random != null ? head.random.val : -1) + ") ");
            head = head.next;
        }
    }
}