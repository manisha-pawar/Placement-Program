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

    public static ListNode segregate012(ListNode head) {
        ListNode zh = new ListNode(-1); //zero head
        ListNode oh = new ListNode(-1); //one head
        ListNode th = new ListNode(-1); //two head
        
        ListNode zt  = zh;  //zero tail
        ListNode ot = oh; //one tail
        ListNode tt = th; //two tail
        
        ListNode curr = head;
        
        while(curr != null) {
            if(curr.val == 0) {
                zt.next = curr;
                zt = zt.next;
            }
            else if(curr.val == 1){
                ot.next = curr;
                ot = ot.next;
            }
            else {
                tt.next = curr;
                tt = tt.next;
            }
            curr = curr.next;
        }
        
        ot.next = th.next;
        zt.next = oh.next;
        tt.next = null;
        
        return zh.next;
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
        h1 = segregate012(h1);
        printList(h1);
    }
}