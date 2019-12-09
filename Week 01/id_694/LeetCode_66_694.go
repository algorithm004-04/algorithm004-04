/*
 * @lc app=leetcode.cn id=66 lang=golang
 *
 * [66] 加一
 *
 * 思路：
 * 1. 设进位flag为1，加一看做是从第0位开始进位1
 * 2. 从右往左遍历，如果加上进位后不大于10，则后续几位就没有必要继续计算了
 * 3. 最后如果还有进位，说明原数组位数不够了
 */

 /*
	评论中的解答写法原理基本差不多，写法很巧妙
	func plusOne(digits []int) []int {
		lens := len(digits)
		for i := lens - 1; i >= 0; i-- {
			digits[i]++
			digits[i] %= 10
			if digits[i] != 0 {
				return digits
			}
		}
		new := make([]int, lens+1)
		new[0] = 1
		return new
	}
 */

// @lc code=start
func plusOne(digits []int) []int {
	var flag int = 1
	for i := len(digits) - 1; i >= 0; i-- {
		digits[i] += flag
		if digits[i] < 10 {
			flag = 0
			break
		} else {
			digits[i] = 0
		}
	}
	if flag == 1 {
		new := []int{1}
		new = append(new, digits...)
		return new
	}

	return digits
}
// @lc code=end
