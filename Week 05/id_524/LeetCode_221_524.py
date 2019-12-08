#!/usr/bin/env python
#-*-coding:utf-8-*-
# author:lwz


class Solution:
    def maximalSquare(self, matrix):
        area = 0
        if matrix:
            p = [0] * len(matrix[0])
            for row in matrix:
                s = map(int, row)
                for j, c in enumerate(s[1:], 1):
                    s[j] *= min(p[j-1], p[j], s[j-1]) + 1
                area = max(area, max(s) ** 2)
                p = s
        return area

    def maximalSquare2(self, matrix):
        if not matrix: return 0
        m, n = len(matrix), len(matrix[0])
        dp = [[0 if matrix[i][j] == '0' else 1 for j in range(0, n)] for i in range(0, m)]

        for i in range(1, m):
            for j in range(1, n):
                if matrix[i][j] == '1':
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
                else:
                    dp[i][j] = 0

        res = max(max(row) for row in dp)
        return res ** 2





