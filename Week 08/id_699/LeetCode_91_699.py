#
# @lc app=leetcode.cn id=91 lang=python3
#
# [91] 解码方法
#
# https://leetcode-cn.com/problems/decode-ways/description/
#
# algorithms
# Medium (21.94%)
# Likes:    235
# Dislikes: 0
# Total Accepted:    24.8K
# Total Submissions: 110.6K
# Testcase Example:  '"12"'
#
# 一条包含字母 A-Z 的消息通过以下方式进行了编码：
# 
# 'A' -> 1
# 'B' -> 2
# ...
# 'Z' -> 26
# 
# 
# 给定一个只包含数字的非空字符串，请计算解码方法的总数。
# 
# 示例 1:
# 
# 输入: "12"
# 输出: 2
# 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
# 
# 
# 示例 2:
# 
# 输入: "226"
# 输出: 3
# 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
# 
# 
#

# @lc code=start
class Solution:
    def numDecodings(self, s: str) -> int:
        if len(s) < 1:
            return 0
        if len(s) == 1:
            return int(26 >= int(s) > 0)
        if 0 < int(s[0]) <=26:
            one_bit = 1
        else:
            one_bit = 0
        two_bit = 1
        tmp = 0
        for i in range(1, len(s)):
            tmp = 0
            if not s[i-1:i+1].startswith('0') and  0 < int(s[i-1:i+1]) <= 26:
                tmp += two_bit
            if 0 < int(s[i]) <= 26:
                tmp += one_bit
            one_bit, two_bit = tmp, one_bit
        return tmp
# @lc code=end

