#
# @lc app=leetcode.cn id=77 lang=python3
#
# [77] 组合
#
# https://leetcode-cn.com/problems/combinations/description/
#
# algorithms
# Medium (70.73%)
# Likes:    174
# Dislikes: 0
# Total Accepted:    22.8K
# Total Submissions: 32.2K
# Testcase Example:  '4\n2'
#
# 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
# 
# 示例:
# 
# 输入: n = 4, k = 2
# 输出:
# [
# ⁠ [2,4],
# ⁠ [3,4],
# ⁠ [2,3],
# ⁠ [1,2],
# ⁠ [1,3],
# ⁠ [1,4],
# ]
# 
#

# @lc code=start
class Solution:
    def combine(self, n: int, k: int) -> [[int]]: 
        res = []
  
        def helper(sol=[], start=1):
            if len(sol) == k: 
                res.append(sol)
                return
            for i in range(start, n-k+len(sol)+2):
                sol.append(i)
                helper(sol.copy(), i + 1)
                sol.remove(i)

        helper()
        return res
            
print(Solution().combine(4, 3))

# @lc code=end

