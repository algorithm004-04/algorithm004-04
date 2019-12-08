#
# @lc app=leetcode.cn id=455 lang=python3
#
# [455] 分发饼干
#

# @lc code=start
class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g.sort()
        s.sort()
        gi =0
        si=0
        g_length = len(g)
        s_length = len(s)
        while (gi<g_length and si<s_length):
            if (g[gi]<=s[si]):
                gi+=1
            si+=1
        return gi
  
                
        
# @lc code=end

