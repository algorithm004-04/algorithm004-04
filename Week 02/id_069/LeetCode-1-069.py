# 20191023

"""
解法1：
    暴力解决
    1. 遍历List将该index后的数字进行相加，如果等于target则输出
"""

# class Solution:
#     def twoSum(self, nums, target):
#         for index, num in enumerate(nums):
#             for i in range(index + 1, len(nums)):
#                 if num + nums[i] == target:
#                     return [index, i]

"""
    暴力解法的简洁写法
    1. 将第二次遍历写成切片形式
"""
class Solution:
    def twoSum(self, nums, target):
        for i in range(len(nums)):
            if target-nums[i] in nums[i+1:]:
                return [i,nums.index(target-nums[i],i+1)]

"""
解法2：
    哈希表
    1. 将List填入哈希表
    2. 将target - value 进行查找
"""

# class Solution:
#     def twoSum(self, nums, target):
#         dict = {}
#         for index, num in enumerate(nums):
#             dict[num] = index
#         for index, num in enumerate(nums):
#             if target - num in dict and dict[target - num] != index:
#                     return [index, dict[target - num]]

"""
解法3：
    一次哈希表
    1. 将target - value 结果向已经填写过的dict里面查找
"""
class Solution:
    def twoSum(self, nums, target):
        dict = {}
        for index, num in enumerate(nums):
            if target - num in dict:
                return [dict[target - num], index]
            dict[num] = index

s = Solution()
print(s.twoSum([2, 7 , 11, 15], 9))
print(s.twoSum([3, 2, 4], 6))