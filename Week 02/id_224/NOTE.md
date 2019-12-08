# 224-Week 02 周期总结（仅第五课）
* 面对算法题的面试技巧
    + 与面试官沟通题目，约定规则
    + 从自己可以想到的方案中选择最优解法（按时间复杂度和空间复杂度最优进行选择）
    + 编写代码
    + 测试代码
* 关于HashMap的小总结
    + put函数的实现
        ```
        put函数大致的思路为：

        1.对key的hashCode()做hash，然后再计算index;
        2.如果没碰撞直接放到bucket里；
        3.如果碰撞了，以链表的形式存在buckets后；
        4.如果碰撞导致链表过长(大于等于TREEIFY_THRESHOLD)，就把链表转换成红黑树；
        5.如果节点已经存在就替换old value(保证key的唯一性)
        6.如果bucket满了(超过load factor*current capacity)，就要resize。

        ```
    + get函数的实现
        ```
        在理解了put之后，get就很简单了。大致思路如下：

        1.bucket里的第一个节点，直接命中；
        2.如果有冲突，则通过key.equals(k)去查找对应的entry
        若为树，则在树中通过key.equals(k)查找，O(logn)；
        若为链表，则在链表中通过key.equals(k)查找，O(n)。
        ```

  

