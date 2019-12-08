# 20191129

class Solution:
    def hammingWeight(self, n: int) -> int:
        return bin(n).count("1")

class Solution:
    def hammingWeight(self, n: int) -> int:
        counter = 0
        while n:
            counter += n & 1
            n >>= 1
        return counter

class Solution:
    def hammingWeight(self, n: int) -> int:
        counter = 0
        for index, num in enumerate(str(bin(n))):
            if num == '1':
                counter += 1
        return counter

class Solution:
    def hammingWeight(self, n: int) -> int:
        sum = 0
        while n != 0 :
            sum += 1
            n &= (n - 1)
        return sum

s = Solution()
print(s.hammingWeight(1011))
