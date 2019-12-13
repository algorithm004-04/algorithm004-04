/*
 * @lc app=leetcode.cn id=115 lang=cpp
 *
 * [115] 不同的子序列
 *
 * https://leetcode-cn.com/problems/distinct-subsequences/description/
 *
 * algorithms
 * Hard (44.89%)
 * Likes:    108
 * Dislikes: 0
 * Total Accepted:    6.9K
 * Total Submissions: 15K
 * Testcase Example:  '"rabbbit"\n"rabbit"'
 *
 * 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
 * 
 * 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE"
 * 的一个子序列，而 "AEC" 不是）
 * 
 * 示例 1:
 * 
 * 输入: S = "rabbbit", T = "rabbit"
 * 输出: 3
 * 解释:
 * 
 * 如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * 
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * 
 * 
 * 示例 2:
 * 
 * 输入: S = "babgbag", T = "bag"
 * 输出: 5
 * 解释:
 * 
 * 如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。 
 * (上箭头符号 ^ 表示选取的字母)
 * 
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 * ⁠ ^  ^^
 * babgbag
 * ⁠   ^^^
 * 
 */

// @lc code=start
class Solution {
public:
  int numDistinct_0(string s, string t) {
    int lengtht = t.length(), lengths = s.length();
    vector<vector<long>> dp(lengtht + 1, vector<long>(lengths + 1, 0));
    for (int i = 0; i <= lengths; ++i) {
      dp[0][i] = 1;
    }

    for (int i = 1; i <= lengtht; ++i) {
      for(int j = 1; j <= lengths; ++j) {
        dp[i][j] = dp[i][j-1];
        if (s[j - 1] == t[i - 1]) {
          dp[i][j] += dp[i-1][j-1];
        }
      }
    }

    return dp[lengtht][lengths];
  }

  int numDistinct(string s, string t) {
    int lengths = s.length(), lengtht = t.length();
    vector<long> cur(lengtht + 1, 0);
    cur[0] = 1;
    for (int j = 1; j <= lengths; ++j) {
      int pre = 1;
      for (int i = 1; i <= lengtht; ++i) {
        int temp = cur[i];
        if (t[i - 1] == s[j -1]) {
          cur[i] += pre;
        }
        pre = temp;
      }
    }

    return cur[lengtht];
  }
};
// @lc code=end

