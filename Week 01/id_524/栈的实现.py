#!/usr/bin/env python
#-*-coding:utf-8-*-
# author:lwz

class Stack(object):

    def __init__(self):
        self.data = []

    def push(self, item):
        self.data.append(item)

    def pop(self):
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

stack = Stack()

stack.push(1)
print(stack, stack.length)
print(stack.pop())
print(stack.pop())
