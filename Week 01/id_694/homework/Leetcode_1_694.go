/*
 * @lc app=leetcode.cn id=1 lang=golang
 *
 * [1] 两数之和
 */

/*
  	// 暴力法
	func twoSum(nums []int, target int) []int {
		lens := len(nums)
		for i := 0; i < lens; i++ {
			for j := i+1; j < lens; j++ {
				if nums[i] + nums[j] == target {
					return []int{i, j}
				}
			}
		}
		return []int{}
	}

	// 哈希表
	func twoSum(nums []int, target int) []int {
		idx := make(map[int]int, len(nums))
		for k, v := range nums {
			idx[v] = k
		}
		for k, v := range nums {
			sub := target - v
			if k1, ok := idx[sub]; ok && k1 != k {
				return []int{k, k1}
			}
		}
		return []int{}
	}
*/

// @lc code=start
func twoSum(nums []int, target int) []int {
	idx := make(map[int]int, len(nums))
	for k, v := range nums {
		sub := target - v
		if k1, ok := idx[sub]; ok {
			return []int{k1, k}
		}
		idx[v] = k
	}
	return []int{}
}
// @lc code=end

