#
# @lc app=leetcode.cn id=122 lang=python3
#
# [122] 买卖股票的最佳时机 II
#

# @lc code=start
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        count=0
        for i in range(0,len(prices)-1):
            if prices[i]<prices[i+1]:
                count+=prices[i+1]-prices[i]
        return count

        
# @lc code=end

