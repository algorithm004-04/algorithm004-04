# 20191129

class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        if n <= 0:
            return False
        counter = 0
        tmp = n
        while True:
            if n == 1:
                break
            n >>= 1
            counter += 1

        return 2**counter == tmp

class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        return n & (n-1) == 0


s = Solution()
for i in range(100):
    print(s.isPowerOfTwo(i))