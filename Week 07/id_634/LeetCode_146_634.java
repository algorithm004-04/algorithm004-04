class LRUCache {

    //hashmap + LinkedList
//     HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
//     Queue<Integer> queue = new LinkedList<>();
//     int max_size = 0;
    
//     public LRUCache(int capacity) {
//         max_size = capacity;
//     }
    
//     public int get(int key) {
//         if (!map.containsKey(key)) return -1;
//         queue.remove(key);
//         queue.add(key);
//         return map.get(key);
//     }
    
//     public void put(int key, int value) {
//         if (!map.containsKey(key) && map.size() == max_size)                    
//             map.remove(queue.remove());
//         if (map.containsKey(key)) queue.remove(key);  
//         map.put(key, value);
//         queue.add(key);
//     }
    
    
    //hashmap + LinkedList
    private HashMap<Integer, Node> cache;
    private Node first;
    private Node last;
    private int capacity;

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("invalid capacity");
        }

        cache = new HashMap(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);
        moveToFirst(node);
        return node.getValue();
    }

    public void put(int key, int value) {
        Node node = getEntry(key);
        if (node == null) {
            if (cache.size() >= capacity) {
                cache.remove(last.key);
                removeLast();
            }
            node = new Node(key, value);
            node.key = key;
        }
        node.value = value;
        moveToFirst(node);
        cache.put(key, node);
    }

    private void removeLast() {
        if (last != null) {
            last = last.pre;
            if (last == null) first = null;
            else last.next = null;
        }
    }

    private Node getEntry(int key) {
        return cache.get(key);
    }

    private void moveToFirst(Node node) {
        if (node == first) return;
        if (node.pre != null) node.pre.next = node.next;
        if (node.next != null) node.next.pre = node.pre;
        if (node == last) last = last.pre;

        if (first == null || last == null) {
            first = last = node;
            return;
        }

        node.next = first;
        first.pre = node;
        first = node;
        node.pre = null;
    }
    
    class Node {

        int key;
        int value;
        Node next;
        Node pre;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Integer getValue() {
            return this.value;
        }

    }

}
