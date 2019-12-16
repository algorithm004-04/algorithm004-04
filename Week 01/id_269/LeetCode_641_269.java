/*
设计循环双端队列
使用链表实现的双端队列
 */
public class LeetCode_641_269 {

    class ListNode {
        ListNode prev;
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
        }
    }

    class MyCircularDeque {
        int capacity;
        int size;
        ListNode head;
        ListNode tail;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            this.size = 0;
            this.capacity = k;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (isFull()) return false;

            ListNode node = new ListNode(value);
            node.next = head;
            node.prev = null;

            if (isEmpty()) {
                tail = node;
            } else {
                head.prev = node;
            }

            head = node;
            size++;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {

            if (isFull()) {
                return false;
            }

            ListNode node = new ListNode(value);

            node.prev = tail;
            node.next = null;

            if (isEmpty()) {
                head = node;
            } else {
                tail.next = node;

            }

            tail = node;
            size++;
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (isEmpty()) return false;

            ListNode temp = head;

            head = head.next;

            if (head != null) {
                head.prev = null;
                temp.next = null;
            }
            size--;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (isEmpty()) return false;

            ListNode temp = tail;
            tail = tail.prev;
            temp.prev = null;

            if (tail != null) {
                tail.next = null;
            }
            size--;
            return true;

        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (isEmpty()) return -1;
            return head.val;
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (isEmpty()) return -1;
            return tail.val;
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return size <= 0;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return size == capacity;
        }
    }

}
