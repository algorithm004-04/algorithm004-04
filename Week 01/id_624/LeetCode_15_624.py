#
# @lc app=leetcode.cn id=15 lang=python3
#
# [15] 三数之和
#
# https://leetcode-cn.com/problems/3sum/description/
#
# algorithms
# Medium (24.12%)
# Likes:    1431
# Dislikes: 0
# Total Accepted:    105.5K
# Total Submissions: 436.7K
# Testcase Example:  '[-1,0,1,2,-1,-4]'
#
# 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
# ？找出所有满足条件且不重复的三元组。
# 
# 注意：答案中不可以包含重复的三元组。
# 
# 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
# 
# 满足要求的三元组集合为：
# [
# ⁠ [-1, 0, 1],
# ⁠ [-1, -1, 2]
# ]
# 
# 
#

# @lc code=start
class Solution:
    def threeSum(self, nums: [int]) -> [[int]]:
        nums = sorted(nums)
        res = []
        for k in range(len(nums)-2) :
            if nums[k] > 0 : break
            if k > 0 and nums[k] == nums[k - 1] : continue
            i, j = k+1, len(nums)-1
            while i < j :
                s = nums[k] + nums[i] + nums[j]
                if s < 0 : 
                    while i < j and nums[i] == nums[i+1] : i += 1
                    i += 1
                elif s > 0 :
                    while j > i and nums[j] == nums[j-1] : j -= 1
                    j -= 1
                else :
                    res.append([nums[k], nums[i], nums[j]]) 
                    while i < j and nums[i] == nums[i+1] : i += 1
                    while j > i and nums[j] == nums[j-1] : j -= 1
                    i += 1   
                    j -= 1    
        return res

# @lc code=end

