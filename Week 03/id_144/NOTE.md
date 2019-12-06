# DFS & BFS

## DFS 代码模板

1. 递归写法

```
visted = set()

def dfs(node, visited):
    if node in visited: // terminator
        return

    visited.add(node)

    # process current node here.
    ...
    for next_node in node.children():
        if not next_node in visited:
            dfs(next_node, visited)            
```

2. 非递归写法

```
def DFS(self, tree):
    if tree.root is None:
        return []

    visited, stack = [], [tree.root]

    while stack:
        node = stack.pop()
        visited.add(node)

        process(node)
        nodes = generate_related_nodes(node)
        stack.push(nodes)

    # other processing work
    ...
```

## BFS 代码模板

类似树的按层遍历，使用一个 queue 来维护节点：

- 先将根节点放入 queue 中；
- 循环该 queue，pop 出一个节点，将其标记为已访问，
- 处理该节点，并将该节点的所有子节点 push 到 queue 中
- 直到 queue 为空，退出循环，遍历结束

由于 queue 是先进先出的顺序，所以节点的访问顺序也是按层来访问的，即广度优先遍历。

```
def BFS(graph, start, end):
    queue = []
    queue.append([start])
    visited.add(start)

    while queue:
        node = queue.pop()
        visited.add(node)

        process(node)
        nodes = generate_related_nodes(node)
        queue.push(nodes)

    # other processing work
    ...
```

# 贪心算法

贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法。

## 贪心算法 vs 动态规划

贪心算法与动态规划的不同在于它对于每个子问题的解决方案都做出选择，不能回退。动态规划则会**保存以前的运算结果**，并根据以前的结果对当前进行选择，有回退功能。

- **贪心：**当下做局部最优判断
- **回溯：**能够回退
- **动态规划：**最优判断 + 回退

## 使用贪心算法的场景

问题能够分解成子问题来解决，子问题的最优解能地退到最终问题的最优解。这种子问题最优解成为最优子结构。

如：

- 求图中的最小生成树
- 求哈夫曼编码

## Tips

- 贪心算法可能从前往后贪（如 122 题），也可能从后往前贪（如 55 题）
- 一旦一个问题可以通过贪心法来解决，那么通常是解决这个问题的最好办法
- 由于贪心法的高效性及其所求得的答案比较接近最优结果，贪心法也可以作为辅助算法或者直接解决一些要求结果不特别精确的问题

# 二分查找

## 二分查找的前提

1. 目标函数单调性（单调递增或者递减）
2. 存在上下界（bounded）
3. 能够通过索引访问（index accessible）

## 代码模板

```
left, right = 0, len(arr) - 1
while left <= right:
    mid = (left + right) / 2
    if arr[mid] == target:
        # find the target!!
        break or return result
    elif arr[mid] < target:
        left = mid + 1
    else:
        right = mid - 1
```



  

