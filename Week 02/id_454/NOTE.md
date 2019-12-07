# 第二周学习笔记

### 哈希表

### 映射

### 集合


### 递归
1、分解，将要解决的问题分为几个子问题，规模小但同类的子问题
2、求解，问题本身与分解之后的子问题，除了数据规模不同，求解思路完全一样且能够用简单的方法解决
3、存在递归终止条件，否则就会死递归（找到终止条件）
- 递归模板
```java
public void recur(int level, int param) { 

  // terminator 
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  } 

  // process current logic 
  process(level, param); 

  // drill down 
  recur( level: level + 1, newParam); 

  // restore current status 
 
}
```

### 分治【特殊的递归】
在递归的基础上增加合并操作，将要解决的问题的答案是分解之后子问题的合
- 分治模板
```python
def divide_conquer(problem, param1, param2, ...): 
  # recursion terminator 
  if problem is None: 
	print_result 
	return 

  # prepare data 
  data = prepare_data(problem) 
  subproblems = split_problem(problem, data) 

  # conquer subproblems 
  subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
  subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
  subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
  …

  # process and generate the final result 
  result = process_result(subresult1, subresult2, subresult3, …)
	
  # revert the current level states
```

### 回溯： 
又称为试探法 ，但当探索到某一步时，发现此选择无法满足题干条件 ，就退回一步重新选择 ，这种走不通就退回再走称为回溯法。

  

