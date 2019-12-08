/*
 * @lc app=leetcode id=77 lang=golang
 *
 * [77] Combinations
 */

// @lc code=start
func combine(n int, k int) [][]int {
	ret := [][]int{}
	ans := []int{}
	_helper(1, n, k, ans, &ret)
	return ret
}

func _helper(first int, n, k int, ans []int, ret *[][]int) {
	if len(ans) == k {
		*ret = append(*ret, append([]int{}, ans...))
		return
	}

	for i:=first; i<=n; i++ {
		ans = append(ans, i)
		_helper(i+1, n, k, ans, ret)
		ans = ans[:len(ans)-1]
	}

}
// @lc code=end

