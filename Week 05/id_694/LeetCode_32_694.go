
/*
 * @lc app=leetcode.cn id=32 lang=golang
 *
 * [32] 最长有效括号
 *
 * https://leetcode-cn.com/problems/longest-valid-parentheses/description/
 *
 * algorithms
 * Hard (28.44%)
 * Likes:    378
 * Dislikes: 0
 * Total Accepted:    27.1K
 * Total Submissions: 95K
 * Testcase Example:  '"(()"'
 *
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 *
 *
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 *
 * s[i] == ")" && s[i-1] == "(", dp[i] = dp[i-2] + 2
 * s[i] == ")" && s[i-1] == ")", dp[i] = dp[i-1] + dp[i - dp[i-1] - 2]  + 2
 */

// @lc code=start
func longestValidParentheses(s string) int {
	var maxLen int
	lens := len(s)
	var dp = make([]int, lens)
	for i := 1; i < lens; i++ {
		if s[i] == '(' {
			continue
		}
		if s[i-1] == '(' {
			if i >= 2 {
				dp[i] = dp[i-2] + 2
			} else {
				dp[i] = 2
			}
		} else if i-dp[i-1] > 0 && s[i-dp[i-1]-1] == '(' {
			if i-dp[i-1] >= 2 {
				dp[i] = dp[i-1] + dp[i-dp[i-1]-2] + 2
			} else {
				dp[i] = dp[i-1] + 2
			}
		}
		maxLen = max(maxLen, dp[i])
	}

	return maxLen
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

// @lc code=end
