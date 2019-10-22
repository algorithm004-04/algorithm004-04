#
# @lc app=leetcode.cn id=641 lang=python3
#
# [641] 设计循环双端队列
#
# https://leetcode-cn.com/problems/design-circular-deque/description/
#
# algorithms
# Medium (46.41%)
# Likes:    17
# Dislikes: 0
# Total Accepted:    2.1K
# Total Submissions: 4.5K
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
        self.size = k
        self.head = None
        self.last = None
        self.count = 0
        
    class Node:
        def __init__(self, value: int):
            self.value = value
            self.left = None
            self.right = None


    def insertFront(self, value: int) -> bool:
        if self.count == self.size: return False
        new = MyCircularDeque.Node(value)
        if self.head != None:
            new.right = self.head
            self.head.left = new
        self.head = new
        if self.last == None:
            self.last = new
        self.count += 1        
        return True

    def insertLast(self, value: int) -> bool:
        if self.count == self.size: return False
        new = MyCircularDeque.Node(value)
        if self.last != None:
            new.left = self.last
            self.last.right = new
        self.last = new
        if self.head == None:
            self.head = new
        self.count += 1
        return True

    def deleteFront(self) -> bool:
        if self.count == 0: return False
        newhead = self.head.right
        if newhead != None:
            self.head.right = None
            newhead.left = None
        self.head = newhead
        self.count -= 1
        if self.count == 0:
            self.last = None
        return True
        
    def deleteLast(self) -> bool:
        if self.count == 0: return False
        newlast = self.last.left
        if newlast != None:
            self.last.left = None
            newlast.right = None
        self.last = newlast
        self.count -= 1
        if self.count == 0:
            self.head = None
        return True

    def getFront(self) -> int:
        if self.count == 0: return -1
        return self.head.value
        

    def getRear(self) -> int:
        if self.count == 0: return -1
        return self.last.value
        

    def isEmpty(self) -> bool:
        return self.count == 0
        

    def isFull(self) -> bool:
        return self.size == self.count
        

op = ["MyCircularDeque","insertFront","deleteLast","deleteLast","insertLast","getRear","insertLast","isFull","getRear","isFull","deleteLast","isEmpty","getFront","isEmpty","insertFront","isEmpty","insertLast","getRear","getFront","deleteLast","deleteLast","insertLast","insertLast","deleteLast","getFront","insertLast","isEmpty","getFront","insertFront","insertLast","insertFront","deleteLast","getRear","getRear","insertFront","insertLast","deleteFront","getFront","getFront","insertLast","getFront","getFront","insertFront","getFront","deleteFront","deleteFront","deleteFront","insertLast","getRear","insertFront","isFull","insertLast","deleteLast","getRear","deleteLast","getRear","insertFront","deleteLast","insertLast","insertLast","getFront","getRear","insertFront","insertLast","insertLast","insertFront","getRear","getRear","deleteLast","insertFront","getFront","insertFront","insertLast","getRear","insertFront","insertLast","deleteFront","isEmpty","getRear","insertLast","insertFront","getFront","getRear","insertFront","insertLast","deleteLast","deleteLast","isFull","insertLast","deleteLast","deleteFront","insertFront","getRear","isFull","deleteFront","getFront","getRear","isEmpty","getFront","deleteLast","getRear","insertLast"]
value = [[71],[47],[],[],[66],[],[72],[],[],[],[],[],[],[],[53],[],[15],[],[],[],[],[9],[87],[],[],[98],[],[],[33],[40],[21],[],[],[],[69],[14],[],[],[],[60],[],[],[15],[],[],[],[],[97],[],[66],[],[23],[],[],[],[],[30],[],[54],[18],[],[],[50],[24],[24],[25],[],[],[],[0],[],[86],[31],[],[55],[55],[],[],[],[18],[49],[],[],[53],[44],[],[],[],[46],[],[],[58],[],[],[],[],[],[],[],[],[],[61]]
deque = MyCircularDeque(value[0][0])
result = [None]

for i, o in enumerate(op):
    if o == "insertFront":
        result.append(deque.insertFront(value[i][0]))
    elif o == "getRear":
        result.append(deque.getRear())
    elif o == "insertLast":
        result.append(deque.insertLast(value[i][0]))
    elif o == "deleteFront":
        result.append(deque.deleteFront())
    elif o == "deleteLast":
        result.append(deque.deleteLast())
    elif o == "getFront":
        result.append(deque.getFront())
    elif o == "isEmpty":
        result.append(deque.isEmpty())
    elif o == "isFull":
        result.append(deque.isFull())
print(result)

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

