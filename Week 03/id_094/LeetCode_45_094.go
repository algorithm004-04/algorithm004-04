/*
 * @lc app=leetcode id=45 lang=golang
 *
 * [45] Jump Game II
 */

// @lc code=start
func jump(nums []int) int {
	curPos, nextPos := 0, 0
	steps := 0
	for i, n := range nums {
		if i > curPos {
			steps++
			curPos = nextPos
		}
		if nextPos < i+n {
			nextPos = i + n
		}
	}
	return steps
}
// @lc code=end

