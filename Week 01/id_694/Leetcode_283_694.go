/*
 * @lc app=leetcode.cn id=283 lang=golang
 *
 * [283] 移动零
 * 双指针法：
 * 1. noneZeroIdx始终指向最后一个非零值应该在的位置
 * 2. 当前值不为0时交换当前值到noneZeroIdx位置，同时noneZeroIdx加1
 */

// @lc code=start
func moveZeroes(nums []int)  {
	noneZeroIdx := 0
	for curIdx := 0; curIdx < len(nums); curIdx++ {
		if nums[curIdx] != 0 {
			nums[noneZeroIdx], nums[curIdx] = nums[curIdx], nums[noneZeroIdx]
			noneZeroIdx++
		}
	}
}
// @lc code=end

