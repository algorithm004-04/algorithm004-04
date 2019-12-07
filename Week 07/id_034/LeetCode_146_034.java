import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode_146_034
 *
 * @Author mengdebiao@duxiaoman.com
 * @Date 2019/12/1 11:09 AM
 **/
class LRUCache {

    private int capicty;
    private int size;

    private DLinkedNode head;
    private DLinkedNode tail;

    private Map<Integer, DLinkedNode> cache;

    public LRUCache(int capicty) {
        this.capicty = capicty;
        size = 0;

        head = new DLinkedNode();
        tail = new DLinkedNode();

        head.next = tail;
        tail.prev = head;

        cache = new HashMap<>();
    }

    class DLinkedNode {
        private Integer key;
        private Integer value;

        private DLinkedNode prev;
        private DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            addNode(newNode);
            cache.put(key, newNode);
            ++ size;

            if (size > capicty) {
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                size --;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }


    private void addNode(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail() {
        DLinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }
}
