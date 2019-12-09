#
# @lc app=leetcode.cn id=200 lang=python3
#
# [200] 岛屿数量
#

# @lc code=start
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        def flood_fill(i, j):  # 用来把相连的陆地置零
            if grid[i][j] == '1':  # 如果某点是陆地，就置零
                grid[i][j] = '0'
                flood_fill(i-1, j)  # 对上下左右（相连的地方）作相同的操作
                flood_fill(i+1, j)
                flood_fill(i, j-1)
                flood_fill(i, j+1)
        
        if not grid: return 0  # 如果矩阵为空，返回0
        grid = [['0'] + row + ['0'] for row in grid]  # 拓宽左右边界
        grid = [['0'] * len(grid[0])] + grid + [['0'] * len(grid[0])]  # 拓宽上下边界
        m, n = len(grid), len(grid[0])  # 拓宽后的矩阵的深度为m， 宽度为n
        count = 0  # 设置count变量计数
        for i in range(1, m-1):  # 遍历矩阵
            for j in range(1, n-1):
                if grid[i][j] == '1':  # 如果某个点是陆地
                    count += 1  # 岛屿数量加一
                flood_fill(i, j)  # 并把相连的陆地都置零，避免重复计数
        return count
# @lc code=end

