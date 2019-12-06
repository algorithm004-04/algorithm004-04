/*
 * @lc app=leetcode id=189 lang=golang
 *
 * [189] Rotate Array
 *
 * https://leetcode.com/problems/rotate-array/description/
 *
 * algorithms
 * Easy (31.38%)
 * Likes:    1613
 * Dislikes: 654
 * Total Accepted:    342.7K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,2,3,4,5,6,7]\n3'
 *
 * Given an array, rotate the array to the right by k steps, where k is
 * non-negative.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation: 
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * 
 * 
 * Note:
 * 
 * 
 * Try to come up as many solutions as you can, there are at least 3 different
 * ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 * 
 */

/* v1, first blink, try to divide array and revert the two parts
* cons:
	- handling corner cases is a little bit complex...
	- difficult to explain...
	- error-prone...
* not recommended
*/ 
func rotate(nums []int, k int)  {
	if len(nums) <= 1 || k <= 0 {
		return
	}
	final := make([]int, len(nums))
	priv := len(nums) - k
	if priv < 0 {
		priv = len(nums) + priv
	}
	priv = priv % len(nums)
	left, right := nums[:priv], nums[priv:]
	final = append(right, left...)
	copy(nums, final)
}

// v2, move one by one
func rotate(nums []int, k int)  {
	if len(nums) <= 1 || k == 0 {
        return
	}
	length := len(nums)
	final := make([]int, length)
	for i := 0; i < length; i++ {
		final[(k+i)%length] = nums[i]
	}
	copy(nums, final)
}

