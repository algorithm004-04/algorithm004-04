/*
 * @lc app=leetcode id=52 lang=golang
 *
 * [52] N-Queens II
 *
 * https://leetcode.com/problems/n-queens-ii/description/
 *
 * algorithms
 * Hard (53.61%)
 * Likes:    353
 * Dislikes: 129
 * Total Accepted:    114.2K
 * Total Submissions: 209.3K
 * Testcase Example:  '4'
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 *
 *
 *
 * Given an integer n, return the number of distinct solutions to the n-queens
 * puzzle.
 *
 * Example:
 *
 *
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as
 * shown below.
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 *
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 *
 *
 */

// @lc code=start
func totalNQueens(n int) int {
	if n < 1 {
		return 0
	}
	count := 0
	dfs(n, 0, 0, 0, 0, &count)
	return count
}

func dfs(n, row, cols, pie, na int, count *int) {
	if row >= n {
		*count++
		return
	}
	bits := (^(cols | pie | na)) & ((1 << uint(n)) - 1)
	for bits > 0 {
		p := bits & -bits        // 取到最低位的1
		bits = bits & (bits - 1) // 在 p 位置放上皇后
		dfs(n, row+1, cols|p, (pie|p)<<1, (na|p)>>1, count)
	}
}

// @lc code=end

