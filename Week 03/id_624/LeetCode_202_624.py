#
# @lc app=leetcode.cn id=200 lang=python3
#
# [200] 岛屿数量
#
# https://leetcode-cn.com/problems/number-of-islands/description/
#
# algorithms
# Medium (45.63%)
# Likes:    263
# Dislikes: 0
# Total Accepted:    35.4K
# Total Submissions: 77.6K
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
    def numIslands(self, grid: [[str]]) -> int:
        if not grid: return 0
        w, h, count = len(grid[0]), len(grid), 0
        def dfs(x: int, y: int):
            if 0<= x < w and 0 <= y < h and grid[y][x] == "1": 
                grid[y][x] = "0"
                for p in [[x, y-1], [x+1, y], [x, y+1], [x-1, y]]: dfs(p[0], p[1])

        for i in range(h): 
            for j in range(w):
                if  grid[i][j] == "1":
                    count += 1
                    dfs(j, i)
        
        return count


# @lc code=end

