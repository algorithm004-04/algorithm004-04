/*
 * @lc app=leetcode.cn id=15 lang=golang
 *
 * [15] 三数之和
 * 双指针法
 */

// @lc code=start
func threeSum(nums []int) [][]int {
	n := len(nums)
	res := [][]int{}
	sort.Ints(nums)
	for c := 0; c < n-2; c++ {
		if nums[c] > 0 {
			break
		}
		if c > 0 && nums[c] == nums[c-1] {
			continue
		}

		a, b := c+1, n-1
		for a < b {
			s := nums[a] + nums[b] + nums[c]
			if s < 0 {
				a++
				for ; a < b && nums[a] == nums[a-1]; a++ {
				}
			} else if s > 0 {
				b--
				for ; a < b && nums[b] == nums[b+1]; b-- {
				}
			} else {
				res = append(res, []int{nums[a], nums[b], nums[c]})
				a++
				b--
				for ; a < b && nums[a] == nums[a-1]; a++ {
				}
				for ; a < b && nums[b] == nums[b+1]; b-- {
				}
			}
		}
	}

	return res
}

// @lc code=end

