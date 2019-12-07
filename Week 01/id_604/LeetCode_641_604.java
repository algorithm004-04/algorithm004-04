class MyCircularDeque {

    private int[] data;
    private int front;//指向队首的元素
    private int tail;//下一次储存新元素入队应该储存的位置
    private int size;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        data = new int[k+1];
        front = 0;
        tail = 0;
        size = 0;

    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }

        front = (front-1 + data.length)% data.length;
        data[front] = value;
        size++;

        return true;

    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }

        data[tail] = value;
        tail = (tail+1) % data.length;
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        front = (front+1)%data.length;
        size --;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {

        if(isEmpty()){
            return false;
        }

        tail = (tail - 1 + data.length) % data.length;
        size--;

        return true;


    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()){
            return -1;
        }

        return data[(front) % data.length];

    }

    /** Get the last item from the deque. */
    public int getRear() {

        if(isEmpty()){
            return -1;
        }

        return data[(tail-1+data.length)%data.length];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return tail == front;

    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if(front == (tail+1)%data.length){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("front [");

        for(int i = front; i!=tail;i = (i+1)%data.length){
            res.append(data[i]);
            if((i+1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();

    }
}

