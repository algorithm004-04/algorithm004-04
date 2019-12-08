class LRUCache {
    // 双链表节点
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
    }
    
    private int capacity;
    private Node first;
    private Node last;
    
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }
    
    private void moveToHead(Node node) {
        if (node == first) {
            return;
        } else if (node == last) {
            last.prev.next = null;
            last = last.prev;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        
        node.prev = first.prev;
        node.next = first;
        first.prev = node;
        first = node;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        
        if (node == null) {
            node = new Node();
            node.key = key;
            node.val = value;
            
            if(map.size() == capacity) {
                removeLast();
            }
            
            addToHead(node);
            map.put(key, node);
        } else {
            node.val = value;
            moveToHead(node);
        }
    }
    
    private void addToHead(Node node) {
        if (map.isEmpty()) {
            first = node;
            last = node;
        } else {
            node.next = first;
            first.prev = node;
            first = node;
        }
    }
    
    private void removeLast() {
        map.remove(last.key);
        Node prevNode = last.prev;
        if (prevNode != null) {
            prevNode.next = null;
            last = prevNode;
        }
    }
}