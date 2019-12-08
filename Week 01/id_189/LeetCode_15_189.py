#
# @lc app=leetcode.cn id=15 lang=python
#
# [15] 三数之和
#

# 1. 暴力法。
# 2019.10.19 超时


# class Solution(object):
#     def threeSum(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: List[List[int]]
#         """
        
#         res = []
#         nums.sort()

#         for i in range(len(nums)):
#             for j in range(i+1, len(nums)):
#                 for k in range(j+1, len(nums)):
#                     if nums[i] + nums[j] + nums[k] == 0:
#                         if [nums[i], nums[j], nums[k]] not in res:
#                             res.append([nums[i], nums[j], nums[k]])       
#         return res



# 2. 结合 2sum 字典法。
# 2019.10.19 超时
# 测试结果不一致。字典没办法保证顺序是从小到大。

# class Solution(object):
#     def threeSum(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: List[List[int]]
#         """

#         res = []
#         nums.sort()

#         for i in range(len(nums)):
#             dict = {}
#             for j in range(i+1, len(nums)):
#                 if nums[j] in dict:
#                     if [nums[i],nums[dict[nums[j]]],nums[j]] not in res:
#                         res.append([nums[i],nums[dict[nums[j]]],nums[j]])
#                 else:
#                     dict[-nums[i] - nums[j]] = j

#         return res


# 3. 排序 +  双指针。抄高分评论。



class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        res, k = [], 0

        for k in range(len(nums)-2):
            if nums[k] > 0: 
                break
            if k > 0 and nums[k] == nums[k-1]: 
                continue
               
            i, j = k + 1, len(nums) - 1
            
            while i < j:
                s = nums[k] + nums[i] + nums[j]

                if s < 0:
                    i += 1
                    while i < j and nums[i] == nums[i-1]:
                        i += 1
                elif s > 0:
                    j -= 1
                    while i < j and nums[j] == nums[j+1]:
                        j -= 1
                else:
                    res.append([nums[k],nums[i],nums[j]])
                    j -= 1
                    i += 1
                    while i < j and nums[i] == nums[i-1]:
                        i += 1
                    while i < j and nums[j] == nums[j+1]:
                        j -= 1
        return res

        



