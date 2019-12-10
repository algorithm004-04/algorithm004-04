class Node:
    def __init__(self, k, v):
        self.key = k
        self.val = v
        self.next = None
        self.prev = None

class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.m = {}
        self.head = Node(0, 0)
        self.tail= Node(0, 0)
        self.head.next = self.tail
        self.tail.prev = self.head

    def get(self, key: int) -> int:
        if key not in self.m:
            return -1
        n = self.m[key]
        self.remove(n)
        self.add(n)
        return n.val

    def put(self, key: int, value: int) -> None:
        if key in self.m:
            self.remove(self.m[key]) 
        n = Node(key, value)    
        self.add(n)
        self.m[key] = n 
        if len(self.m) > self.capacity:
            h = self.head.next
            self.remove(h)
            del self.m[h.key]

    def add(self, n):    
        t = self.tail.prev
        t.next = n
        self.tail.prev = n
        n.prev = t
        n.next = self.tail
        
    def remove(self, n):    
        b = n.prev
        e = n.next
        b.next = e
        e.prev = b
        
# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
