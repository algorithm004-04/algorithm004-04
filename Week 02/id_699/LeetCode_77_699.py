#
# @lc app=leetcode.cn id=77 lang=python3
#
# [77] 组合
#
# https://leetcode-cn.com/problems/combinations/description/
#
# algorithms
# Medium (70.70%)
# Likes:    173
# Dislikes: 0
# Total Accepted:    22.4K
# Total Submissions: 31.6K
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
    def combine(self, n: int, k: int) -> List[List[int]]:
        result = []
        start = 1
        self.pickOne(n, start, k, result=result)
        return result
    
    def pickOne(self, n, start, k, tmpList=[], result=[]):
        if k <= 0 or n <= 0 or n < k:
            result.append(tmpList)
            return
        for j in range(start, n-k+2):
            tmp = tmpList + [j]
            self.pickOne(n, j+1, k-1, tmp, result)
# @lc code=end

