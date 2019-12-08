import java.util.HashMap;

/*
 * NO.146: LRUCache
 * */
public class LeetCode_146_269 {
    class LRUCache {
        HashMap<Integer, Node> map;

        int size;
        int capacity;
        Node head;
        Node tail;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            this.size = 0;
            this.capacity = capacity;
        }

        /**
         * 获取元素
         */
        public int get(int key) {
            Node node = getNode(key);
            return node == null ? -1 : node.val;
        }

        /**
         * 添加元素
         */
        public void put(int key, int value) {
            Node oldNode = getNode(key);
            if (oldNode == null) {
                Node node = new Node(key, value);
                map.put(key, node);
                appendTail(node);
                size++;
                trimToSize();
            } else {
                oldNode.val = value;
            }
        }

        /**
         * 修正LRU的大小
         */
        public void trimToSize() {
            while (size > capacity) {
                Node rm = head;
                head = head.next;
                head.prev = null;
                rm.next = null;
                map.remove(rm.key);
                size--;
            }
        }

        public void appendTail(Node node) {
            if (size == 0) {
                head = tail = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
                node.next = null;
            }
        }

        public Node getNode(int key) {
            Node node = map.get(key);
            if (node == null || node == tail) return node;

            if (node == head) {
                head = head.next;
                head.prev = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

            appendTail(node);
            return node;
        }

        class Node {
            int key;
            int val;
            Node prev;
            Node next;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }
}
