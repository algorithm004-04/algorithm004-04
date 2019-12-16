# 我是如何解出了最小路径和（64）这个题目

首先拿到这个题目，第一反应就想到了不同路径（62）这个题目。可以非常直观的发现，到达一个点(i, j)的最小路径和，就是这个它的左侧或者上方的点的最小路径和加上当前点的数值，即f(i, j) = min(f(i-1, j) + f(i, j-1)) + (i, j)。有了这个状态转移方程，就可以着手写代码了，第一次我写出了这样的代码：

```
def minPathSum(self, grid: [[int]]) -> int:
    # 初始化dp数组，并将左上角的第一个元素放入
    dp = [[grid[0][0]]]
    # 将第一排元素放入，因第一排元素在最上方，所以最小路径和为f(i) = (i) + f(i-1)
    for i in range(1, len(grid[0])):
        dp[0].append(grid[0][i] + dp[i - 1])
    # 初始化剩余的元素，每一行的第一个元素的最小路径应该是f(i,0) = f(i - 1, 0) + (i, 0)
    for i in range(1, len(grid)):
        dp.append([dp[i - 1][0] + grid[i][0]] + [0]*(len(grid[0]-1)))
    
    for i in range(1, len(grid)):
        for j in range(1, len(grid[i])):
            dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
    return dp[-1][-1]
```

提交之后非常愉快的通过了，可惜速度不够快，值超过了6成的人。于是看了官方题解，自己又思考之后发现初始化的操作略显繁杂和多余。于是把复杂的初始化dp操作取消，转而融入到递推过程中去，于是代码变为下面的样子：

```
def minPathSum(self, grid: [[int]]) -> int:
    dp = [[0]*len(grid[0]) for _ in range(len(grid))]
    for i in range(len(grid)):
        for j in range(len(grid[i])):
            # 需要考虑第一行和第一列的元素
            if i == 0:
                dp[i][j] = grid[i][j] + dp[i][j - 1] if j > 0 else 0
            elif j == 0:
                dp[i][j] = grid[i][j] + dp[i - 1][j]
            else:
                dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
    return dp[-1][-1]
```

这次提交之后已经超过96%的人了。这时候还想到了二维dp一维化，这里刚好也适用，所以进一步优化代码如下：

```
def minPathSum(self, grid: [[int]]) -> int:
    dp = [0]*len(grid[0])
    for i in range(len(grid)):
        for j in range(len(grid[i])):
            if i == 0:
                dp[j] = grid[i][j] + dp[j - 1] if j > 0 else 0
            elif j == 0:
                dp[j] += grid[i][j]
            else:
                dp[j] = min(dp[j], dp[j - 1]) + grid[i][j]
    return dp[-1]
```

这次提交的效果就是时间超过99.89%，内存超过75%，已经非常优秀啦。

