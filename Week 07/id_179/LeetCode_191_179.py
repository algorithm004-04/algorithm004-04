class Solution:
    def hammingWeight(self, n: int) -> int:
        k = 0
        while n != 0:
            n = n & n-1
            k += 1
        return k
