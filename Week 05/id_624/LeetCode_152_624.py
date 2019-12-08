#
# @lc app=leetcode.cn id=152 lang=python3
#
# [152] 乘积最大子序列
#
# https://leetcode-cn.com/problems/maximum-product-subarray/description/
#
# algorithms
# Medium (35.59%)
# Likes:    296
# Dislikes: 0
# Total Accepted:    24.9K
# Total Submissions: 69.5K
# Testcase Example:  '[2,3,-2,4]'
#
# 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
# 
# 示例 1:
# 
# 输入: [2,3,-2,4]
# 输出: 6
# 解释: 子数组 [2,3] 有最大乘积 6。
# 
# 
# 示例 2:
# 
# 输入: [-2,0,-1]
# 输出: 0
# 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
# 
#

# @lc code=start
class Solution:
    def maxProduct(self, nums: [int]) -> int:
        res, imin, imax = float("-inf"), 1, 1
        for n in nums:
            if n < 0: imax, imin = imin, imax
            imax = max(imax*n, n)
            imin = min(imin*n, n)
            res = max(res, imax)
        return res

print(Solution().maxProduct([-2]))
# @lc code=end

