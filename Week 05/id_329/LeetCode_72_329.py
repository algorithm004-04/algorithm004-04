#! /usr/bin/env python
# coding=utf-8

"""
给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
你可以对一个单词进行如下三种操作：
    插入一个字符
    删除一个字符
    替换一个字符

示例 1:
输入: word1 = "horse", word2 = "ros"
输出: 3
解释:
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')

示例 2:
输入: word1 = "intention", word2 = "execution"
输出: 5
解释:
intention -> inention (删除 't')
inention -> enention (将 'i' 替换为 'e')
enention -> exention (将 'n' 替换为 'x')
exention -> exection (将 'n' 替换为 'c')
exection -> execution (插入 'u')

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/edit-distance
"""


class Solution(object):
    # O(m*n)
    def minDistance(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        """
        m, n = len(word1), len(word2)
        # 初始化dp表
        table = [[0] * (n + 1) for _ in range(m + 1)]
        for i in range(m+1):
            table[i][0] = i
        for i in range(n+1):
            table[0][i] = i
        for i in range(1, m+1):
            for j in range(1, n+1):
                # DP方程
                if word1[i-1] == word2[j-1]:
                    table[i][j] = table[i-1][j-1]
                else:
                    table[i][j] = 1 + min(table[i-1][j], table[i][j-1], table[i-1][j-1])
        return table[-1][-1]


if __name__ == '__main__':
    sol = Solution()
    assert sol.minDistance("horse", "ros") == 3
    assert sol.minDistance("intention", "execution") == 5
