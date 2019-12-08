# 处理四联通问题的技巧
定义x和y方向的偏移，存储在数组中，用循环的方式简化代码

```
dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]

x, y = cur_positon
for i in range(4):
    x + dx, y + dy
```

# 并查集的实现

```
class UnionSet:
    def __init__(self, p):
        self.p = [i for i in range(p)]
    
    def parent(self, i):
        root = i
        while self.p[root] != root:
            root = self.p[root]

        while self.p[i] != i:
            x = i; i = self.p[i]; self.p[x] = root
        
        return root

    def union(self, i, j):
        pi = self.parent(i)
        pj = self.parent(j)
        self.p[pj] = pi
```

