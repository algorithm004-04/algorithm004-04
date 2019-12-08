# coding=utf-8

"""
给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

示例 1:
输入:
11110
11010
11000
00000
输出: 1

示例 2:
输入:
11000
11000
00100
00011
输出: 3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-islands
"""
from typing import List


class Solution:
    # 好理解
    def numIslands(self, grid: List[List[str]]) -> int:
        result = 0
        if not grid:
            return result
        self.grid = grid
        m, n = len(grid), len(grid[0])
        self.m, self.n = m, n
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    self._dfs(i, j)
                    result += 1
        return result

    def _dfs(self, hor: int, ver: int) -> None:
        if hor < 0 or hor > self.m or ver < 0 or ver > self.n or self.grid[hor][ver] != '1':
            return
        self._dfs(hor + 1, ver)
        self._dfs(hor - 1, ver)
        self._dfs(hor, ver + 1)
        self._dfs(hor, ver - 1)
        return


if __name__ == '__main__':
    params = [
        [['1', '1', '1', '1', '0'],
         ['1', '1', '0', '1', '0'],
         ['1', '1', '0', '0', '0'],
         ['0', '0', '0', '0', '0'], 1],
        [['1', '1', '0', '0', '0'],
         ['1', '1', '0', '0', '0'],
         ['0', '0', '1', '0', '0'],
         ['0', '0', '0', '1', '1'], 3],
    ]
