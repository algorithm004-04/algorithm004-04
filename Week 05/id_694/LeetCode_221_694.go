/*
 * @lc app=leetcode.cn id=221 lang=golang
 *
 * [221] 最大正方形
 *
 * https://leetcode-cn.com/problems/maximal-square/description/
 *
 * algorithms
 * Medium (38.31%)
 * Likes:    164
 * Dislikes: 0
 * Total Accepted:    14.5K
 * Total Submissions: 37.8K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * 
 * 示例:
 * 
 * 输入: 
 * 
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 
 * 输出: 4
 * 
 */

// @lc code=start
func maximalSquare(matrix [][]byte) int {
	m := len(matrix)
	if m == 0 {
		return 0
	}
	n := len(matrix[0])
	dp := make([]int, n)
	var corner int
	var maxLen int
	for _, row := range matrix {
		for j, v := range row {
			tmp := dp[j]
			if v == '1' {
				prev := 0
				if j > 0 {
					prev = dp[j-1]
				}
				dp[j] = min(min(prev, dp[j]), corner) + 1
			} else {
				dp[j] = 0
			}
			corner = tmp
			maxLen = max(maxLen, dp[j])
		}
	}

	return maxLen * maxLen
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

// @lc code=end

