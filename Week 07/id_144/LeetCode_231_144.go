/*
 * @lc app=leetcode id=231 lang=golang
 *
 * [231] Power of Two
 *
 * https://leetcode.com/problems/power-of-two/description/
 *
 * algorithms
 * Easy (42.33%)
 * Likes:    549
 * Dislikes: 147
 * Total Accepted:    258.3K
 * Total Submissions: 606.9K
 * Testcase Example:  '1'
 *
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Example 1:
 *
 *
 * Input: 1
 * Output: true
 * Explanation: 2^0 = 1
 *
 *
 * Example 2:
 *
 *
 * Input: 16
 * Output: true
 * Explanation: 2^4 = 16
 *
 * Example 3:
 *
 *
 * Input: 218
 * Output: false
 *
 */

// @lc code=start
func isPowerOfTwo(n int) bool {
	return (n != 0) && (n&(n-1) == 0)
}

// @lc code=end

