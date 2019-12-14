/*
 * @lc app=leetcode.cn id=91 lang=cpp
 *
 * [91] 解码方法
 *
 * https://leetcode-cn.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (22.12%)
 * Likes:    226
 * Dislikes: 0
 * Total Accepted:    22.5K
 * Total Submissions: 101.9K
 * Testcase Example:  '"12"'
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 
 * 示例 1:
 * 
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    int numDecodings(string s) {
        int n = s.size();
        vector<int> dp(n+1);
        dp[n] = 1;
        for(int i = n-1; i >= 0; i--) {
            if(s[i] == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i+1];
                if(i < n-1 && (s[i] == '1' || s[i] == '2' && s[i+1] < '7')) 
                    dp[i] += dp[i+2];
            }
        }
        return s.empty() ? 0 : dp[0];
    }
};
// @lc code=end

