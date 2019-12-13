class Solution(object):
    def hammingWeight(self, n):
        res = 0
        while n:
            res += n & 1
            n >>= 1
        return res