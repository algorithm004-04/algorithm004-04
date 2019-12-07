public class MyCircularDeque {
    private int [] myqueue ;
    private int front;
    private int rear;
    private int size; //当前队列size
    private int capacity;
    
    /** 构造函数,双端队列的大小为k */
    public MyCircularDeque(int k) {
        this.myqueue = new int[k];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
        this.capacity = k;
    }
    
    /** 将一个元素添加到双端队列头部,如果操作成功返回 true */
    public boolean insertFront(int value) {
        //如果队列满，插入失败
        if(rear == front && size == capacity) {
            return  false;
        } else {
            front = (front + capacity -1) % capacity;
            myqueue[front] = value;
            size++;
            return true;
        }
    }
    
    /** 将一个元素添加到双端队列尾部,如果操作成功返回 true */
    public boolean insertLast(int value) {
        //如果队列满，插入失败
        if(rear==front && size == capacity) {
            return  false;
        }else{
            myqueue[rear] = value;
            rear = (rear + 1 + capacity) % capacity;
            size++;
            return true;
        }
    }
    
    /** 从双端队列头部删除一个元素。 如果操作成功返回 true */
    public boolean deleteFront() {
         if( rear == front && size == 0) {
             return false;
         } else {
            front = (front+1) % capacity;
            size--;
            return true;
        }
    }
    
    /** 从双端队列尾部删除一个元素。如果操作成功返回 true */
    public boolean deleteLast() {
         if( rear == front && size == 0) {
             return false;
         } else {
            rear = (rear - 1 + capacity) % capacity;
            size--;
            return true;
        }
    }
    
    /** 从双端队列头部获得一个元素。如果双端队列为空，返回 -1 */
    public int getFront() {
        if((rear == front) && size==0) {
            return -1;
        } else {
            int frontE = myqueue[front];
            return frontE;
        }
    }
    
    /** 获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 */
    public int getRear() {
        if((rear == front) && size==0){
            return -1;
        } else {
            int rearE = myqueue[(rear-1+capacity)%capacity];
            return rearE;
        }
    }
    
    /** 检查双端队列是否为空 */
    public boolean isEmpty() {
         return (rear == front) && size==0;
    }
    
    /** 检查双端队列是否满了 */
    public boolean isFull() {
        return rear==front && size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */