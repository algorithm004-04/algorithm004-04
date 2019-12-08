#
# @lc app=leetcode.cn id=120 lang=python3
#
# [120] 三角形最小路径和
#
# https://leetcode-cn.com/problems/triangle/description/
#
# algorithms
# Medium (62.07%)
# Likes:    247
# Dislikes: 0
# Total Accepted:    28.5K
# Total Submissions: 45.7K
# Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
#
# 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
# 
# 例如，给定三角形：
# 
# [
# ⁠    [2],
# ⁠   [3,4],
# ⁠  [6,5,7],
# ⁠ [4,1,8,3]
# ]
# 
# 
# 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
# 
# 说明：
# 
# 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
# 
#

# @lc code=start
class Solution:
    def minimumTotal(self, triangle: [[int]]) -> int:
        temp = [0]*(len(triangle[-1])+1)
        for i in range(len(triangle)-1, -1, -1):
            for j in range(len(triangle[i])):
                temp[j] = min(temp[j], temp[j + 1]) + triangle[i][j]
        return temp[0]

print(Solution().minimumTotal([[2],[3,4],[6,5,1],[4,1,8,3]]))

# @lc code=end

