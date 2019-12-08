#! /usr/bin/env python
# coding=utf-8

import collections


class LRUCache(object):

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.dict = collections.OrderedDict()
        self.capacity = capacity

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if key not in self.dict:
            return -1
        value = self.dict.pop(key)
        # 取值的时候会刷新
        self.dict[key] = value
        return value

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        if key in self.dict:
            self.dict.pop(key)
        else:
            if self.capacity > 0:
                self.capacity -= 1
            else:
                self.dict.popitem(last=False)
        self.dict[key] = value

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
