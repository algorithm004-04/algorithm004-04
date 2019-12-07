class MyCircularDeque:

    def __init__(self, k):
        self.deque = []
        self.size = k

    def insertFront(self, value):
        if self.size > len(self.deque):
            self.deque.insert(0, value)
            return True
        return False

    def insertLast(self, value):
        if self.size > len(self.deque):
            self.deque.append(value)
            return True
        return False

    def deleteFront(self):
        if len(self.deque) > 0:
            self.deque.pop(0)
            return True
        return False

    def deleteLast(self):
        if len(self.deque) > 0:
            if len(self.deque) == 1:
                self.deque = []
            else:
                self.deque = self.deque[:-1]
            return True
        return False

    def getFront(self):
        if len(self.deque) != 0:
            return self.deque[0]
        return -1

    def getRear(self):
        if len(self.deque) != 0:
            return self.deque[len(self.deque)-1]
        return -1

    def isEmpty(self):
        return len(self.deque) == 0

    def isFull(self):
        return self.size == len(self.deque)


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
