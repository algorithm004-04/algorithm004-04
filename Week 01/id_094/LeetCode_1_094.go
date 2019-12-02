/*
 * @lc app=leetcode id=1 lang=golang
 *
 * [1] Two Sum
 */

// @lc code=start
func twoSum(nums []int, target int) []int {
	indices := make(map[int]int) //key:num, val:idx

	for i, n := range nums{
		if j, ok := indices[target - n]; ok{
			return []int{j, i}
		}
		indices[n] = i
	}
	return []int{}
}
// @lc code=end

