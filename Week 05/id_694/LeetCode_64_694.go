/*
 * @lc app=leetcode.cn id=64 lang=golang
 *
 * [64] 最小路径和
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (62.53%)
 * Likes:    315
 * Dislikes: 0
 * Total Accepted:    41.3K
 * Total Submissions: 65.7K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 
 * 说明：每次只能向下或者向右移动一步。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * 
 * 
 */

// @lc code=start
func minPathSum(grid [][]int) int {
	m := len(grid)
	if m == 0 {
		return 0
	}
	n := len(grid[0])

	var minRow = make([]int, n)
	for i, row := range grid {
		for j, v := range row {
			if i == 0 {
				if j == 0 {
					minRow[j] = v
				} else {
					minRow[j] = minRow[j-1] + v
				}
			} else {
				if j == 0 {
					minRow[j] = minRow[j] + v
				} else {
					minRow[j] = min(minRow[j-1], minRow[j]) + v
				}
			}
		}
	}
	return minRow[n-1]
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
// @lc code=end

