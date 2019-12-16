#!/usr/bin/env python
#-*-coding:utf-8-*-
# author:lwz


str = "41"

class Solution:
    def myAtoi(self, str: str):
        if len(str) == 0: return 0
        ls = list(str.strip())
        sign = -1 if ls[0] == '-' else 1

        if ls[0] in ['-', '+']: del ls[0]
        ret, i = 0, 0
        while i < len(ls) and ls[i].isdigit():
            ret = ret * 10 + ord(ls[i]) - ord('0')
            i += 1
        return max(-2 ** 31, min(sign * ret, 2 ** 31 - 1))


