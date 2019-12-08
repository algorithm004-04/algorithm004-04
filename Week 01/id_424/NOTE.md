[TOC]

# **一、用新的API改写Deque代码**

```java
package com.wangyao;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();

//        deque.push("a");
//        deque.push("b");
//        deque.push("c");
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        String str = null;
        try {
            str = deque.getFirst();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(str);
        System.out.println(deque);

        while (!deque.isEmpty()) {
            try {
                System.out.println(deque.removeFirst());
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(deque);
    }
}

```

# **二、Queue和PriorityQueue的分析**

- ## **Queue**

  `Queue`是一个用于实现队列操作的接口，它继承自`Collection`接口，新增了**出队、入队、查看队头元素**三大类功能接口，具体如下表格:

  |              | 出错则抛出异常 | 出错则返回null值 |
  | :----------: | :------------: | :--------------: |
  |     入队     | boolean add(E) | boolean offer(E) |
  |     出队     |    E poll()    |    E remove()    |
  | 查看对头元素 |  E element()   |     E peek()     |

  

- ## **PriorityQueue**

  `PriorityQueue`是一个基于优先级堆建立的优先级队列，它 继承了`AbstractQueue`抽象类 ,而`AbstractQueue`则实现了`Queue`接口。

  - 构造

    `PriorityQueue`的构造是基于一个数组堆来实现的，该数组实现了一个二叉堆，其中存储的元素必须实现`Comparator`以进行优先级的比较，代码如下所示:

    ```java
     /**
         * Priority queue represented as a balanced binary heap: the two
         * children of queue[n] are queue[2*n+1] and queue[2*(n+1)].  The
         * priority queue is ordered by comparator, or by the elements'
         * natural ordering, if comparator is null: For each node n in the
         * heap and each descendant d of n, n <= d.  The element with the
         * lowest value is in queue[0], assuming the queue is nonempty.
         */
        transient Object[] queue; // non-private to simplify nested class access
    
        /**
         * The number of elements in the priority queue.
         */
        int size;
    
        /**
         * The comparator, or null if priority queue uses elements'
         * natural ordering.
         */
        private final Comparator<? super E> comparator;
        
         /**
         * Creates a {@code PriorityQueue} with the specified initial capacity
         * that orders its elements according to the specified comparator.
         *
         * @param  initialCapacity the initial capacity for this priority queue
         * @param  comparator the comparator that will be used to order this
         *         priority queue.  If {@code null}, the {@linkplain Comparable
         *         natural ordering} of the elements will be used.
         * @throws IllegalArgumentException if {@code initialCapacity} is
         *         less than 1
         */
        public PriorityQueue(int initialCapacity,
                             Comparator<? super E> comparator) {
            // Note: This restriction of at least one is not actually needed,
            // but continues for 1.5 compatibility
            if (initialCapacity < 1)
                throw new IllegalArgumentException();
            this.queue = new Object[initialCapacity];
            this.comparator = comparator;
        }
    ```

  - 入队和出队

    `PriorityQueue`的入队和出队操作也是基于堆的入队出队操作来实现的，比如出队操作的代码如下所示:

    ```java
    12     /**
    13      * 删除并返回队头的元素，如果队列为空则返回null
    14      */
    15    public E poll() {
    16         // 队列为空，返回null
    17         if (size == 0)
    18             return null;
    19         // 队列元素个数-1
    20         int s = --size ;
    21         // 修改版本+1
    22         modCount++;
    23         // 队头的元素
    24         E result = (E) queue[0];
    25         // 队尾的元素
    26         E x = (E) queue[s];
    27         // 先将队尾赋值为null
    28         queue[s] = null;
    29         // 如果队列中不止队尾一个元素，则调用siftDown方法进行"下移"操作
    30         if (s != 0)
    31             siftDown(0, x);
    32         return result;
    33     }
    ```

    

# **三、学习总结**

- ## **跳表查找结点的时间复杂度分析**
  
  1. 假设每两个结点建立一个上级索引节点，则整个跳表高度为$\log_{2}{n}$。
  2. 每一层最多需要遍历3个节点。
  3. 所以时间复杂度为`O(logn)`。
  
- ## **如何对跳表进行动态更新**

  1. 当往跳表内插入数据时，也可以选择索引层插入对应的节点。
  2. 为了保证索引层节点间隔的平衡性，防止跳表的查询性能过度退化，可以选择用概率函数决策在哪一层索引插入节点。

- ## **关于Math.floorMod函数在双端队列中的使用**

  在对双端队列进行**队满、队空的判断以及头尾指针的移动**操作时，可以考虑统一使用`Math.floorMod()`函数。

  例如在队头入队时：

  > `head = (head - 1 + size) % size `等同于`head = Math.floorMod(head - 1, size)`

  而在队头出队时:

  >`head = (head + 1) % size `等同于`head = Math.floorMod(head + 1, size)`

  `floorMod(x, y)`的计算方式如下:

  > x - (floorDiv(x, y) * y)

  其中`floorMod(x, y)`表示x除以y的商的向下取整。例如当`head`指针位于下标0，且需要进行入队操作，即`head - 1`,那么

  > head = -1 , size = 10	=>	floorDiv(head, size) = -1, floorMod(head, size) = -1 - (-1) \* 10 = 9

  正好满足队头入队的实际情况。