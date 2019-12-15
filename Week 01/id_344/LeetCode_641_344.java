class MyCircularDeque {
    int[] queue;
    int first;  // 头指针
    int last;  // 尾指针
    int size;  // 当前队列长度
    int capacity;  // 队列的容量

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        queue = new int[k];
        first = 0;
        last = 0;
        size = 0;
        capacity = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (first == last && size == capacity) {
            return false;
        } else {
            queue[first] = value;
            if (first == 0) {
                first = capacity - 1;
            } else {
                first--;
            }
            size++;
            return true;
        }

    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (first == last && size == capacity) {
            return false;
        } else {
            if (last == capacity - 1) {
                last = 0;
            } else {
                last++;
            }
            queue[last] = value;
            size++;
            return true;
        }
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (size == 0 && first == last) {
            return false;
        } else {
            if (first == capacity - 1) {
                first = 0;
            } else {
                first++;
            }
            size--;
            return true;
        }
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (size == 0 && first == last) {
            return false;
        } else {
            if (last == 0) {
                last = capacity - 1;
            } else {
                last--;
            }
            size--;
            return true;
        }
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (size == 0 && first == last) {
            return -1;
        } else {
            if (first == capacity - 1) {
                return queue[0];
            } else {
                return queue[first + 1];
            }
        }
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (size == 0 && first == last) {
            return -1;
        } else {
            return queue[last];
        }
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if (size == 0 && first == last) {
            return true;
        } else {
            return false;
        }
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if (size == capacity && first == last) {
            return true;
        } else {
            return false;
        }
    }
}