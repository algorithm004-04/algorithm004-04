# -*- coding: utf8 -*-

# -*- coding: utf8 -*-


"""
给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。

你可以对一个单词进行如下三种操作：

插入一个字符
删除一个字符
替换一个字符
示例 1:

输入: word1 = "horse", word2 = "ros"
输出: 3
解释:
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')
示例 2:

输入: word1 = "intention", word2 = "execution"
输出: 5
解释:
intention -> inention (删除 't')
inention -> enention (将 'i' 替换为 'e')
enention -> exention (将 'n' 替换为 'x')
exention -> exection (将 'n' 替换为 'c')
exection -> execution (插入 'u')
"""


def print_matrix(matrix):
    """
    打印二维矩阵
    :param matrix:
    :return:
    """
    for mtx in matrix:
        print(mtx)


class Solution(object):
    def minDistance(self, word1, word2):
        """
        动态转移方程
        if word1[i] == word2[j]:
            dp[i][j] = min(dp[i-1][j] + 1,dp[i][j-1] +1 ,dp[i-1][j-1])
        else:
            dp[i][j] = min(dp[i-1][j] + 1,dp[i][j-1] +1 ,dp[i-1][j-1] +1)
        :type word1: str
        :type word2: str
        :rtype: int
        """
        n = len(word1)
        m = len(word2)
        if n == 0: return m
        if m == 0: return n
        # 初始化状态转移表
        dp = []
        for i in range(n):
            dp.append([])
            for j in range(m):
                dp[i].append(0)
        # 初始化状态转移表第一行
        for j in range(m):
            if word1[0] == word2[j]:
                dp[0][j] = j
            elif j != 0:
                dp[0][j] = dp[0][j - 1] + 1
            else:
                dp[0][j] = 1
        # 初始化状态转移表第一列
        for i in range(n):
            if word2[0] == word1[i]:
                dp[i][0] = i
            elif i != 0:
                dp[i][0] = dp[i - 1][0] + 1
            else:
                dp[i][0] = 1
        # 从第二行第二列，根据动态转移方程填状态转移表
        for i in range(1, n):
            for j in range(1, m):
                if word1[i] == word2[j]:
                    dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1])
                else:
                    dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1)
        return dp[n - 1][m - 1]


if __name__ == '__main__':
    slt = Solution()
    word1 = "horse"
    word2 = "ros"
    print(slt.minDistance(word1, word2))
