/*
 * @lc app=leetcode id=42 lang=golang
 *
 * [42] Trapping Rain Water
 *
 * https://leetcode.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (44.61%)
 * Likes:    4625
 * Dislikes: 82
 * Total Accepted:    362.4K
 * Total Submissions: 802.1K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped. Thanks
 * Marcos for contributing this image!
 * 
 * Example:
 * 
 * 
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * 
 */

// @lc code=start
// v1, 左右两指针
// ![two-pointer]
func trap(height []int) int {
	l, r := 0, len(height) - 1
	level, water, lower := 0, 0, 0
	for l < r {
		if height[l] < height[r] {
			lower = height[l]
			l++
		} else {
			lower = height[r]
			r--
		}
		if lower > level {
			level = lower
		}
		water += level - lower
	}
	return water
}

// v2, 栈
func trap(height []int) int {
	current, sum := 0, 0
	stack := make([]int, 0)
	for current < len(height) {
		for len(stack) > 0 && height[current] > height[stack[len(stack)-1]] {
			// pop of stack
			prevHeight := height[stack[len(stack)-1]]
			stack = stack[0:len(stack)-1]
			// if stack is empty
			if len(stack) == 0 {
				break
			}
			distance := current - stack[len(stack)-1] - 1
			min := min(height[stack[len(stack)-1]], height[current])
			sum += distance * (min - prevHeight)
		}
		stack = append(stack, current)
		current++
	}
	return sum
}
func min(x, y int) int {
	if x < y {
		return x
	}
	return y
}
// @lc code=end

