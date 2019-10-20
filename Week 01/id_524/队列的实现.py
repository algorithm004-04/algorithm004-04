#!/usr/bin/env python
#-*-coding:utf-8-*-
# author:lwz

class Queue(object):
    def __init__(self):
        self.data = []

    def add(self, item):
        self.data.insert(0, item)

    def get(self):
        if self.length > 0:
            return self.data.pop()
        else:
            return None

    @property
    def length(self):
        return len(self.data)

    def __str__(self):
        return str(self.data)


# 测试用例
queue = Queue()

queue.add(10)
print(queue, queue.length)
print(queue.get())
print(queue.get())


