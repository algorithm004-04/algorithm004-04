#
# @lc app=leetcode.cn id=64 lang=python3
#
# [64] 最小路径和
#
# https://leetcode-cn.com/problems/minimum-path-sum/description/
#
# algorithms
# Medium (62.51%)
# Likes:    317
# Dislikes: 0
# Total Accepted:    42K
# Total Submissions: 66.7K
# Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
#
# 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
# 
# 说明：每次只能向下或者向右移动一步。
# 
# 示例:
# 
# 输入:
# [
# [1,3,1],
# ⁠ [1,5,1],
# ⁠ [4,2,1]
# ]
# 输出: 7
# 解释: 因为路径 1→3→1→1→1 的总和最小。
# 
# 
#

# @lc code=start
class Solution:
    def minPathSum(self, grid: [[int]]) -> int:
        dp = [0]*len(grid[0])
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if i == 0:
                    dp[j] = grid[i][j] + (dp[j - 1] if j > 0 else 0)
                elif j == 0:
                    dp[j] = grid[i][j] + dp[j]
                else:
                    dp[j] = min(dp[j], dp[j - 1]) + grid[i][j]
        return dp[-1]
        
# Solution().minPathSum([
#   [1,3,1],
#   [1,5,1],
#   [4,2,1]
# ])
# @lc code=end

