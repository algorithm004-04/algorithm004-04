package week_01;

import java.util.LinkedList;

public class MyCircularDeque {

    private LinkedList<Integer> doubleQeuqe;

    private int size;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        doubleQeuqe = new LinkedList<>();
        this.size = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (size <= doubleQeuqe.size()) {
            return false;
        }
        boolean in = doubleQeuqe.offerFirst(value);
        //doubleQeuqe.addFirst(value);
        return in;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (size <= doubleQeuqe.size()) {
            return false;
        }
        boolean in = doubleQeuqe.offerLast(value);
        //doubleQeuqe.addLast(value);
        return in;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
//        doubleQeuqe.remove();
//        doubleQeuqe.removeFirst();
        //doubleQeuqe.pollFirst();
        boolean de;
        if (null != doubleQeuqe.pollFirst()) {
            de = true;
        } else {
            de = false;
        }
        return de;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        /*if (0 >= doubleQeuqe.size()) {
            return false;
        }*/
        //doubleQeuqe.removeLast();
        boolean de;
        if (null != doubleQeuqe.pollLast()) {
            de = true;
        } else {
            de = false;
        }
        return de;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        /*if (0 >= doubleQeuqe.size()) {
            return -1;
        }*/
        //doubleQeuqe.getFirst();
        return doubleQeuqe.peek() != null ? doubleQeuqe.peek() : -1;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {

        return doubleQeuqe.peekLast() != null ? doubleQeuqe.peekLast() : -1;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return doubleQeuqe.size() == 0 ? true : false;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {

        return doubleQeuqe.size() == size ? true : false;
    }
}
