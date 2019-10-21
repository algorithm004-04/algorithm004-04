/*
 * @lc app=leetcode.cn id=42 lang=golang
 *
 * [42] 接雨水
 */

/*
// 暴力
 func trap(height []int) int {
	 var ans int = 0
	 size := len(height)
	 for i := 1; i < size-1; i++ {
		 var maxLeft, maxRight int
		 for j := i; j >= 0; j-- {
			 maxLeft = max(maxLeft, height[j])
		 }
		 for j := i; j < size; j++ {
			 maxRight = max(maxRight, height[j])
		 }
		 ans += min(maxLeft, maxRight) - height[i]
	 }
	 return ans
 }
*/

// @lc code=start
// 双指针
func trap(height []int) int {
	var (
		ans, left, leftMax, rightMax int
		right                        = len(height) - 1
	)

	for left < right {
		if height[left] < height[right] {
			if height[left] > leftMax {
				leftMax = height[left]
			} else {
				ans += leftMax - height[left]
			}
			left++
		} else {
			if height[right] >= rightMax {
				rightMax = height[right]
			} else {
				ans += rightMax - height[right]
			}
			right--
		}
	}
	return ans
}

// @lc code=end

