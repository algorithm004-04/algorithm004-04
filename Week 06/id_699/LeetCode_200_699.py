#
# @lc app=leetcode.cn id=200 lang=python3
#
# [200] 岛屿数量
#
# https://leetcode-cn.com/problems/number-of-islands/description/
#
# algorithms
# Medium (45.59%)
# Likes:    271
# Dislikes: 0
# Total Accepted:    37.6K
# Total Submissions: 82.2K
# Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
#
# 给定一个由 '1'（陆地）和
# '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
# 
# 示例 1:
# 
# 输入:
# 11110
# 11010
# 11000
# 00000
# 
# 输出: 1
# 
# 
# 示例 2:
# 
# 输入:
# 11000
# 11000
# 00100
# 00011
# 
# 输出: 3
# 
# 
#

# @lc code=start
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if len(grid) == 0 or len(grid[0]) == 0:
            return 0
        row_num = len(grid)
        row_lengh = len(grid[0])

        result = 0

        def to_zero(m, n):
            if grid[m][n] == "1":
                grid[m][n] = "0"
                if n+1 < row_lengh:
                    to_zero(m, n+1)
                if m+1 < row_num:
                    to_zero(m+1, n)
                if n-1 >= 0:
                    to_zero(m, n-1)
                if m-1 >= 0:
                    to_zero(m-1, n)
                return 1
            return 0
        
        for m in range(row_num):
            for n in range(row_lengh):
                result += to_zero(m, n)
        
        return result

# @lc code=end

