from collections import OrderedDict
class LRUCache(OrderedDict):
    # 申请一个空间
    def __init__(self, capacity):
        self.capacity = capacity

    # get如果没有返回-1，如果有返回并且移动到头部
    def get(self, key):
        if key not in self:
            return - 1
        
        self.move_to_end(key)
        return self[key]

    # put如果capacity里有放到头部，如果没有放到尾部，如果超过容量把最后一个移出去
    def put(self, key, value):
        if key in self:
            self.move_to_end(key)
        self[key] = value
        if len(self) > self.capacity:
            self.popitem(last = False)