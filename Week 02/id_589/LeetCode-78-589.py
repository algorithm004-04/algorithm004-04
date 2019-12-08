#
# @lc app=leetcode.cn id=78 lang=python3
#
# [78] 子集
#

# @lc code=start

# 思路一：库函数法
class Solution1:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        for i in range(len(nums)+1):
            for temp in itertools.combinations(nums, i):
                res.append(temp)
        return res

# 思路二：迭代法
class Solution2:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = [[]]
        for i in nums:
            res = res + [[i] + num for num in res]
        return res
# 思路三：递归法
class Solution3:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        n = len(nums)

        def helper(i, temp):
            res.append(temp)
            for j in range(i, n):
                helper(j+1, temp + [nums[j]])

        helper(0, [])
        return res

    
            

        
# @lc code=end

