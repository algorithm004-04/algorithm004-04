# NOTE

## 解题思路

1. 升高维度
2. 空间换时间

## 深度优先搜索和广度优先搜索

> 遍历  
1. 每个节点都要访问一次
2. 每个节点仅仅访问一次
3. DFS、BFS、优先级优先

> DFS模板

递归  
```py
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
非递归
```py
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

> BFS模板

```py
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
每一步都选择当前最优解，以至全局结果是最优解

> 使用时机
1. 子问题最优解，得到全局最优解

> 贪心、回溯、动态规划的区别
1. 贪心：局部最优解
2. 回溯：回退
3. 动态规划：最优判断 + 回退

> assign-cookies
> 链接：https://leetcode-cn.com/problems/assign-cookies
```java
public static int findContentChildren(int[] g, int[] s) {
    int max=0;
    Arrays.sort(g);
    Arrays.sort(s);
    // 先满足最小胃口的小孩
    for(int i = 0,j =0;i< g.length && j<s.length;){
        if(g[i]<= s[j]){
            i++;
            j++;
            max++;
        }else { // 不能满足 则选择下一个饼干
            j++;
        }
    }
    return max;
}
```

## 二分查找
> 使用时机  
1. 单调性
2. 有上下界
3. 可index索引

> 代码模板  

python
```py
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
## 实例

> 实现 int sqrt(int x) 函数。
> 链接：https://leetcode-cn.com/problems/sqrtx  

分析： $\sqrt(x)<x$， 

边界值(舍去整数部分):   
$\sqrt(0)=0$  
$\sqrt(1)=1$  
$\sqrt(2)=1.414 \approx 1$  
$\sqrt(3)=1.732 \approx 1$  
$\sqrt(4)=2$  

进一步 得到 $(x/2)^2 <= x$   
下界：$0$  
上界：$x/2 + 1$  

套用模板  
```java
public int mySqrt(int x) {
  // 1.边界终止条件
  if(x==0 || x ==1){
      return x;
  }
  // 2.定义上下界
  long left =1;
  long right = x/2 +1;
  
  while(left <= right){
      // 3.取中间值
      // int mid = (right + left)/2; // 这里 大数相加的时候可能会溢出
      // 以下是处理方式
      // int mid = left + (right - left)/2; // 不使用加法
      // int mid = (left + right) >>> 1; // 无符号 位运算 加速运算
      long mid = (left + right) >>> 1; 

      if(mid * mid > x){
        right = mid - 1;
      } else {
        left = mid + 1;
      }
  }
  return (int)right;
}
```


> 搜索旋转排序数组
> 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array

```java
public static int search(int[] nums, int target) {
    // 在一组给定的数组中找到 某个target值， 时间复杂度 logn 使用二分查找
    int left = 0;
    int right = nums.length - 1;

    while (left < right){
        // 取中索引
        int mid = (left + right) >>>1;
        // 判断中值 三个条件需要满足
        if((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid])){
            left = mid +1;
        } else {
            right = mid;
        }
    }

    return (left == right) && target == nums[left] ? left : -1;
};
```

> 搜索二维矩阵
> 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
```java
public static  boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    if(m == 0) return false;
    int n = matrix[0].length;

    int left = 0;
    int right = m * n - 1; // 二维数组当成一位数组
    int midIndex,midValue;
    while (left <= right){
        midIndex = (left + right) >>> 1;
        midValue = matrix[midIndex / n][midIndex % n];
        if (target == midValue) {
            return true;
        } else if(target < midValue){
            right = midIndex - 1;
        }else {
            left = midIndex + 1;
        }
    }

    return false;
};
```

## 牛顿迭代法
> TODO