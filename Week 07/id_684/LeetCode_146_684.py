# -*- coding: utf8 -*-

"""
运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。

进阶:

你是否可以在 O(1) 时间复杂度内完成这两种操作？

示例:

LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // 返回  1
cache.put(3, 3);    // 该操作会使得密钥 2 作废
cache.get(2);       // 返回 -1 (未找到)
cache.put(4, 4);    // 该操作会使得密钥 1 作废
cache.get(1);       // 返回 -1 (未找到)
cache.get(3);       // 返回  3
cache.get(4);       // 返回  4

"""
import collections

class LRUCache3(object):

	def __init__(self, capacity):
		self.dic = collections.OrderedDict()
		self.remain = capacity

	def get(self, key):
		if key not in self.dic:
			return -1
		v = self.dic.pop(key)
		self.dic[key] = v   # key as the newest one
		return v

	def put(self, key, value):
		if key in self.dic:
			self.dic.pop(key)
		else:
			if self.remain > 0:
				self.remain -= 1
			else:   # self.dic is full
				self.dic.popitem(last=False)
		self.dic[key] = value


class LRUCache2(object):
    """
    超时
    """
    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.data = []
        self._capacity = capacity

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        res_idx = None
        res = None
        for idx,item in enumerate(self.data):
            if item.get(key) is not None:
                res_idx = idx
                res = item
                break
        if res_idx is not None and res is not None:
            self.data.append(self.data.pop(res_idx))
            return res.get(key)
        return -1

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        item = {key:value}
        idx = self.get_idx(key)
        if idx is not None:
            self.data.pop(idx)
            self.data.append(item)
        else:
            size = len(self.data)
            if size >= self._capacity:
                self.data.pop(0)
            self.data.append(item)

    def get_idx(self,key):
        """
        :param key:
        :return:
        """
        for idx, item in enumerate(self.data):
            if list(item.keys())[0] == key:
                return idx
        return None

class LRUCache(object):

    """
    python3 代码，python3.6 以后字典是有序的
    """
    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.data = {}
        self._capacity = capacity

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        res = self.data.get(key)
        if res:
            self.data.pop(key)
            self.data[key] = res
            return res
        else:
            return -1

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """

        if key in self.data:
            self.data.pop(key)
            self.data[key] = value
        else:
            size = len(self.data)
            if size >= self._capacity:
                del_key = list(self.data.keys())[0]
                self.data.pop(del_key)
                self._capacity -= 1
            self.data[key] = value




if __name__ == '__main__':
    cache = LRUCache(2)
    cache.put(1, 1)
    cache.put(2, 2)
    print(cache.get(1))
    cache.put(3, 3)
    print(cache.get(2))
    print(cache.data)
    cache.put(4, 4)
    # cache.put(4, 5)
    print(444,cache.data)
    print(cache.get(1))
    print(cache.data)
    print(cache.get(3))
    print(cache.get(4))
    print(cache.data)

