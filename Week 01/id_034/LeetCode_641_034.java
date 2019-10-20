/**
 * 设计一个循环双端队列
 * https://leetcode-cn.com/problems/design-circular-deque/
 *
 * 基于数组
 * 维护一个 size标识队列长度
 * capicity 为队列容量
 * size == capicity 表明队列已满
 * head tail 分别为 头指针和未指针  基于这两个指针就可以实现 O(1) 的 队头/队未元素 查询/添加/删除操作
 * @Author blackberry
 * @Date 2019/10/20 8:14 AM
 **/
public class MyCircularDeque {

    /**
     * 数组
     */
    private int[] arr;

    /**
     * 大小
     */
    private int size;

    /**
     * 队首指针
     */
    private int head;

    /**
     * 队尾指针
     */
    private int tail;

    /**
     * 容量大小
     */
    private int capicity;

    public MyCircularDeque_641(int capicity) {
        this.capicity = capicity;
        this.arr = new int[capicity];
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        if (size == 0) {
            head = 0;
            tail = 0;
        } else {
            //            head = (head - 1) >= 0 ? head - 1 : head - 1 + capicity;
            head = (head + capicity - 1) % capicity;

        }
        arr[head] = value;
        size ++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        if (size == 0) {
            head = 0;
            tail = 0;
        } else {
            tail = (tail + 1) % capicity;
        }
        arr[tail] = value;
        size ++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        size --;
        head = (head + 1) % capicity;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        size --;
        //        tail = tail -1 >= 0 ? tail -1 : tail - 1 + capicity;
        tail = (tail + capicity - 1) % capicity;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return arr[head];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capicity;
    }

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
        circularDeque.insertLast(1);			        // 返回 true
        circularDeque.insertLast(2);			        // 返回 true
        circularDeque.insertFront(3);			        // 返回 true
        circularDeque.insertFront(4);			        // 已经满了，返回 false
        circularDeque.getRear();  				// 返回 2
        circularDeque.isFull();				        // 返回 true
        circularDeque.deleteLast();			        // 返回 true
        circularDeque.insertFront(4);			        // 返回 true
        circularDeque.getFront();				// 返回 4
    }
}

