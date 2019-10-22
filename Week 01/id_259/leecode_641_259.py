'''
设计实现双端队列。
你的实现需要支持以下操作：

MyCircularDeque(k)：构造函数,双端队列的大小为k。
insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
isEmpty()：检查双端队列是否为空。
isFull()：检查双端队列是否满了。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/design-circular-deque
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
'''

'''
使用双向链表实现

class Node:
    def __init__(self, value):
        self.val = value
        self.next = self.pre = None

class MyCircularDeque:
    def __init__(self, k):
        self.head = self.tail = Node(-1)
        self.head.next = self.tail
        self.tail.pre = self.head
        self.size = k
        self.cursize = 0

    def __add__(self, value, preNode):
        new = Node(value)
        new.pre = preNode
        new.next = preNode.next
        new.pre.next = new.next.pre = new
        self.cursize += 1

    def __remove__(self, preNode):
        node = preNode.next
        preNode.next = node.next
        node.next.pre = node.pre
        self.cursize -= 1

    def insertFront(self, value):
        if self.cursize < self.size:
            self.__add__(value, self.head)
            return True
        return False

    def insertLast(self, value):
        if self.cursize < self.size:
            self.__add__(value, self.tail.pre)
            return True
        return False

    def deleteFront(self):
        if self.cursize:
            self.__remove__(self.head)
            return True
        return False

    def deleteLast(self):
        if self.cursize:
            self.__remove__(self.tail.pre.pre)
            return True
        return False

    def getFront(self, value):
        if self.cursize:
            value = self.head.next.val
            return value
        return -1

    def getRear(self, value):
        if self.cursize:
            value = self.tail.pre.val
            return value
        return -1

    def isEmpty(self):
        if self.cursize:
            return False
        return True

    def isFull(self):
        if self.cursize < self.size:
            return False
        return True
'''
'''
使用循环列表实现
'''
class MyCircularDeque:
    def __init__(self, k):
        self._size = 0
        self._front, self._rear = 0, 0
        self._capacity = k
        self._data = [-1] * k

    def insertFront(self, value):
        if self.isFull():
            return False
        if self.isEmpty():
            self._data[self._front] = value
        else:
            self._front = (self._front - 1) % self._capacity
            self._data[self._front] = value
        self._size += 1
        return True

    def insertLast(self, value):
        if self.isFull():
            return False

        if self.isEmpty():
            self._data[self._rear] = value
        else:
            self._rear = (self._rear + 1) % self._capacity
            self._data[self._rear] = value
        self._size += 1
        return True

    def deleteFront(self):
        if self.isEmpty():
            return False
        self._data[self._front] = -1
        self._front = (self._front + 1) % self._capacity
        self._size -= 1
        if self.isEmpty():
            self._rear = self._front
        return True

    def deleteLast(self):
        if self.isEmpty():
            return False
        self._data[self._rear] = -1
        self._rear = (self._rear - 1) % self._capacity
        self._size -= 1
        if self.isEmpty():
            self._front = self._rear
        return True

    def getFront(self):
        if self.isEmpty():
            return -1
        return self._data[self._front]

    def getRear(self):
        if self.isEmpty():
            return -1
        return self._data[self._rear]

    def isEmpty(self):
        return self._size == 0

    def isFull(self):
        return self._size == self._capacity

