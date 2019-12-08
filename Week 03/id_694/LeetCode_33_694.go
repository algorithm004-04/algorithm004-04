/*
 * @lc app=leetcode.cn id=33 lang=golang
 *
 * [33] 搜索旋转排序数组
 *
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (36.07%)
 * Likes:    392
 * Dislikes: 0
 * Total Accepted:    50.4K
 * Total Submissions: 139.7K
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 *
 *
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 */

// @lc code=start
func search(nums []int, target int) int {
	var lo, hi int
	hi = len(nums) - 1
	for lo < hi {
		mid := (lo + hi) / 2
		// 0-mid 不包含旋转位，并且target在右侧区域
		if nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0]) {
			lo = mid + 1
			// 0-mid 包含旋转位，并且targe在右侧区域
		} else if target > nums[mid] && target < nums[0] {
			lo = mid + 1
			// target在左侧区域
		} else {
			hi = mid
		}
	}

	if lo == hi && nums[lo] == target {
		return lo
	}
	return -1
}
// @lc code=end
