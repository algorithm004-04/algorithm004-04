//设计实现双端队列。 
//你的实现需要支持以下操作： 
//
// 
// MyCircularDeque(k)：构造函数,双端队列的大小为k。 
// insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。 
// insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。 
// deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。 
// deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。 
// getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。 
// getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。 
// isEmpty()：检查双端队列是否为空。 
// isFull()：检查双端队列是否满了。 
// 
//
// 示例： 
//
// MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
//circularDeque.insertLast(1);			        // 返回 true
//circularDeque.insertLast(2);			        // 返回 true
//circularDeque.insertFront(3);			        // 返回 true
//circularDeque.insertFront(4);			        // 已经满了，返回 false
//circularDeque.getRear();  				// 返回 2
//circularDeque.isFull();				        // 返回 true
//circularDeque.deleteLast();			        // 返回 true
//circularDeque.insertFront(4);			        // 返回 true
//circularDeque.getFront();				// 返回 4
//  
//
// 
//
// 提示： 
//
// 
// 所有值的范围为 [1, 1000] 
// 操作次数的范围为 [1, 1000] 
// 请不要使用内置的双端队列库。 
// 
// Related Topics 设计 队列


import java.util.ArrayDeque;
import java.util.Deque;

//leetcode submit region begin(Prohibit modification and deletion)
class MyCircularDeque {
    //利用数组实现，增加和删除只是修改队头队尾指针的位置
    private int[] myArrayDeque;
    //有效元素的个数
    private int size;
    //队头队尾指针
    private int front;
    private int rear;
    //容量
    private int capacity;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        myArrayDeque = new int[k];
        size = 0;
        front = 0;
        rear = 0;
        capacity = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        //判断队列是否已满
        if (front == rear && size == capacity) return false;
        else {
            //前插时向前移动front
            front = (front + capacity - 1) % capacity;
            myArrayDeque[front] = value;
            size++;
            return true;
        }
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (front == rear && size == capacity) return false;
        else {
            myArrayDeque[rear] = value;
            rear = (rear + 1) % capacity;
            size++;
            return true;
        }
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (front == rear && size == 0) return false;
        else {
            front = (front + 1) % capacity;
            size--;
            return true;
        }
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (rear == front && size == 0) return false;
        else {
            rear = (rear - 1 + capacity) % capacity;
            size--;
            return true;
        }
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if((rear == front) && size==0) return -1;
        else {
            int frontE = myArrayDeque[front];
            return frontE;
        }
//        throw  new RuntimeException("get front element failed, The deque is empty.");
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if((rear == front) && size==0) return -1;
        else {
            int rearE = myArrayDeque[(rear-1+capacity)%capacity];
            return rearE;
        }
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return (rear == front) && size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return rear == front && size == capacity;
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
//leetcode submit region end(Prohibit modification and deletion)
