class Node:
    def __init__(self, v):
        self.v = v
        self.next = None
        self.prev = None

class MyCircularDeque:

    def __init__(self, k: int):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        """
        self.max = k
        self.l = []
        self.head = Node(0)
        self.tail = Node(0)
        self.head.next = self.tail
        self.tail.prev = self.head

    def insertFront(self, value: int) -> bool:
        """
        Adds an item at the front of Deque. Return true if the operation is successful.
        """
        if len(self.l) >= self.max:
            return False
        n = Node(value)
        t = self.head.next
        self.head.next = n
        t.prev = n
        n.next = t
        n.prev = self.head
        self.l.append(n)
        return True        

    def insertLast(self, value: int) -> bool:
        """
        Adds an item at the rear of Deque. Return true if the operation is successful.
        """
        if len(self.l) >= self.max:
            return False
        n = Node(value)
        t = self.tail.prev
        t.next = n
        n.next = self.tail
        n.prev = t
        self.tail.prev = n
        self.l.append(n)
        return True
        
        

    def deleteFront(self) -> bool:
        """
        Deletes an item from the front of Deque. Return true if the operation is successful.
        """
        if not len(self.l):
            return False
        t = self.head.next
        h = t.next
        self.head.next = h
        h.prev = self.head
        self.l.remove(t)
        return True

    def deleteLast(self) -> bool:
        """
        Deletes an item from the rear of Deque. Return true if the operation is successful.
        """
        if not len(self.l):
            return False
        t = self.tail.prev
        h = t.prev
        h.next = self.tail
        self.tail.prev = h
        self.l.remove(t)
        return True
        

    def getFront(self) -> int:
        """
        Get the front item from the deque.
        """
        if not len(self.l):
            return -1
        t = self.head.next
        return t.v

    def getRear(self) -> int:
        """
        Get the last item from the deque.
        """
        if not len(self.l):
            return -1
        t = self.tail.prev
        return t.v
        

    def isEmpty(self) -> bool:
        """
        Checks whether the circular deque is empty or not.
        """
        return len(self.l) == 0

    def isFull(self) -> bool:
        """
        Checks whether the circular deque is full or not.
        """
        return len(self.l) >= self.max


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
