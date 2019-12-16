# NOTE

  

### 双向BFS代码模版

~~~python
def BFS(graph, start, end):
	start_visited = set()
	start_queue = [] 
	start_queue.append([start]) 
	end_visited = set()
	end_queue = [] 
	end_queue.append([end])
	queue = []
	while start_queue or end_queue: 
    if len(start_queue) <= len(end_queue):
      node = start_queue.pop() 
      start_visited.add(node)
      process(node) 
      nodes = generate_related_nodes(node) 
      start_queue.push(nodes)
    else:
      node = end_queue.pop() 
      end_visited.add(node)
      process(node) 
      nodes = generate_related_nodes(node) 
      end_queue.push(nodes)

	# other processing work 
	...
~~~



