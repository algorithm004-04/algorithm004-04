# NOTE
## 手写递归伪代码
```python
def recursive(int i) -> int:
    # recursive terminator
    if STOP_Critea == TRUE:
	    return result
	
	#STEP Forward, drill down one more level
	cursor = cursor - 1
	
```

## DFS伪代码
```python
def dfs(node, visited):
  if node.visited:
    #already visited
    return
  visited.add(node)
  #process node here
  #...
  
  dfs(node.left, visited)
```

## BFS伪代码
```python
def bfs(node, start, end):
  queue = []
  visted.add(node)
  
  if queue:
    node = queue.pop()
	children = get_related_nodes(node)
	queue.push(children)
	
	#process nodes
```

  

