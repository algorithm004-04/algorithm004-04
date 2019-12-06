# NOTE
本周记录：

这周印象最深的就是双指针法，但仍需联系。这周每次做完题第二天早上都会回想一遍，做题的思路，感觉不错。以后每次做完题，都没事回想几次。

但是本周仍有几个题，因为时间关系没有完成，提交完git作业之后，我还要在周日完成这几道题：
https://leetcode.com/problems/design-circular-deque
https://leetcode.com/problems/trapping-rain-water/

https://leetcode-cn.com/problems/merge-sorted-array/

priority queue数据结构分析
https://www.cnblogs.com/Elliott-Su-Faith-change-our-life/p/7472265.html

这周的学习方法还是有问题，使得我在周末的时候很狼狈，下周调整学习方法，周二之前完成所有视频的学习。周四之前完成大部分习题作业，这样周末可以好好反思一下，而不是被进度追着走
  
学习总结：

数据结构基础记录：
•	数组，链表和跳表
	•	操作复杂度 : 数组，链表
	•	插入 O(n), O(1)
	•	删除 O(n),O(1)
	•	增减 O(n),O(1)
	•	从头加 O(n),O(1)
	•	尾部添加 O(n), O(1)
	•	查找 O(1),O(n)
	•	跳表在原有的链表基础上，增加节点信息。空间换时间
•	队列，栈，优先队列，双端队列
	•	stack，queue
		•	查询 O（n）
		•	插入、删除O(1)
	•	double-end queue: 两头都可以 实现元素的出入
		•	插入、删除 O(1)
	•	查询O(n)
	•	优先队列: 具体实现多样复杂
		•	插入 O(1)
		•	取出O(logn)
	•	什么问题用栈解决：最近相关性问题。

做题技巧：双指针法，实际编写过程中要考虑一些边界情况的，特殊输入（空或者长度为1的数组）
感受：有一些解法很难一下想到，先默写下来，然后脑子里过一遍的算法流程和一些特殊处理，下一次的做的时候不慌，按照脑子里面的流程就能写出来。

源码分析,我发现按照老师的方法，在国内的搜索引擎上容易搜到API 文档，但是不太容易搜到具体实现部分。
我在这是这样做看源码的，在idea里面设置 java版本的同时，设置source 在file->project struct -> SDKS -> source 内添加 $java_home中的src.zip
然后随便打开一个 java文件，输入比如 Queue<> q1 = new Queue<>; 在Queue上，ctrl + b 即可跳入其源码。
Queue:	
	继承自collection 和 Iterable：。
	BlockingDeque<E>, BlockingQueue<E>, Deque<E>, TransferQueue<E> 接口 都继承自他
	 ArrayBlockingQueue, ArrayDeque, ConcurrentLinkedDeque, ConcurrentLinkedQueue, DelayQueue, LinkedBlockingDeque, LinkedBlockingQueue, 
	 LinkedList, LinkedTransferQueue, PriorityBlockingQueue, PriorityQueue, SynchronousQueue 实现源自这个接口
	 
方法定义：	
Returns	  : Throws exception ;	Returns special value ;
Insert :	add(e)	; offer(e) ;
Remove :	remove() ;	poll() ;
Examine	: element() ;	peek() ;

PriorityQueue
继承关系
	java.lang.Object
		java.util.AbstractCollection<E>
			java.util.AbstractQueue<E>
				java.util.PriorityQueue<E>
	实现的接口：
	Serializable, Iterable<E>, Collection<E>, Queue<E>
	基于balanced binary heap，默认初始大小11,最大值Integer.MaxValue;
方法定义：	
boolean add(E e)
Inserts the specified element into this priority queue.
void	clear()
Removes all of the elements from this priority queue.
Comparator<? super E>	comparator()
Returns the comparator used to order the elements in this queue, or null if this queue is sorted according to the natural ordering of its elements.
boolean	contains(Object o)
Returns true if this queue contains the specified element.
Iterator<E>	iterator()
Returns an iterator over the elements in this queue.
boolean	offer(E e)
Inserts the specified element into this priority queue.
E	peek()
Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
E	poll()
Retrieves and removes the head of this queue, or returns null if this queue is empty.
boolean	remove(Object o)
Removes a single instance of the specified element from this queue, if it is present.
int	size()
Returns the number of elements in this collection.
Object[]	toArray()
Returns an array containing all of the elements in this queue.
<T> T[]	toArray(T[] a)
Returns an array containing all of the elements in this queue; 
the runtime type of the returned array is that of the specified array.



	
	
	
	






