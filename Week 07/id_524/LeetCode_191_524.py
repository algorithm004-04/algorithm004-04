#!/usr/bin/env python
#-*-coding:utf-8-*-
# author:lwz

class Solution(object):

    def hammingWeight(self, n):
        "遍历字符串，逐一计数"
        count = 0
        for i in n:
            if i == "1": count += 1

    def hammingWeight2(self, n):
        "利用标准库方法更简便的写法"
        return bin(n).count('1')

    def hammingWeight3(self, n):
        "位运算操作，时间复杂度最优"
        count = 0
        while n != 0:
            count += 1
            n &= (n - 1)
        return count

