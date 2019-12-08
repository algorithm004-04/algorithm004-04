# NOTE

## DFS模版

### 递归写法
```
def dfs(node: Node, visited:[Node]):
    if node in visited:
        return
    visited.append(node)
    #process current node

    for child in node.children:
        if child not in visited:
            dfs(child, visited)

```

### 迭代写法

```
def dfs(node: Node) -> [Node]:
    stack, visited = [node], []
    while stack:
        cur = stack.pop()
        visited.append(cur)
        stack += visited.children
    return visited
```

## DFS模版-二叉树版

### 递归写法

```
def dfs(node: Node, visited: [Node]):
    if node in visited:
        return
    
    visited.append(node)

    dfs(node.left, visited)
    dfs(node.right, visited)
```

### 迭代写法

```
def dfs(node: Node) -> [Node]:
    stack, visited = [node], []
    while stack:
        cur = stack.pop()
        visited.append(cur)
        stack.append(cur.right)
        stack.append(cur.left)
    return visited
```
## BFS模版

### 递归写法

```
def bfs(node: Node, visited: [Node]):
    queue, visited = [node], [node]
    while queue:
        cur = queue.pop()
        visited.append(cur)
        # process current node
        queue.push(cur.children)

```

## 解题思路
### 搜索旋转排序数组
此题考虑，若中值大于左值，则左侧有序，如果目标值在左侧范围内，则右界移到中点左侧；反之若中值小于左值则说明右侧有序，若目标值在右侧范围内，则左界移动到中点右侧。若某个中点值等于目标值则说明找到。

### 搜索二维矩阵
1. 先二分查找所在的行，再二分查找所在行的位置
2. 二维坐标一维化，对于某`m*n`的矩阵，一维化的坐标就是`m*n`，还原为二维坐标就是`[p // n][p % n]`

