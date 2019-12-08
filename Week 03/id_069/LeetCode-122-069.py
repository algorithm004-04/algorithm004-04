# 20191102

# Done

"""
    贪心：
    1. 如果后一天比前一天高，将差值计入到总价中
"""
class Solution:
    def maxProfit(self, prices):
        maxprofit = 0
        for i in range(1, len(prices)):
            if prices[i] > prices[i - 1]:
                maxprofit += (prices[i] - prices[i - 1])
        return maxprofit


s = Solution()
print(s.maxProfit([1,2,3,4]))

