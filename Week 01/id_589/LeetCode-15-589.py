#
# @lc app=leetcode.cn id=15 lang=python3
#
# [15] 三数之和
#
# https://leetcode-cn.com/problems/3sum/description/
#
# algorithms
# Medium (24.33%)
# Likes:    1506
# Dislikes: 0
# Total Accepted:    116K
# Total Submissions: 475.8K
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
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        result = []
        nums.sort()
        length = len(nums)
        for i in range(length - 2): #[8]
            if nums[i] > 0: #[7]
                break
            if i > 0 and nums[i] == nums[i-1]: #[1]
                continue

            left, right = i + 1, length - 1 #[2]
            while left < right:
                total = nums[i] + nums[left] + nums[right]
                if total < 0: #[3]
                    left += 1
                elif total > 0: #[4]
                    right -= 1
                else: #[5]
                    result.append([nums[i], nums[left], nums[right]])
                    while left < right and nums[left] == nums[left + 1]: #[6]
                        left += 1
                    while left < right and nums[right] == nums[right - 1]: #[6]
                        right -= 1
                    left += 1
                    right -= 1
        return result




        
# @lc code=end

