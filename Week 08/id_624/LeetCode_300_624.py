#
# @lc app=leetcode.cn id=300 lang=python3
#
# [300] 最长上升子序列
#
# https://leetcode-cn.com/problems/longest-increasing-subsequence/description/
#
# algorithms
# Medium (43.25%)
# Likes:    359
# Dislikes: 0
# Total Accepted:    38.4K
# Total Submissions: 88.3K
# Testcase Example:  '[10,9,2,5,3,7,101,18]'
#
# 给定一个无序的整数数组，找到其中最长上升子序列的长度。
# 
# 示例:
# 
# 输入: [10,9,2,5,3,7,101,18]
# 输出: 4 
# 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
# 
# 说明:
# 
# 
# 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
# 你算法的时间复杂度应该为 O(n^2) 。
# 
# 
# 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
# 
#

# @lc code=start
class Solution:
    def lengthOfLIS(self, nums: [int]) -> int:
        if not nums: return 0
        dp, res = [1 for _ in nums], 1
        for i in range(len(nums)):
            for j in range(i):
                if nums[j] < nums[i]:
                    dp[i] = max(dp[i], dp[j] + 1)
                if dp[i] > res: res = dp[i]
        return res
            

Solution().lengthOfLIS([10,9,2,5,3,7,101,18])                  
# @lc code=end

