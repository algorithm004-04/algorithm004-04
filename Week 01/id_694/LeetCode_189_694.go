/*
 * @lc app=leetcode.cn id=189 lang=golang
 *
 * [189] 旋转数组
 */

/*
	// 暴力法
	func rotate(nums []int, k int) {
		lens := len(nums)
		k %= lens
		var tmp int
		for i := 0; i < k; i++ {
			tmp = nums[lens-1]
			for j := lens - 1; j > 0; j-- {
				nums[j] = nums[j-1]
			}
			nums[0] = tmp
		}	
	}
*/

// @lc code=start
// 反转法
func rotate(nums []int, k int) {
	reverse := func(nums []int, start, end int) {
		for start < end {
			nums[start], nums[end] = nums[end], nums[start]
			start++
			end--
		}
	}

	lens := len(nums)
	k %= lens
	reverse(nums, 0, lens-1)
	reverse(nums, 0, k-1)
	reverse(nums, k, lens-1)
}
// @lc code=end

