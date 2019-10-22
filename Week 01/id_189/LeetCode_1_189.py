#
# @lc app=leetcode.cn id=1 lang=python
#
# [1] 两数之和
#


# 1. 暴力法。
# 2019.10.19 通过


# class Solution(object):
#     def twoSum(self, nums, target):
#         """
#         :type nums: List[int]
#         :type target: int
#         :rtype: List[int]
#         """
#         for i in range(len(nums)):
#             for j in range(i+1, len(nums)):
#                 if nums[i] + nums[j] == target:
#                     return [i, j]

# 2. 用字典缓存 {key = target - current number; value = current index}. 参考高分答案。
# 2019.10.19 通过

# @lc code=start
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        dict = {}
        for i in range(len(nums)):
            if nums[i] in dict:
                return [dict[nums[i]],i]
            else:
                dict[target - nums[i]] = i
# @lc code=end