# NOTE
# 044-Week 01  第一周学习总结
1.课程里教了什么？
    (1).数组、链表、跳表结构，leetcode题目实战分析
    (2).栈、队列，leetcode题目实战分析

2.学到了什么？
第三课：
    (1).数组(ArrayList)的结构、以及操作(I、D、A、S)，其中I插入和D删除时间复杂度为O(n)，A追加和S查询的时间复杂度为O(1)
    (2).单链表和双链表(LinkedList)的结构、以及操作，除了查询的时间复杂度为O(n)以外，其它操作的时间复杂度为O
        单链表：head{value,next}->next{value,next}->xx{xx,next}
        双链表：head{pre,value,next}<->next{pre,value,next}<->xx{pre,xx,next}
    (3).跳表(Skip List)的出现是因为链表的时间复杂度为O(n)，为了给链表加速，才有了跳表出现。
        跳表实现：在原始链表建多级索引。第一级索引，在原链表上，从第一个开始，每隔一个元素添加到一级索引中。第二级索引，在第一级索引的基础上，从第一个开始，每隔一个元素添加到二级索引中。之后每级索引以此类推，形成跳表。跳表的时间复杂度O(logn),空间复杂度为O(n)。跳表在redis中有应用，因为比红黑数实现简单，所以用的跳表。
    (4).leetcode题目实战分析。
    (5).从跳表中学到了升维的思想，以空间换时间，如果一维解决不了，可以升到二维。
        从老师讲leetcode题目中学到了思考问题的方法，如果一个问题没有头绪，就先采用暴力的办法，从中找出问题的重复性，再一步步分析问题。如果暴力的办法都解决不了，那就先看别人的答案，照着抄一遍，然后根据五毒神掌去修炼内功心法。
        还有一个很重要的思想是双指针法，从两端往中间走，从而形成左右夹逼，使得解决问题的速度更快
第四课：
    (1).栈(stack)的结构(Last in - First out)，以及操作(push,pop,peek),其中添加、删除的时间复杂度都为O
        如果最近相关性问题可以用栈来解决
    (2).队列(queue)的结构(First in - First out)，以及操作(offer,poll,peek)，添加、删除的时间复杂度都为O
    (3).双端队列(Deque)，操作(push,pop,peek,addLast,peekLast,removeLast),两端都可以进出的queue，插入和删除的时间复杂度都是O(1)

3.需要做的练习
    (1).改写Deque代码
    //改写后的代码
    private static void deuqeOpNew() {
        //从前端开始
        Deque<String> dequeFirst = new LinkedList<>();
        //跟push的效果一样，增加到第一个元素
        dequeFirst.addFirst("a");
        dequeFirst.addFirst("b");
        dequeFirst.addFirst("c");
        System.out.println(dequeFirst);
        System.out.println(dequeFirst.peekFirst());  //跟peek的效果一样，是查看第一个元素，只是看一眼，不删除元素
        System.out.println(dequeFirst);
        while (dequeFirst.size() > 0) {
            System.out.println(dequeFirst.removeFirst());    //这里跟pop一样，都是移除第一个元素，还有一个方法remove也是一样
        //System.out.println(dequeFirst.remove());
        }
        System.out.println(dequeFirst);
        System.out.println("--------------分割线--------------");
        //从尾部开始
        Deque<String> dequeLast = new LinkedList<>();
        dequeLast.addLast("a");
        dequeLast.addLast("b");
        dequeLast.addLast("c");
        System.out.println(dequeLast);
        System.out.println(dequeLast.peekLast());
        System.out.println(dequeLast);
        while (dequeLast.size() > 0) {
            System.out.println(dequeLast.removeLast());
        }
        System.out.println(dequeLast);
    }
    //改写前的代码
    private static void dequeOpOld() {
        Deque<String> deque = new LinkedList<>();
        deque.push("a");
        deque.push("b");
        deque.push("c");
        System.out.println(deque);
        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }
        System.out.println(deque);
    }
    (2).分析Queue和Priority Queue的源码

4.不清楚的地方
    1.链表的反转还不是很清楚







  

