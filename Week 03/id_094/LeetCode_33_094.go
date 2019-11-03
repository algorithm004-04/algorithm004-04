/*
 * @lc app=leetcode id=33 lang=golang
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
func search(nums []int, target int) int {
	if len(nums) == 0 {
		return -1
	}

	lo, hi := 0, len(nums)-1
	for lo < hi {
		mid := lo + (hi-lo)/2

		//先考虑target在[0,mid]的情况
		//1.nums[0] <= target <= nums[i]
		//2.           target <= nums[i] < nums[0]
		//3.                     nums[i] < nums[0] <= target
		if  (nums[0] <= target && target <= nums[mid]) ||
			((nums[mid] < nums[0]) && (target <= nums[mid] || nums[0] <= target)) {
			hi = mid
		} else {
			lo = mid+1
		}
	}
	if nums[lo] == target {
		return lo
	}
	return -1
}
// @lc code=end

