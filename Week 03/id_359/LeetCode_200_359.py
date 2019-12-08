# 200. 岛屿数量
# https://leetcode-cn.com/problems/number-of-islands/
# 沉导策略 + BFS
# test case => grid为空，grid只有一行，grid无岛屿，grid有岛屿
class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not grid or not grid[0]:
            return 0
        def sink(level, col, maxLevel, maxCol):
            if col >= maxCol or level >= maxLevel or level < 0 or col < 0 or grid[level][col] == "0":# terminator
                return
            grid[level][col] = "0" # mark as visited
            sink(level-1, col, maxLevel, maxCol) # up
            sink(level, col+1, maxLevel, maxCol) # right
            sink(level, col-1, maxLevel, maxCol) # left
            sink(level+1, col, maxLevel, maxCol) # down

        maxLevel, maxCol, ans = len(grid), len(grid[0]), 0
        for i in range(maxLevel):
            for j in range(maxCol):
                if grid[i][j] == "1":
                    sink(i, j, maxLevel, maxCol)
                    ans += 1
        return ans