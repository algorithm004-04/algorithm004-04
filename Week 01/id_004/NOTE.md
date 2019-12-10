# NOTE
第一周学习总结:
    .这周的课程的主要内容是几个最基础的数据结构: 数组, 链表, 栈, 队列
    .本周重点:
       .各个基本数据接口的特性与应用场景
          .双端队列相当于 stack + queue 的结合体, 这是一个非常好的总结
       .刷题技巧(重点)
          .五毒神掌 : 我结合自己的经验, 觉得其实五次刷题是一个基本的套路, 其实刷五次还是不够的,
          需要不断去重复练习才能巩固.
          .遇到没有思路的题目, 需要用数学归纳法或者"最近推导法" 来尝试在最小的数据规模下进行求解,
            然后再发现规律.
          .优化的核心思路:
             .时间, 空间互换(课堂老师只说了空间换时间,老师也很强调时间, 但其实时间换空间也是一种重要的思路)
             .升维 (我的理解更多的是空间换时间的一种做法. 但如何升维就是一个重要的点) 


作业1 新API  改写deque:
Deque<String> deque = new LinkedList<String>();
deque.addLast("a");
deque.addLast("b");
deque.addLast("c");



String str = deque.peekFirst();


while(deque.size() > 0 ){
   System.out.println(deque.removeFirst());
}


作业2 分析queue , priority queue 源代码:
    .Priority Queue 的插入方法, 老师说是O(1) 但从代码上看, 每次调用都有调siftxxx 方法.
    里面是一个比较排序操作, 算法复杂度不是O(1)
    .由于enqueue 和 dequeue 都是涉及查找操作, 所以复杂度都是O(logn)
    .跟老师课堂上说的不一样, 希望老师解答. 
