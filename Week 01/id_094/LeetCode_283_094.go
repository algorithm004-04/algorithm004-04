/*
 * @lc app=leetcode id=283 lang=golang
 *
 * [283] Move Zeroes
 */

// @lc code=start
//双指针，慢指针j之前的所有元素都是非零的
func moveZeroes(nums []int)  {
	j := 0
	for i:= 0; i<len(nums); i++ {
		if nums[i] != 0 {
			nums[j], nums[i] = nums[i], nums[j]
			j++
		}
	}
}

// @lc code=end

