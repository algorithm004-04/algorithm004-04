#! /usr/bin/env python
# coding=utf-8

"""
给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
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

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-path-sum
"""


class Solution(object):
    # O(m*n)
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        m, n = len(grid), len(grid[0])
        for x in range(m):
            for y in range(n):
                if x == 0 and y != 0:
                    grid[x][y] = grid[x][y] + grid[x][y - 1]
                elif x != 0 and y == 0:
                    grid[x][y] = grid[x][y] + grid[x - 1][y]
                elif x == 0 and y == 0:
                    grid[x][y] = grid[x][y]
                else:
                    grid[x][y] = min(grid[x][y-1], grid[x-1][y]) + grid[x][y]
        return grid[m-1][n-1]


if __name__ == '__main__':
    sol = Solution()
    assert sol.minPathSum([
        [1, 3, 1],
        [1, 5, 1],
        [4, 2, 1]
    ]) == 7
