/*
 * @lc app=leetcode id=22 lang=golang
 *
 * [22] Generate Parentheses
 */

// @lc code=start
//终止条件: len(s) == 2n
//递推关系: g(i) = "("/")" + g(i+1)
//全排列 + 过滤
// func generateParenthesis(n int) []string {
// 	ret := []string{}
// 	_generate(n, "",  &ret)
// 	return ret
// }
// func _generate(n int, s string, ret *[]string) {
// 	if len(s) == 2*n {
// 		if banlanced(s) {
// 			*ret = append(*ret, s)
// 		}
// 		return
// 	}
// 	_generate(n, s+"(", ret)
// 	_generate(n, s+")", ret)
// 	return
// }

// func banlanced(s string) bool {
// 	i := 0
// 	for _, b := range []byte(s) {
// 		if b == '(' {
// 			i++
// 		} else {
// 			i--
// 		}
// 		if i < 0 {
// 			return false
// 		}
// 	}
// 	return i == 0
// }

//终止条件: len == 2n
//递推关系: g(i) = "("/")" + g(i+1)
//合法条件：left < n, right < left (left左括号数，right右括号数)
func generateParenthesis(n int) []string {
	ret := []string{}

	_generate2("", 0, 0, n, &ret)
	return ret
}
func _generate2(s string, left, right, n int, ret *[]string) {
	if len(s) == 2*n {
		*ret = append(*ret, s)
		return
	}

	if left < n {
		_generate2(s+"(", left+1, right, n, ret)
	}

	if right < left {
		_generate2(s+")", left, right+1, n, ret)
	}
}
// @lc code=end

