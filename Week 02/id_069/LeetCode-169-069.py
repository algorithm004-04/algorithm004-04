#20191027


"""
    暴力解法：计数
"""
class Solution:
    def majorityElement(self, nums):
        numdict = {}
        for num in nums:
            if num not in numdict:
                numdict[num] = 1
            else:
                numdict[num] += 1
        return max(numdict.keys(), key=numdict.get)


s = Solution()
print(s.majorityElement([1,1,1,1,2,3,4,5,6]))