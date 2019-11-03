#
# @lc app=leetcode.cn id=22 lang=python
#
# [22] 括号生成
#

# 1. 回溯法。CN 站官方解答
# 2019.10.27 通过

# @lc code=start
class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """

        ans = []

        def backtrack(s = '', left=0, right=0):
            if len(s) == n * 2:
                ans.append(s)
                return ans
            if left < n:
                backtrack(s+'(', left+1, right)
            if right < left:
                backtrack(s+')', left, right+1)
        
        backtrack()
        return ans
        
# @lc code=end

