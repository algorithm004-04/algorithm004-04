# -*- coding: utf8 -*-
"""
给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。

状态转移方程 dp[i,j] = min(dp[i-1][j],dp[i][j-1]) + grid[i][j]
"""


def print_matrix(matrix):
    """
    打印二维矩阵
    :param matrix:
    :return:
    """
    for mtx in matrix:
        print(mtx)


class Solution(object):
    def minPathSum(self, grid):
        """
        状态转移方程 dp[i,j] = min(dp[i-1][j],dp[i][j-1]) + grid[i][j]
        :type grid: List[List[int]]
        :rtype: int
        """
        n = len(grid)
        m = len(grid[0])
        # 初始化状态转移表
        dp = []
        for i in range(n):
            dp.append([])
            for j in range(m):
                dp[i].append(0)
        # 初始化状态转移表dp第一行
        sum = 0
        for j in range(m):
            sum += grid[0][j]
            dp[0][j] = sum
        # 初始化状态转移表dp第一列
        sum = 0
        for i in range(n):
            sum += grid[i][0]
            dp[i][0] = sum
        # 从第二行和第二列，开始根据状态转移方程填状态转移表
        for i in range(1, n):
            for j in range(1, m):
                dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
        return dp[n - 1][m - 1]


if __name__ == '__main__':
    slt = Solution()
    grid = [[1, 3, 1], [1, 5, 1], [4, 2, 1]]
    grid = [[1]]
    print(slt.minPathSum(grid))
