#
# @lc app=leetcode.cn id=641 lang=python3
#
# [641] 设计循环双端队列
#
# https://leetcode-cn.com/problems/design-circular-deque/description/
#
# algorithms
# Medium (46.38%)
# Likes:    17
# Dislikes: 0
# Total Accepted:    2.6K
# Total Submissions: 5.4K
# Testcase Example:  '["MyCircularDeque","insertLast","insertLast","insertFront","insertFront","getRear","isFull","deleteLast","insertFront","getFront"]\n[[3],[1],[2],[3],[4],[],[],[],[4],[]]'
#
# 设计实现双端队列。
# 你的实现需要支持以下操作：
# 
# 
# MyCircularDeque(k)：构造函数,双端队列的大小为k。
# insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
# insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
# deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
# deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
# getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
# getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
# isEmpty()：检查双端队列是否为空。
# isFull()：检查双端队列是否满了。
# 
# 
# 示例：
# 
# MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
# circularDeque.insertLast(1);                    // 返回 true
# circularDeque.insertLast(2);                    // 返回 true
# circularDeque.insertFront(3);                    // 返回 true
# circularDeque.insertFront(4);                    // 已经满了，返回 false
# circularDeque.getRear();                  // 返回 2
# circularDeque.isFull();                        // 返回 true
# circularDeque.deleteLast();                    // 返回 true
# circularDeque.insertFront(4);                    // 返回 true
# circularDeque.getFront();                // 返回 4
# 
# 
# 
# 
# 提示：
# 
# 
# 所有值的范围为 [1, 1000]
# 操作次数的范围为 [1, 1000]
# 请不要使用内置的双端队列库。
# 
# 
#

# @lc code=start
class MyCircularDeque:

    def __init__(self, k: int):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        """
        self.q = []
        self.qLen = k

    def insertFront(self, value: int) -> bool:
        """
        Adds an item at the front of Deque. Return true if the operation is successful.
        """
        if len(self.q) < self.qLen:
            self.q.insert(0, value)
            return True
        return False
        

    def insertLast(self, value: int) -> bool:
        """
        Adds an item at the rear of Deque. Return true if the operation is successful.
        """
        if len(self.q) < self.qLen:
            self.q.append(value)
            return True
        return False
        

    def deleteFront(self) -> bool:
        """
        Deletes an item from the front of Deque. Return true if the operation is successful.
        """
        if len(self.q) == 0:
            return False
        self.q.pop(0)
        return True
        

    def deleteLast(self) -> bool:
        """
        Deletes an item from the rear of Deque. Return true if the operation is successful.
        """
        if len(self.q) == 0:
            return False
        self.q.pop(-1)
        return True

    def getFront(self) -> int:
        """
        Get the front item from the deque.
        """
        if len(self.q) == 0:
            return -1
        return self.q[0]


    def getRear(self) -> int:
        """
        Get the last item from the deque.
        """
        if len(self.q) == 0:
            return -1
        return self.q[-1]

    def isEmpty(self) -> bool:
        """
        Checks whether the circular deque is empty or not.
        """
        return len(self.q) == 0

    def isFull(self) -> bool:
        """
        Checks whether the circular deque is full or not.
        """
        return len(self.q) == self.qLen


# Your MyCircularDeque object will be instantiated and called as such:
# obj = MyCircularDeque(k)
# param_1 = obj.insertFront(value)
# param_2 = obj.insertLast(value)
# param_3 = obj.deleteFront()
# param_4 = obj.deleteLast()
# param_5 = obj.getFront()
# param_6 = obj.getRear()
# param_7 = obj.isEmpty()
# param_8 = obj.isFull()
# @lc code=end

