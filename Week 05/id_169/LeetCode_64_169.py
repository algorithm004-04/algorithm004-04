from typing import List

class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        if len(grid) == 0 or len(grid[0]) == 0: return 0
        m, n = len(grid[0]), len(grid)
        dp = [[0] * m] * n
        dp[n - 1][m - 1] = grid[n - 1][m - 1]
        for i in range(n - 1, -1, -1):
            for j in range(m - 1, -1, -1):
                if i == n - 1 and j == m - 1:
                    dp[i][j] = grid[i][j]
                elif i == n - 1 and j < m - 1:
                    dp[i][j] = dp[i][j + 1] + grid[i][j]
                elif j == m - 1 and i < n - 1:
                    dp[i][j] = dp[i + 1][j] + grid[i][j]
                else:
                    dp[i][j] = min(dp[i][j + 1], dp[i + 1][j]) + grid[i][j]
        return dp[0][0]
