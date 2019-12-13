# 20191209


class Solution:
    def myAtoi(self, str: str) -> int:
        if len(s) == 0:
            return 0

        ls = list(s.strip())

        if ls[0] == '-':
            sign = -1
        else:
            sign = 1

        if ls[o] in ['-', '+']:
            del ls[0]

        ret, i = 0, 0

        while i < len(ls) and ls[i].isdigit():
            ret = ret * 10 + ord(ls[i]) - ord('0')
            i += 1

        return max(-2**31, min(sign * ret, 2**31 - 1))

