/*
 * @lc app=leetcode id=26 lang=golang
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start

//方法1  双指针
// func removeDuplicates(nums []int) int {
// 	if len(nums) == 0 {
// 		return 0
// 	}

// 	cur := 0 //当前不重复元素的下标
// 	for idx := 1; idx < len(nums); idx++ {
// 		if nums[idx] != nums[cur] {
// 			cur++
// 			nums[cur] = nums[idx]
// 		}
// 	}
// 	return cur + 1

// }
//方法2, 统计重复数
// func removeDuplicates(nums []int) int {
// 	count, n := 0, len(nums)

// 	for idx := 1; idx < n; idx++ {
// 		if nums[idx] == nums[idx-1] {
// 			count++
// 		} else {
// 			nums[idx - count] = nums[idx]
// 		}
// 	}
// 	return n-count
// }

//方法3 for-range风格 *
func removeDuplicates(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	i := 1 //i之前的元素不重复
    for _, n := range nums {
		if n != nums[i-1] {
			nums[i] = n
			i++
		}
	}

    return i
}
// @lc code=end

