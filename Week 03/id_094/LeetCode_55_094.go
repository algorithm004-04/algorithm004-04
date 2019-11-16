/*
 * @lc app=leetcode id=55 lang=golang
 *
 * [55] Jump Game
 */

// @lc code=start
func canJump(nums []int) bool {
	lastPos := len(nums) - 1
	for i:=len(nums)-2; i>=0; i-- {
		if nums[i]+i >= lastPos {
			lastPos = i
		}
	}
	return lastPos == 0
}
// @lc code=end

