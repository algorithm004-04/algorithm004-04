class MyCircularDeque:
    def __init__(self, k):
        self.k, self.q = k, []

    def insertFront(self, value):
        if len(self.q) < self.k:
            self.q.insert(0, value)
            return True
        return False

    def insertLast(self, value):
        if len(self.q) < self.k:
            self.q += [value]
            return True
        return False

    def deleteFront(self):
        return self.q.pop(0) <= float('inf') if self.q else False

    def deleteLast(self):
        return self.q.pop() <= float('inf') if self.q else False

    def getFront(self):
        return self.q[0] if self.q else -1

    def getRear(self):
        return self.q[-1] if self.q else -1

    def isEmpty(self):
        return len(self.q) == 0

    def isFull(self):
        return len(self.q) == self.k