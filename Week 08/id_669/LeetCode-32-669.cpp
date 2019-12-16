/*
 * @lc app=leetcode.cn id=32 lang=cpp
 *
 * [32] 最长有效括号
 *
 * https://leetcode-cn.com/problems/longest-valid-parentheses/description/
 *
 * algorithms
 * Hard (28.70%)
 * Likes:    426
 * Dislikes: 0
 * Total Accepted:    30.6K
 * Total Submissions: 106.2K
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
 */

// @lc code=start
class Solution {
public:
    int longestValidParentheses_0(string s) {
      vector<int> dp(s.length(), 0);
      int maxps = 0;
      for (int i = 1; i < s.length(); ++i) {
        if (s[i] == ')') {
          if (s[i-1] == '(') {
            dp[i] = (i >= 2 ? dp[i-2] : 0) + 2;
          } else {
            if (i - dp[i-1] > 0 && s[i-dp[i-1]-1] == '(') {
              dp[i] = (i-dp[i-1] >= 2 ? dp[i-dp[i-1] - 2] : 0) + dp[i-1] + 2;
            }
          }
          maxps = max(maxps, dp[i]);  
        }
      }

      return maxps;
    }

    int longestValidParentheses(string s) {
        stack<int> stk;
        stk.push(-1);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s[i] == '(') {
                stk.push(i);
            } else {
                stk.pop();
                if (stk.empty()) {
                    stk.push(i);
                } else {
                    ans = max(ans, i - stk.top());
                }
            }
        }
        return ans;
    }
};
// @lc code=end

