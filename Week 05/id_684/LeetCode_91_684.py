# -*- coding: utf8 -*-

# -*- coding: utf8 -*-


"""
一条包含字母 A-Z 的消息通过以下方式进行了编码：

'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。

示例 1:

输入: "12"
输出: 2
解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
示例 2:

输入: "226"
输出: 3
解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。


"""


class Solution(object):
    def numDecodings(self, s):
        """
        思路类似爬楼梯的题目
        动态转移方程
        if s[i-2:i] <=26 and s[i-2:i] >=10:
            dp[i] = dp[i] + dp[i-2]
        if s[i-1:i] >=1:
            dp[i] = dp[i] + dp[i-1]
        :type s: str
        :rtype: int
        """
        # 初始化状态转移表
        n = len(s)
        dp = [0 for i in range(n + 1)]
        # 初始化特殊条件
        dp[0] = 1
        if s[0] == '0':
            dp[1] = 0
        else:
            dp[1] = 1
        # 从第三个字符开始
        for i in range(2, n + 1):
            one_word = int(s[i - 1:i])
            two_word = int(s[i - 2:i])
            if one_word >= 1:
                dp[i] = dp[i] + dp[i - 1]
            if two_word <= 26 and two_word >= 10:
                dp[i] = dp[i] + dp[i - 2]
        return dp[-1]


if __name__ == '__main__':
    slt = Solution()
    s = "226"
    print(slt.numDecodings(s))
