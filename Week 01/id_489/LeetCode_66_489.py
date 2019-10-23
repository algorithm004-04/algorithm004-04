class Solution:
    def plusOne(self, digits):
        acc = 0
        for i, k in enumerate(digits[::-1]):
            acc += k*(10**i)
        new = []
        for j in str(acc+1):
            new.append(j)
        return new


a = Solution()
print(a.plusOne([1, 2, 3]))