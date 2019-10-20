#!/usr/bin/env python
#-*-coding:utf-8-*-
# author:lwz


class Deque(object):
    def __init__(self, k):
        self.maxLength = k
        self.data = []

    def insertFront(self, item):
        if self.length < self.maxLength:
            self.data.insert(0, item)
            return True
        else:
            return False

    def insertLast(self, item):
        if self.length < self.maxLength:
            self.data.append(item)
            return True
        else:
            return False

    def deleteFront(self):
        if self.length > 0:
            return True
        else:
            return False

    def deleteLast(self):
        if self.length > 0:
            return True
        else:
            return False

    def getFront(self):
        if self.length > 0:
            return self.data[0]
        else:
            return -1

    def getRear(self):
        if self.length > 0:
            return self.data[-1]
        else:
            return -1

    def isEmpty(self):
        return self.length == 0

    def isFull(self):
        return self.length == self.maxLength

    @property
    def length(self):
        return len(self.data)

    def __str__(self):
        return str(self.data)

# 测试用例

deque = Deque(3)

print(deque.insertFront(5))
print(deque.insertLast(8))
print(deque.insertLast(7))
print(deque.insertFront(10))

print(deque.getFront())
print(deque.getRear())
print(deque.isFull())

print(deque, deque.length)

print(deque.deleteFront())
print(deque.deleteFront())


print(deque.deleteLast())
print(deque.deleteFront())
print(deque.deleteFront())
print(deque.deleteLast())
print(deque.length)
print(deque.isEmpty())

