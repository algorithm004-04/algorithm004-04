class Solution {

    int[] elements;
    int front = 0, last = 0, capacitySize = 0;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        elements = new int[k];
        capacitySize = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        } else if (last == capacitySize) {
            int[] newElements = new int[capacitySize];
            System.arraycopy(elements, front, newElements, 0, last - front);
            elements = newElements;
            last = last - front;
            front = 0;
        }
        elements[last++] = value;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        } else if (front == 0 && !isEmpty()) {
            int[] newElements = new int[capacitySize];
            System.arraycopy(elements, 0, newElements, 1, last);
            elements = newElements;
            front = 0;
            last++;
            elements[0] = value;
        } else if (front == 0 && isEmpty()) {
            elements[0] = value;
            last++;
        } else {
            elements[--front] = value;
        }
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
       if (isEmpty()) {
           return false;
       } else {
           elements[--last] = -1;
           return true;
       }
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
       if (isEmpty()) {
           return false;
       } else {
           elements[front++] = -1;
           return true;
       }
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        return !isEmpty() ? elements[last - 1] : -1;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        return !isEmpty() ? elements[front] : -1;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return front == last ? true : false;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (front == 0 && last == capacitySize) ? true : false;
    }

}