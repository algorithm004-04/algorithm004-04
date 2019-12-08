# 第三周学习总结
- DFS和BFS都是一种特殊递归，
- 深度优先搜索、广度优先搜索、优先级优先搜索
- 

## DFS（depth-first-search）
    DFS按深度递归，做题时比BFS相对难一些，重点是如何把问题分解成子问题
### 代码模板-递归写法
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
			dfs(next_node, visited)

```
### 代码模板-非递归写法
```python
def DFS(self, tree): 

	if tree.root is None: 
		return [] 

	visited, stack = [], [tree.root]

	while stack: 
		node = stack.pop() 
		visited.add(node)

		process (node) 
		nodes = generate_related_nodes(node) 
		stack.push(nodes) 

	# other processing work 
	...
```

## BFS（breadth-first-search）
    BFS按层递归，每一层递归完之后才能进入下一层，思路都很简单，代码中要记录当前遍历到第几层
### 代码模板
```python
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


## 贪心算法
    每一步都是当前最优，结果未必最优，适用于子问题最优，结果最优的使用场景

## 二分查找
    是实现有序数组查找的高效方法，每次与中间数值进行对比，一步一步的缩小范围，直到找到元素
    依赖于数组，需要连续存储内存，数据适中适合于二分查找

### 代码模板
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
  

