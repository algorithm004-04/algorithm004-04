/*
 * @lc app=leetcode id=493 lang=golang
 *
 * [493] Reverse Pairs
 */

// @lc code=start
func reversePairs(nums []int) int {
	ret := mergeSort(nums, 0, len(nums)-1)
	return ret
}

func mergeSort(nums []int, left, right int) int {
	if right <= left {
		return 0
	}
	mid := left + (right-left)/2
	count := mergeSort(nums, left, mid) + mergeSort(nums, mid+1, right)

	//merge sort
	temp := make([]int, right-left+1)
	k := 0
	l := left
	
	for i, j := left, mid+1; j <= right; {
		for i <= mid && nums[i] <= 2*nums[j] {
			i++
		}
		for l <= mid && nums[l] < nums[j] {
			temp[k] = nums[l];k, l = k+1, l+1
		}
		temp[k] = nums[j];k, j = k+1, j+1 
		
		count += mid - i + 1
	}
	for l <= mid {
		temp[k] = nums[l];k, l = k+1, l+1
	}
	copy(nums[left:right+1], temp)
	return count
}
// @lc code=end

