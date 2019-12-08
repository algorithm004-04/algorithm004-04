## 深度优先 & 广度优先
先来看下模板代码
DFS：深度优先算法 递归
``` python
def dfs(node):
   if node in visited:
     # already visited
     return
   visited.add(node)
   # process current node
   # ... # logic here
   dfs(node.left)
   dfs(node.right)
```
BFS：广度优先算法 非递归
``` python
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
```
