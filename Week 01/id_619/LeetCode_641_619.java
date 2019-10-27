class MyCircularDeque {

    /** Initialize your data structure here. Set the size of the deque to be k. */
    Stack<Integer> head = new Stack<>();
    Stack<Integer> tail = new Stack<>();
    int size;
    public MyCircularDeque(int k) {
        size = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (head.size()+tail.size()<size) {
            head.push(value);
            return true;
        }
        return false;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (head.size()+tail.size()<size) {
            tail.push(value);
            return true;
        }
        return false;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (head.empty()) {
            while (!tail.empty()) {
                head.push(tail.pop());
            }
        }
        if (head.empty()) {
            return false;
        }else {
            head.pop();
            return true;
        }
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (tail.empty()) {
            while (!head.empty()) {
                tail.push(head.pop());
            }
        }
        if (tail.empty()) {
            return false;
        }else {
            tail.pop();
            return true;
        }
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (head.empty()) {
            while (!tail.empty()) {
                head.push(tail.pop());
            }
        }
        if (head.empty()) {
            return -1;
        }else {
            return head.peek();
        }
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (tail.empty()) {
            while (!head.empty()) {
                tail.push(head.pop());
            }
        }
        if (tail.empty()) {
            return -1;
        }else {
            return tail.peek();
        }
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if (head.empty()&&tail.empty()) {
            return true;
        }
        return false;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if (head.size()+tail.size()>=size){
            return true;
        }
        return false;
    }
}
