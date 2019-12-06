class ListNode:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None


class LRUCache:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.map = {}
        self.head = None
        self.tail = None

    def get(self, key: int) -> int:
        if key not in self.map:
            return -1
        self._pull_and_prepend(self.map[key])
        return self.map[key].value

    def put(self, key: int, value: int) -> None:
        if key in self.map:
            self.map[key].value = value
            self._pull_and_prepend(self.map[key])
        else:
            if len(self.map) == self.capacity:
                self._pop()
            self._prepend(ListNode(key, value))

    def _pull_and_prepend(self, node: ListNode):
        if node is self.head:
            return
        if node is self.tail:
            node.prev.next, self.tail = None, node.prev
            self.head.prev, node.next = node, self.head
            self.head, node.prev = node, None
            return
        node.prev.next, node.next.prev = node.next, node.prev
        self.head.prev, node.next = node, self.head
        self.head, node.prev = node, None

    def _prepend(self, node: ListNode):
        if len(self.map) == 0:
            self.head, self.tail = node, node
        else:
            self.head.prev, node.next = node, self.head
            self.head = node
        self.map[node.key] = node

    def _pop(self):
        if len(self.map) == 0:
            return
        node = self.tail
        if len(self.map) == 1:
            self.head, self.tail = None, None
        else:
            self.tail, node.prev.next = node.prev, None
        del self.map[node.key]


# Your LRUCache object will be instantiated and called as such:
cache = LRUCache(2)

cache.put(1, 1)
cache.put(2, 2)
cache.get(1)
cache.put(3, 3)
cache.get(2)
cache.put(4, 4)
cache.get(1)
cache.get(3)
cache.get(4)
