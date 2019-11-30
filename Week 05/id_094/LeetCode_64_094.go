func minPathSum(grid [][]int) int {
	m := len(grid)
	n := len(grid[0])
	dp := make([]int, n)
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if i == 0 && j == 0 {
				dp[j] = grid[i][j]
				continue
			}

			if j == 0 {
				dp[j] = dp[j] + grid[i][j]
				continue
			}

			if i == 0 {
				dp[j] = dp[j-1] + grid[i][j]
				continue
			}

			up := dp[j]
			left := dp[j-1]

			dp[j] = min(up, left) + grid[i][j]
		}
	}

	return dp[n-1]
}

func min(a, b int) int {
	if a < b {
		return a
	} else {
		return b
	}
}