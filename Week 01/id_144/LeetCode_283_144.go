/*
 * @lc app=leetcode id=283 lang=golang
 *
 * [283] Move Zeroes
 *
 * https://leetcode.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (55.10%)
 * Likes:    2436
 * Dislikes: 88
 * Total Accepted:    541.5K
 * Total Submissions: 978.3K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * Example:
 * 
 * 
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * 
 * Note:
 * 
 * 
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * 
 */

// @lc code=start

// v1, 开新数组，loop，时间复杂度 O(n)，空间复杂度 O(n)，使用了额外的空间
func moveZeroes(nums []int) {
	res := []int{}
	countOfZero := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] != 0 {
			res = append(res, nums[i])
		} else {
			countOfZero++
		}
	}
	for j := 0; j < countOfZero; j++ {
		res = append(res, 0)
	}
	for k := 0; k < len(nums); k++ {
		nums[k] = res[k]	// !! 这里注意要把各元素遍历赋值回给nums
	}
}

// v2, 遍历整个数组，时间复杂度 O(n)， 空间复杂度 O(1)，原地移动
func moveZeroes(nums []int)  {
	j := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] != 0 {
			nums[j] = nums[i]
			if i != j {
				nums[i] = 0
			}
			j++
		}
	}
}

// v3, 直接交换移动，时间复杂度 O(n)， 空间复杂度 O(1)，原地移动
func moveZeroes(nums []int)  {
	for lastNonZeroFoundAt, cur := 0, 0; cur < len(nums); cur++ {
		if nums[cur] != 0 {
			nums[lastNonZeroFoundAt], nums[cur] = nums[cur], nums[lastNonZeroFoundAt]
			lastNonZeroFoundAt++
		}
	}
}
// @lc code=end

