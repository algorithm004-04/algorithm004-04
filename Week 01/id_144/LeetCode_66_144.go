/*
 * @lc app=leetcode id=66 lang=golang
 *
 * [66] Plus One
 *
 * https://leetcode.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (41.65%)
 * Likes:    1019
 * Dislikes: 1796
 * Total Accepted:    456.5K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,2,3]'
 *
 * Given a non-empty array of digits representing a non-negative integer, plus
 * one to the integer.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list, and each element in the array contain a single digit.
 * 
 * You may assume the integer does not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * 
 */

 // @lc code=start
 // v1, 拼接成字符串，转成数字，加 1，转成字符串，拆分成数字数组 // !越界了……┑(￣Д ￣)┍
import (
	"strings"
	"strconv"
)
func plusOne(digits []int) []int {
	str := []string{}
	for _, d := range digits {
		str = append(str, strconv.Itoa(d))
	}
	d, err := strconv.Atoi(strings.Join(str, ""))
	if err != nil {
		return []int{}
	}
	d = d + 1
	plusedStr := strconv.Itoa(d)
	str = strings.Split(plusedStr, "")
	res := []int{}
	for _, s := range str {
		d, err := strconv.Atoi(s)
		if err != nil {
			return []int{}
		}
		res = append(res, d)
	}
	return res
}

 // v2, 检查最后一位，如果小于 9，直接加 1 返回；如果等于 9，变为 0 并前一位加 1；往前继续遍历
func plusOne(digits []int) []int {
	for i := len(digits) - 1; i >= 0; i-- {
		if digits[i] < 9 {
			digits[i]++
			return digits
		}
		digits[i] = 0
	}
	res := make([]int, len(digits)+1)
	res[0] = 1
	return res
}

// @lc code=end

