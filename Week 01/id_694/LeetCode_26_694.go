/*
 * @lc app=leetcode.cn id=26 lang=golang
 *
 * [26] 删除排序数组中的重复项
 * 1. idx 始终指向最后一个有效值的位置
 * 2. 从第二个元素开始遍历数据，如果和最后一个有效值不同，就追加到idx后面的位置，idx加1
 */

// @lc code=start
func removeDuplicates(nums []int) int {
	lens := len(nums)
	if lens <= 1 {
		return lens
	}
	idx := 0
	for i := 1; i < lens; i++ {
		if nums[i] != nums[idx] {
			idx++
			nums[idx] = nums[i]
		}
	}
	return idx+1
}
// @lc code=end

