# 20191129

class Solution:
    def reverseBits(self, n: int) -> str:
        ans = 0
        for i in range(32):
            ans = (ans << 1) + (n & 1)
            n >>= 1
        return ans


s = Solution()
print((s.reverseBits(2)))