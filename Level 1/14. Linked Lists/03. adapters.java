public class Main {

    public static class LLToStackAdapter {
        LinkedList < Integer > list;

        public LLToStackAdapter() {
            list = new LinkedList < > ();
        }


        int size() {
            return list.size();
        }

        void push(int val) {
            list.addFirst(val);
        }

        int pop() {
            if (list.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return list.removeFirst();
            }
        }

        int top() {
            if (list.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return list.getFirst();
            }
        }
    }

    public static class LLToQueueAdapter {
        LinkedList < Integer > list;

        public LLToQueueAdapter() {
            list = new LinkedList < > ();
        }

        public int size() {
            return list.size();
        }

        public void add(int val) {
            list.addLast(val);
        }

        public int remove() {
            if (list.size() == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                return list.removeFirst();
            }
        }

        public int peek() {
            if (list.size() == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                return list.getFirst();
            }
        }
    }


    public static void main() {
        LLToStackAdapter st = new LLToStackAdapter();
        //input can be managed as per question requirements
    }
}