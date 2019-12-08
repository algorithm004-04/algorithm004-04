# 深度优先搜索和广度优先搜索
## 搜索-遍历
- 每个节点都要访问一次
- 每个节点仅仅访问一次
- 对于节点的访问顺序不限
    - DFS（depth first search）
    - BFS (breadth first search)
    - 优先级优先（启发式搜索？？估价函数？？）
  

## DFS代码模板
```js
const visited = new Set()
function dfs(node,visited){
  //terminator
  if(visited.has(node)) return
  visited.add(node)
  //process current node here
  //...
  for (next_node in node.children()){
    if(!visited.has(next_node)){
      dfs(next_node,visited)
    }
  }
}
```