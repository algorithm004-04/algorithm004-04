package week01;

/**
 * 要点
 * capacity要加1，保证tail一直指向一个空元素，即使是满的时候，便于判断满的情况
 * 判断空：head = tail
 * 判断满：(tail + 1) % capacity == head 或者 (tail - 1 + capacity) % capacity == head， 即tail的下一个元素就是head
 */

public class LeetCode_641_294 {
    int capacity;
    int[] data;
    int head = 0;
    int tail = 0;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public LeetCode_641_294(int k) {
        this.capacity = k+1;
        this.data = new int[k+1];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        int next = (head - 1 + capacity) % capacity;
        if (next == tail) {
            return false;
        }
        head = next;
        data[head] = value;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        int next = (tail + 1) % capacity;
        if (next == head) {
            return false;
        }
        data[tail] = value;
        tail = next;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (head == tail) {
            return false;
        }
        head = (head + 1) % capacity;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (head == tail) {
            return false;
        }
        tail = (tail - 1 + capacity) % capacity;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (head == tail) {
            return -1;
        }
        return data[head];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (head == tail) {
            return -1;
        }
        return data[(tail - 1 + capacity) % capacity];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return head == tail;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (tail + 1) % capacity == head;
    }
}
