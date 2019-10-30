class MyCircularDeque:
    def __init__(self, k: int):
        self.queue = [0] * k
        self.front, self.rear, self.size = 0, 0, 0

    def insertFront(self, value: int):
        if self.isFull():
            return False
        elif self.isEmpty():
            self.queue[self.front] = value
        # self.front = (self.front-1) % len(self.queue)       # (self.front-1) 这里的意思是当在队头加入value时，front可以视为往前移动一位，
        # self.queue[self.front] = value                      # % len(self.queue) 相对于首尾相连的循环队列的位置
        # self.size += 1
        else:
            self.front = (self.front - 1) % len(self.queue)
            self.queue[self.front] = value
            self.size += 1
        return True

    def insertLast(self, value: int):
        if self.isFull():
            return False
        if self.isEmpty():
            self.queue[self.rear] = value
        # self.rear = (self.rear+1) % len(self.queue)       # 正确方式是要加上else，因为执行第二个if后悔继续往下执行，修改指针位置
        # self.queue[self.rear] = value
        # self.size += 1
        else:
            self.rear = (self.rear+1) % len(self.queue)
            self.queue[self.rear] = value
            self.size += 1
        return True

    def deleteFront(self):
        if self.isEmpty():
            return False
        self.queue[self.front] = 0
        self.front = (self.front+1) % len(self.queue)
        self.size -= 1
        if self.isEmpty():
            self.front = self.rear

    def deleteLast(self):
        if self.isEmpty():
            return False
        self.queue[self.rear] = 0
        self.rear = (self.rear-1) % len(self.queue)
        self.size -= 1
        if self.isEmpty():
            self.rear = self.front

    def getFront(self) -> int:
        if self.isEmpty():
            return -1
        return self.queue[self.front]

    def getRear(self) -> int:
        if self.isEmpty():
            return -1
        return self.queue[self.rear]

    def isEmpty(self) -> bool:
        if self.size == 0:
            return True
        return False

    def isFull(self) -> bool:
        if len(self.queue) == self.size:
            return True
        return False
