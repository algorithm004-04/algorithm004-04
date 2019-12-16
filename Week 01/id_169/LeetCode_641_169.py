class MyCircularDeque:

    def __init__(self, k: int):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        """
        self.size = k
        self.pipe = []

    def insertFront(self, value: int) -> bool:
        """
        Adds an item at the front of Deque. Return true if the operation is successful.
        """
        if len(self.pipe) == self.size: return False
        self.pipe.insert(0, value)
        return True

    def insertLast(self, value: int) -> bool:
        """
        Adds an item at the rear of Deque. Return true if the operation is successful.
        """
        if len(self.pipe) == self.size: return False
        self.pipe.append(value)
        return True

    def deleteFront(self) -> bool:
        """
        Deletes an item from the front of Deque. Return true if the operation is successful.
        """
        if len(self.pipe) == 0: return False
        self.pipe.pop(0)
        return True

    def deleteLast(self) -> bool:
        """
        Deletes an item from the rear of Deque. Return true if the operation is successful.
        """
        if len(self.pipe) == 0: return False
        self.pipe.pop()
        return True

    def getFront(self) -> int:
        """
        Get the front item from the deque.
        """
        if len(self.pipe) == 0: return -1
        return self.pipe[0]

    def getRear(self) -> int:
        """
        Get the last item from the deque.
        """
        if len(self.pipe) == 0: return -1
        return self.pipe[-1]

    def isEmpty(self) -> bool:
        """
        Checks whether the circular deque is empty or not.
        """
        return len(self.pipe) == 0

    def isFull(self) -> bool:
        """
        Checks whether the circular deque is full or not.
        """
        return len(self.pipe) == self.size


###############################################################################


"""
基于双向链表的实现
"""


class MyCircularDequeBasedOnDoubleLinkedList:

    def __init__(self, k: int):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        """
        self.size = k
        self.list = DoubleLinkedList()

    def insertFront(self, value: int) -> bool:
        """
        Adds an item at the front of Deque. Return true if the operation is successful.
        """
        if self.isFull(): return False
        self.list.prepend(value)
        return True

    def insertLast(self, value: int) -> bool:
        """
        Adds an item at the rear of Deque. Return true if the operation is successful.
        """
        if self.isFull(): return False
        self.list.append(value)
        return True

    def deleteFront(self) -> bool:
        """
        Deletes an item from the front of Deque. Return true if the operation is successful.
        """
        if self.isEmpty(): return False
        self.list.shift()
        return True

    def deleteLast(self) -> bool:
        """
        Deletes an item from the rear of Deque. Return true if the operation is successful.
        """
        if self.isEmpty(): return False
        self.list.pop()
        return True

    def getFront(self) -> int:
        """
        Get the front item from the deque.
        """
        if self.isEmpty(): return -1
        return self.list.getHead()

    def getRear(self) -> int:
        """
        Get the last item from the deque.
        """
        if self.isEmpty(): return -1
        return self.list.getTail()

    def isEmpty(self) -> bool:
        """
        Checks whether the circular deque is empty or not.
        """
        return len(self.list) == 0

    def isFull(self) -> bool:
        """
        Checks whether the circular deque is full or not.
        """
        return len(self.list) == self.size


class Node:

    def __init__(self, value: int):
        self.prev = None
        self.next = None
        self.value = value


class DoubleLinkedList:

    def __init__(self, head: Node = None):
        self.len = 0
        self.head = head
        self.tail = head

    def prepend(self, value: int):
        node = Node(value)
        if self.isEmpty():
            self.head, self.tail = node
        else:
            second = self.head
            node.next = second
            second.prev = node
            self.head = node
        self.len += 1
        return

    def append(self, value: int):
        node = Node(value)
        if self.isEmpty():
            self.head, self.tail = node
        else:
            tail = self.tail
            node.prev = tail
            tail.next = node
            self.tail = node
        self.len += 1
        return

    def shift(self):
        self.head = self.head.next
        self.len -= 1

    def pop(self):
        self.tail = self.tail.prev
        self.len -= 1

    def getHead(self):
        return self.head.value

    def getTail(self):
        return self.tail.value

    def isEmpty(self):
        return self.len == 0

    def __len__(self):
        return self.len
