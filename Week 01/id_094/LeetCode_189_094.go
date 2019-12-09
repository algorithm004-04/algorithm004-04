/*
 * @lc app=leetcode id=189 lang=golang
 *
 * [189] Rotate Array
 */

// @lc code=start
//方法1:三次翻转 O(n)
	func rotate(nums []int, k int)  {
		k %= len(nums)
		if k == 0 {
			return
		}
		reverse(nums)
		reverse(nums[:k])
		reverse(nums[k:])
	}
	func reverse(nums []int) {
		for i, j := 0, len(nums)-1; i < j; i, j = i+1, j-1 {
			nums[i], nums[j] = nums[j], nums[i]
		}
	}
// //方法2:使用额外的数组
// 	func rotate(nums []int, k int)  {
// 		n := len(nums)
// 		temp := make([]int, n)
// 		for i := range nums {
// 			temp[(i+k)%n] = nums[i]
// 		}

// 		copy(nums, temp)
// 	}
// //方法3:切片操作
// 	func rotate(nums []int, k int)  {
// 		n := len(nums)
// 		k %= n
// 		x, temp := nums[:n-k], nums[n-k:]
// 		copy(nums, append(temp, x...))
// 	}

// @lc code=end

