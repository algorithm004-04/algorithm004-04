/*
 * @lc app=leetcode.cn id=20 lang=golang
 *
 * [20] 有效的括号
*/

// @lc code=start
func isValid(s string) bool {
	stack := make([]string, len(s))
	pair := map[string]string{
		"}": "{",
		"]": "[",
		")": "(",
	}
	head := 0
	data := strings.Split(s, "")
	for _, c := range data {
		if v, ok := pair[c]; ok {
			if head == 0 || stack[head-1] != v {
				return false
			}
			stack[head-1] = ""
			head--
		} else {
			stack[head] = c
			head++
		}
	}
	return head == 0
}

// @lc code=end

