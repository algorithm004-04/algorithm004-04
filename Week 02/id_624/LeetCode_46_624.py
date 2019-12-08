#
# @lc app=leetcode.cn id=46 lang=python3
#
# [46] 全排列
#
# https://leetcode-cn.com/problems/permutations/description/
#
# algorithms
# Medium (72.14%)
# Likes:    424
# Dislikes: 0
# Total Accepted:    53.7K
# Total Submissions: 74.2K
# Testcase Example:  '[1,2,3]'
#
# 给定一个没有重复数字的序列，返回其所有可能的全排列。
# 
# 示例:
# 
# 输入: [1,2,3]
# 输出:
# [
# ⁠ [1,2,3],
# ⁠ [1,3,2],
# ⁠ [2,1,3],
# ⁠ [2,3,1],
# ⁠ [3,1,2],
# ⁠ [3,2,1]
# ]
# 
#

# @lc code=start
class Solution:
    def permute(self, nums: [int]) -> [[int]]:
        res, n = [], len(nums)

        def helper(first=0):
            if first == n:
                res.append(nums.copy())
            for i in range(first, n):
                nums[i], nums[first] = nums[first], nums[i]
                helper(first+1)
                nums[i], nums[first] = nums[first], nums[i]

        helper()
        return res

# @lc code=end

