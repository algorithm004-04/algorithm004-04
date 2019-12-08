#
# @lc app=leetcode.cn id=169 lang=python3
#
# [169] 求众数
#
# https://leetcode-cn.com/problems/majority-element/description/
#
# algorithms
# Easy (60.29%)
# Likes:    348
# Dislikes: 0
# Total Accepted:    79.9K
# Total Submissions: 132.4K
# Testcase Example:  '[3,2,3]'
#
# 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
# 
# 你可以假设数组是非空的，并且给定的数组总是存在众数。
# 
# 示例 1:
# 
# 输入: [3,2,3]
# 输出: 3
# 
# 示例 2:
# 
# 输入: [2,2,1,1,1,2,2]
# 输出: 2
# 
# 
#

# @lc code=start
import random
class Solution:
    # 分治
    # def majorityElement(self, nums: [int]) -> int:
    #     def helper(l: int, r: int) -> int:
    #         if l == r: return nums[l]
    #         mid = (r - l)//2 + l
    #         left = helper(l, mid)
    #         right = helper(mid+1, r)
    #         if left == right: return left
    #         leftCount = sum(1 for i in range(l, r+1) if nums[i] == left)
    #         rightCount = sum(1 for i in range(l, r+1) if nums[i] == right)
    #         return left if leftCount > rightCount else right
    #     return helper(0, len(nums)-1)

    # 排序
    # def majorityElement(self, nums: [int]) -> int:
    #     return sorted(nums)[len(nums)//2]

    # 随机，由于众数超过元素的一半，所以随机很有可能访问到，于是每次随机访问一个元素，计算该元素出现的次数，超过数组的一半即为答案
    def majorityElement(self, nums: [int]) -> int:
        target = len(nums)/2
        while True:
            s = random.choice(nums)
            if sum(1 for num in nums if num == s) > target: return s



# print(Solution().majorityElement([3,2,3]))
# @lc code=end

