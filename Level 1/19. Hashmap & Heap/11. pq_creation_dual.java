import java.io.*;
import java.util.*;

public class Main {

    public static class PriorityQueue {
        ArrayList < Integer > data;
        boolean minHeap;

        //if v1 has higher priority than v2, this function return +ve
        private int priority(int v1, int v2) {

            //minheap -> smaller value has higher priority
            if (minHeap == true) {
                return v2 - v1;
            }

            //maxheap -> higher value has higher priority
            else {
                return v1 - v2;
            }

        }


        public PriorityQueue(boolean minHeap) {
            data = new ArrayList < > ();
            this.minHeap = minHeap;
        }


        public void add(int val) {
            data.add(val); //may be hop is not honoured
            upheapify(data.size() - 1); //to honour hop 
        }

        private void upheapify(int ci) {
            if (ci == 0) {
                return;
            }

            int pi = (ci - 1) / 2;

            if (priority(data.get(ci), data.get(pi)) > 0) {
                swap(ci, pi);
                upheapify(pi);
            }
        }

        private void swap(int i, int j) {
            int i_val = data.get(i);
            int j_val = data.get(j);

            data.set(i, j_val);
            data.set(j, i_val);
        }

        public int remove() {
            if (data.size() == 0) {
                System.out.println("Underflow");
                return -1;
            } else {
                int peek = data.get(0);
                swap(0, data.size() - 1); //swap first and last element
                data.remove(data.size() - 1);

                downheapify(0);
                return peek;
            }
        }

        private void downheapify(int pi) {
            int hpi = pi; //min idx
            int lci = 2 * pi + 1;
            int rci = 2 * pi + 2;

            if (lci < data.size() && priority(data.get(lci), data.get(hpi)) > 0) {
                hpi = lci;
            }

            if (rci < data.size() && priority(data.get(rci), data.get(hpi)) > 0) {
                hpi = rci;
            }


            if (hpi != pi) {
                swap(hpi, pi);
                downheapify(hpi);
            }
        }

        public int peek() {
            if (data.size() == 0) {
                System.out.println("Underflow");
                return -1;
            } else {
                return data.get(0); //highest priority element
            }
        }

        public int size() {
            return data.size();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue qu = new PriorityQueue(false);

        qu.add(10);
        qu.add(20);
        qu.add(5);
        qu.add(19);
        qu.add(16);

        while (qu.size() > 0) {
            System.out.println(qu.remove());
        }

    }
}