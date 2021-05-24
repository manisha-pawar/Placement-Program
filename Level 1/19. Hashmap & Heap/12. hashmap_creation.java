import java.io.*;
import java.util.*;

public class Main {

    public static class HashMap < K, V > {
        private class HMNode {
            K key;
            V value;

            HMNode(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size; // n
        private LinkedList < HMNode > [] buckets; // N = buckets.length

        public HashMap() {
            initbuckets(4);
            size = 0;
        }

        private void initbuckets(int N) {
            buckets = new LinkedList[N];
            for (int bi = 0; bi < buckets.length; bi++) {
                buckets[bi] = new LinkedList < > ();
            }
        }

        public void put(K key, V value) throws Exception {

            int bi = findBucketIndex(key);
            int di = findWithinBucket(key, bi);

            if (di == -1) {
                //key is not present -> insertion
                LinkedList < HMNode > list = buckets[bi];
                HMNode node = new HMNode(key, value);
                list.add(node);
                size++;
            } else {
                //key is present -> updatation
                LinkedList < HMNode > list = buckets[bi];
                HMNode node = list.get(di);
                node.value = value;
            }

            double lambda = (size * 1.0) / buckets.length;

            if (lambda > 2) {
                //we have rehash
                rehash();
            }
        }

        private void rehash() throws Exception {
            LinkedList < HMNode > [] oldbuckets = buckets;
            initbuckets(2 * oldbuckets.length);
            size = 0;

            //travel each bucket
            for (int bi = 0; bi < oldbuckets.length; bi++) {
                //travel linked list in this bucket
                for (int i = 0; i < oldbuckets[bi].size(); i++) {
                    HMNode node = oldbuckets[bi].get(i);
                    put(node.key, node.value);
                }
            }

        }


        private int findBucketIndex(K key) {
            int hc = key.hashCode();
            int bi = (Math.abs(hc)) % buckets.length;

            return bi;
        }

        private int findWithinBucket(K key, int bi) {
            LinkedList < HMNode > list = buckets[bi];

            for (int i = 0; i < list.size(); i++) {
                HMNode node = list.get(i);

                if (key.equals(node.key) == true) {
                    return i;
                }
            }

            return -1;
        }

        public V get(K key) throws Exception {
            int bi = findBucketIndex(key);
            int di = findWithinBucket(key, bi);

            if (di == -1) {
                //key is not present -> null
                return null;
            } else {
                //key is present -> value
                LinkedList < HMNode > list = buckets[bi];
                HMNode node = list.get(di);
                return node.value;
            }
        }

        public boolean containsKey(K key) {
            int bi = findBucketIndex(key);
            int di = findWithinBucket(key, bi);

            if (di == -1) {
                //key is not present -> false
                return false;
            } else {
                //key is present -> value
                return true;
            }
        }

        public V remove(K key) throws Exception {
            int bi = findBucketIndex(key);
            int di = findWithinBucket(key, bi);

            if (di == -1) {
                //key is not present -> null
                return null;
            } else {
                //key is present -> value
                LinkedList < HMNode > list = buckets[bi];
                HMNode node = list.get(di);
                V val = node.value;
                list.remove(di);
                size--;
                return val;
            }
        }

        public ArrayList < K > keyset() throws Exception {
            ArrayList < K > keys = new ArrayList < > ();

            //travel each bucket
            for (int bi = 0; bi < buckets.length; bi++) {
                //travel linked list in this bucket
                for (int i = 0; i < buckets[bi].size(); i++) {
                    HMNode node = buckets[bi].get(i);
                    keys.add(node.key);
                }
            }

            return keys;
        }

        public int size() {
            return size;
        }

        public void display() {
            System.out.println("Display Begins");
            for (int bi = 0; bi < buckets.length; bi++) {
                System.out.print("Bucket" + bi + " ");
                for (HMNode node: buckets[bi]) {
                    System.out.print(node.key + "@" + node.value + " ");
                }
                System.out.println(".");
            }
            System.out.println("Display Ends");
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap < String, Integer > map = new HashMap();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("put")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                Integer val = Integer.parseInt(parts[2]);
                map.put(key, val);
            } else if (str.startsWith("get")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.get(key));
            } else if (str.startsWith("containsKey")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.containsKey(key));
            } else if (str.startsWith("remove")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.remove(key));
            } else if (str.startsWith("size")) {
                System.out.println(map.size());
            } else if (str.startsWith("keyset")) {
                System.out.println(map.keyset());
            } else if (str.startsWith("display")) {
                map.display();
            }
            str = br.readLine();
        }
    }
}