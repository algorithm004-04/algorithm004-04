'''
146. LRU缓存机制
运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用
的数据值，从而为新的数据值留出空间。

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

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/lru-cache
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
'''

'''
法一：有序字典：哈希+链表
复杂度分析
时间复杂度：对于 put 和 get 操作复杂度是O(1)，因为有序字典中的所有操作：get/in/set/move_to_end/popitem
            （get/containsKey/put/remove）都可以在常数时间内完成。
空间复杂度：O(capacity)，因为空间只用于有序字典存储最多 capacity + 1 个元素。


from collections import OrderedDict

class LRUCache(OrderedDict):
    def __init__(self, capacity):
        self.capacity = capacity

    def put(self, key, value):
        if key in self:
            self.move_to_end(key) #last=True，将key引导最后
        self[key] = value
        if len(self) > self.capacity:
            self.popitem(last=False) #按先进先出的方式删除最前面的元素，last=True：后进先出

    def __get__(self, key):
        if key in self:
            self.move_to_end(key)
            return self[key]
        return -1
'''

'''
法二：双向链表 + 哈希
复杂度分析
时间复杂度：对于 put 和 get 操作复杂度是O(1)
空间复杂度：O(capacity)，因为空间只用于有序字典存储最多 capacity + 1 个元素。
'''
class DLinkNode():
    def __init__(self):
        self.key = 0
        self.value = 0
        self.prev = None
        self.next = None
class LRUCache():
    def _add_node(self, node):
        node.prev = self.head
        node.next = self.head.next

        self.head.next.prev = node
        self.head.next = node
    def _remove_node(self, node):
        node.next.prev = node.prev
        node.prev.next = node.next
    def _move_to_head(self, node):
        self._remove_node(node)
        self._add_node(node)
    def _pop_tail(self):
        self._remove_node(self.tail.prev)
        return self.tail.prev
    def __init__(self, capacity):
        self.cache = {}
        self.size = 0
        self.capacity = capacity
        self.head = DLinkNode()
        self.tail = DLinkNode()
        self.head.next = self.tail
        self.tail.prev = self.head

    def get(self, key):
        node = self.cache.get(key, None)
        if not node:
            return -1
        self._move_to_head(node)
        return node.value
    def put(self, key, value):
        node = self.cache.get(key)
        if not node:
            new_node = DLinkNode()
            new_node.key = key
            new_node.value = value
            self.cache[key] = new_node.key
            self._add_node(new_node)
            self.size += 1
            if self.size > self.capacity:
                tail = self._pop_tail()
                del self.cache[tail.key]
                self.size -= 1
        node.value = value
        self._move_to_head(node)


