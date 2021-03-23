public class Main {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        public void addLast(int val) {
            Node n = new Node();
            n.data = val;
            n.next = null;

            if (size == 0) {
                head = n;
                tail = n;
            } else {
                tail.next = n;
                tail = n;
            }

            size++;
        }

        public void addFirst(int val) {
            Node n = new Node();
            n.data = val;
            n.next = null;

            if (size == 0) {
                head = n;
                tail = n;
            } else {
                n.next = head;
                head = n;
            }
            size++;
        }

        public int getFirst() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return head.data;
            }
        }

        public void removeFirst() {
            if (size == 0) {
                System.out.println("List is empty");
                return;
            } else if (size == 1) {
                head = tail = null;
            } else {
                head = head.next;
            }

            size--;
        }


        //kth node from last
        public int kthFromLast(int k) {
            Node slow = head;
            Node fast = head;

            for (int i = 0; i < k; i++) {
                fast = fast.next;
            }

            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow.data;
        }

        //remove duplicates from a sorted list
        public void removeDuplicates() {
            LinkedList nl = new LinkedList();

            while (this.size != 0) {
                int val = this.getFirst();
                this.removeFirst();

                if (nl.size == 0 || nl.tail.data != val) {
                    nl.addLast(val);
                }
            }

            this.head = nl.head;
            this.tail = nl.tail;
            this.size = nl.size;
        }


        //odd even linked list
        public void oddEven() {
            LinkedList oddList = new LinkedList();
            LinkedList evenList = new LinkedList();

            while (this.size > 0) {
                int val = this.getFirst();
                this.removeFirst();

                if (val % 2 == 0) {
                    evenList.addLast(val);
                } else {
                    oddList.addLast(val);
                }
            }

            if (oddList.size > 0 && evenList.size > 0) {
                oddList.tail.next = evenList.head;
                this.head = oddList.head;
                this.tail = evenList.tail;
                this.size = oddList.size + evenList.size;
            } else if (oddList.size > 0) {
                this.head = oddList.head;
                this.tail = oddList.tail;
                this.size = oddList.size;
            } else if (evenList.size > 0) {
                this.head = evenList.head;
                this.tail = evenList.tail;
                this.size = evenList.size;
            }

        }


        //k-reverse in linked list
        public void kReverse(int k) {
            LinkedList ans = new LinkedList();

            if (k > this.size) {
                return;
            }

            while (this.size >= k) {
                //reverse k nodes
                LinkedList curr = new LinkedList();

                for (int i = 0; i < k; i++) {
                    int val = this.getFirst();
                    this.removeFirst();
                    curr.addFirst(val);
                }

                if (ans.size == 0) {
                    ans = curr;
                } else {
                    ans.tail.next = curr.head;
                    ans.tail = curr.tail;
                    ans.size += curr.size;
                }
            }

            //settle remaining nodes in this
            if (this.size > 0) {
                ans.tail.next = this.head;
                ans.tail = this.tail;
                ans.size += this.size;
            }

            this.head = ans.head;
            this.tail = ans.tail;
            this.size = ans.size;
        }


        //fold a linked list
        Node fleft;
        public void fold() {
            fleft = head;
            foldHelper(head, 0);
        }


        public void foldHelper(Node right, int flag) {
            if (right == null) {
                return;
            }

            foldHelper(right.next, flag + 1);


            if (flag > size / 2) {
                Node temp = fleft.next;
                fleft.next = right;
                right.next = temp;

                fleft = temp;
            } else if (flag == size / 2) {
                right.next = null;
                tail = right;
            } else {
                //no work
            }
        }


        //add two linked lists
        public static LinkedList addTwoLists(LinkedList one, LinkedList two) {
            LinkedList res = new LinkedList();
            int c = addHelper(one.head, one.size - 1, two.head, two.size - 1, res);

            if (c == 1) {
                res.addFirst(c);
            }

            return res;
        }

        public static int addHelper(Node head1, int pv1, Node head2, int pv2, LinkedList res) {
            if (head1 == null && head2 == null) {
                return 0;
            }

            if (pv1 == pv2) {
                int c = addHelper(head1.next, pv1 - 1, head2.next, pv2 - 1, res);
                int val = head1.data + head2.data + c;

                int nd = val % 10;
                int nc = val / 10;

                res.addFirst(nd);

                return nc;
            } else if (pv1 > pv2) {
                int c = addHelper(head1.next, pv1 - 1, head2, pv2, res);
                int val = head1.data + c;

                int nd = val % 10;
                int nc = val / 10;

                res.addFirst(nd);

                return nc;
            } else {
                int c = addHelper(head1, pv1, head2.next, pv2 - 1, res);
                int val = head2.data + c;

                int nd = val % 10;
                int nc = val / 10;

                res.addFirst(nd);

                return nc;
            }
        }


        //intersection point of two linked lists
        public static int findIntersection(LinkedList one, LinkedList two) {
            Node head1 = one.head;
            Node head2 = two.head;

            int gap = Math.abs(one.size - two.size);

            //cover extra gap
            if (one.size > two.size) {
                for (int i = 0; i < gap; i++) {
                    head1 = head1.next;
                }
            } else {
                for (int i = 0; i < gap; i++) {
                    head2 = head2.next;
                }
            }

            while (head1 != null && head2 != null && head1 != head2) {
                head1 = head1.next;
                head2 = head2.next;
            }

            if (head1 == null || head2 == null) {
                //no intersection point
                return -1;
            }

            return head1.data;
        }



        public static void main(String[] args) {
            //input can be managed
        }

    }