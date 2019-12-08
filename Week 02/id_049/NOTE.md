本周主要练习两大块内容哈希和递归
哈希总结就是把暴力法中的一层的O(n)优化成O(1)，一种很常见的升维、以空间换时间的思维
递归就是把一个大问题拆分成各个子问题，推导出递推公式找到边界条件
树的面试题解法一般都是递归，为什么？
递归用于：1.问题可以分解成若干个重复子问题，2.问题和子问题可以用相同解法，3.有明确的终止条件；树型结构符合这一特点，整个树和部分树的结构相似度很高，所以逻辑清晰。树是一个非线性结构，使用广度优先方法进行遍历
递归模板
```python
def recursion(level, param1, param2, ...):
    if level > MAX_LEVEL:
        process_result
        return
    process(level,data)
    self. recursion(level+1,p1 ...)

    # reverse current level states if needed
```

```python
def divide_conuer(problem,p1,p2 ...):
    if problem is None:
        print result
        return res
    data = prepare_data(problem)
    subproblems = split_problem(problem,data)
    subresult1 = self.divide_conuer(subproblems[0], p1, ...)
    subresult2 = self.divide_conuer(subproblems[2], p1, ...)
    subresult3 = self.divide_conuer(subproblems[3], p1, ...)

    result = process_result(subresult1,subresult2,subresult3)
    # revert current level states if needed
```
本周作业基本完成，只是留给回溯和分治的时间太少了，等全部学完再继续刷题巩固