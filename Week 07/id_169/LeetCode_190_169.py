class Solution:
    # @param n, an integer
    # @return an integer
    def reverseBits(self, n):
        result = 0
        for i in range(32):
            result += (n & 1) << (31 - i)
            n >>= 1
        return result
