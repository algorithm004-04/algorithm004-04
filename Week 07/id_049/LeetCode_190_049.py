class Solution:
    def reverseBits(self, n):
        count = 32
        res = 0
        while count:
            res <<= 1
            res += n & 1
            n >>= 1
            count -= 1
        return int(bin(res),2)