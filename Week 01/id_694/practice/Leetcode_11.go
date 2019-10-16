/*
 * @lc app=leetcode.cn id=11 lang=golang
 *
 * [11] 盛最多水的容器
 */

/*

// 暴力法
func maxArea(height []int) int {
	n := len(height)
	var max int
	min := func(x, y int) int {
		if x <= y {
			return x
		}
		return y
	}
	for i := 0; i < n; i++ {
		for j := i + 1; j < n; j++ {
			h := min(height[i], height[j])
			area := (j - i) * h
			if area > max {
				max = area
			}
		}
	}
	return max
}
*/

// @lc code=start
// 双指针法
func maxArea(height []int) int {
	var (
		head int
		tail = len(height) - 1
		max  int
	)

	min := func(x, y int) int {
		if x <= y {
			return x
		}
		return y
	}

	for head < tail {
		area := min(height[head], height[tail]) * (tail - head)
		if area > max {
			max = area
		}
		if height[head] < height[tail] {
			head++
		} else {
			tail--
		}
	}
	return max
}

// @lc code=end

