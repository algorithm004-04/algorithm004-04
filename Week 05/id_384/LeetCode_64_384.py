class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if i - 1 >= 0 and j - 1 >= 0:
                    grid[i][j] += min(grid[i - 1][j], grid[i][j - 1])
                elif i - 1 >= 0:
                    grid[i][j] += grid[i - 1][j]
                elif j - 1 >= 0:
                    grid[i][j] += grid[i][j - 1]
        return grid[-1][-1]
