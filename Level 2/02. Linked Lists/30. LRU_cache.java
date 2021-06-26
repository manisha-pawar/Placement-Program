class LRUCache {
    public class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key,int val) {
            this.key = key;
            this.val = val;
        }

        Node() {

        }
    }

    //LRU
    HashMap<Integer,Node>map;
    int limit = 0;

    //DLL
    Node head;
    Node tail;
    int size;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        limit = capacity;
        head = null;
        tail = null;
        size = 0;
    }
    

    public int get(int key) {
        //already present app
        if(map.containsKey(key) == true) {
            Node rem = map.get(key);
            removeNode(rem);
            addLastNode(rem);
            return rem.val;
        }
        //new app
        else {
           return -1;
        }
    }
    
    public void put(int key, int value) {
        //already present app
        if(map.containsKey(key) == true) {
            Node rem = map.get(key);
            removeNode(rem);
            addLastNode(rem);
            rem.val = value;
        }
        //new app
        else {
            Node nn = new Node(key,value);
            addLastNode(nn);
            map.put(key,nn);

            //if limit is crossed then remove least recent app
            if(size > limit) {
                Node rem = removeFirst();
                map.remove(rem.key);
            }
        }
    }

    private void addLastNode(Node node) {
        if(size == 0) {
            head = tail = node;
        }
        else {
            tail.next = node;
            node.prev = tail;

            tail = node;
        }
        size++;
    }

    private void removeNode(Node node) {
        if(node == head) {
            removeFirst();
        }
        else if(node == tail) {
            removeLast();
        }
        else {
            Node pn = node.prev;
            Node fn = node.next;

            pn.next = fn;
            fn.prev = pn;

            node.next = node.prev = null;
            size--;
        }
    }

    private Node removeFirst() {
        if(size == 0) {
            return null;
        }

        Node rem = head;
        if(size == 1) {
            head = tail = null;
        }
        else {
            Node hn = head.next;
            head.next = null;
            hn.prev = null;

            head = hn;
        }
        size--;
        return rem;
    }

    private void removeLast() {
         if(size == 0) {
            return;
        }

        if(size == 1) {
            head = tail = null;
        }
        else {
            Node tp = tail.prev;
            tp.next = null;
            tail.prev = null;

            tail = tp;
        }
        size--;
    }
}