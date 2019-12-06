# NOTE

## 数组Array
	
	prepend 	O(1)
	append 		O(1)
	lookup 		O(1)
	insert		O(n)
	delete		O(n)

## 链表LinkedList

	prepend		O(1)
	append		O(1)
	lookup		O(n)
	insert		O(1)
	delete		O(1)

**ps:因为数组的插入和删除，如果从中间插入或删除的话需要将后面的元素往前移动一位，所以数组的插入和删除操作的时间复杂度为O(n)。链表的查询操作需要一个节点一个节点的遍历，所以链表额查询操作时间复杂度为O(n)。**

## 跳表SkipList


因为链表的查询需要遍历链表才能查询到所需要查找的数据，时间复杂度为O(n)。
跳表就是通过添加索引来给链表的查询加速。

跳表查询的时间复杂度为O(logn)

## 栈Stack

先入后出FILO

	insert		O(1)
	delete		O(1)

## 队列Queue

先入先出FIFO
	
	insert		O(1)
	delete		O(1)

## 双端队列Deque

两端都可以进出的队列Queue

	insert		O(1)
	delete		O(1)

**各个语言的链表、栈、队列的实现可以通过直接Google的方式查询到源码。**

**Python关于这些数据类型的中文网址为：https://docs.python.org/zh-cn/3/library/collections.html#module-collections**