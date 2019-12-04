# NOTE
####  深度优先搜索
- 步骤
  1. 访问顶点v；
  2. 依次从v的未被访问的邻接点出发，对图进行深度优先遍历；直至图中和v有路径相通的顶点都被访问；
  3. 若此时图中尚有顶点未被访问，则从一个未被访问的顶点出发，重新进行深度优先遍历，直到图中所有顶点均被访问过为止。
##### 递归写法
```python
visited = set()
def dfs(node, visited):
  if node in visited: # terminator
    # already visited
    return

  visited.add(node)

  # process current node here.
  ...
  for next_node in node.children(): 
    if not next_node in visited:
       dfs(next node, visited)
```
##### 非递归写法
```python
def DFS(self, tree):
    if tree.root is None:
        return []
    visited, stack = [], [tree.root]
    while stack:
        node = stack.pop() visited.add(node)
        process (node)
        nodes = generate_related_nodes(node) 
        stack.push(nodes)
    # other processing work
    ...
```
#### 广度优先搜索
- 步骤
  1. 首先将根节点放入队列中。
  2. 从队列中取出第一个节点，并检验它是否为目标。如果找到目标，则结束搜寻并回传结果。否则将它所有尚未检验过的直接子节点加入队列中。
  3. 若队列为空，表示整张图都检查过了——亦即图中没有欲搜寻的目标。结束搜寻并回传“找不到目标”。
  4. 重复步骤2。
```python
visited = set()
def dfs(node, visited): 
    visited.add(node)
    # process current node here.
    ...
    for next_node in node.children(): 
       if not next_node in visited: 
          dfs(next node, visited)
```
#### 贪心和动态规划
- 贪心算法是一种在每一步选择中都采取在当前状态下最好或最优(即最有 利)的选择，从而希望导致结果是全局最好或最优的算法。
- 贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不 能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行 选择，有回退功能。
#### 二分查找
```python
left, right = 0, len(array) - 1 
while left <= right:
   mid = (left + right) / 2
   if array[mid] == target:
      # find the target!!
      break or return result
   elif array[mid] < target:
      left = mid + 1
   else:
      right = mid - 1
```

