
'''
    获取持续收益，只要当天的价格比前一天高就卖出，遍历价格列表
    执行用时 :72 ms
    内存消耗 :14.8 MB
    时间复杂度为：O(n)
    空间复杂度为：O(1)
'''
class Solution(object):
    def maxProfit(self, prices):
        maxProfit = 0
        for i in range(1, len(prices)):
            if prices[i] > prices[i-1]:
                maxProfit += prices[i] - prices[i-1]
                # print('i={},prices[{}]={},prices[{}]={},maxProfit:{}'.\
                #       format(i, i, prices[i], i-1, prices[i-1], maxProfit))
        return maxProfit


'''
    波峰波谷差
    时间复杂度：O(n)
    空间复杂度：O(1)
    执行用时 :68 ms, 在所有 python3 提交中击败了99.56%的用户
    内存消耗 :14.7 MB, 在所有 python3 提交中击败了5.31%的用户

class Solution(object):
    def maxProfit(self, prices):
        if len(prices) <= 1:
            return 0
        maxprofit = 0
        valley = prices[0]
        peak = prices[0]
        i = 0
        while i < len(prices) - 1:
            while i < len(prices) - 1 and prices[i] >= prices[i+1]:
                i += 1
                print('********i={}'.format(i))
            valley = prices[i]
            while i < len(prices) - 1 and prices[i] <= prices[i+1]:
                i += 1
                print('##########i={}'.format(i))
            peak = prices[i]
            maxprofit += peak - valley
            print('i={},len={},valley={},peak={}'.format(i, len(prices), valley, peak))
        return maxprofit

class Solution(object):
    def maxProfit(self, prices):
        return sum(b - a for a, b in zip(prices, prices[1:]) if b > a)

class Solution(object):
    def maxProfit(self, prices):
        return sum(max(prices[i] - prices[i - 1], 0) for i in range(1, len(prices)))
'''

'''
    暴力法
    时间复杂度：O(n^n),调用递归函数n^n次。
    空间复杂度：O(n)，递归的深度为 n。
    提交结果：超出时间限制

class Solution(object):
    def maxProfit(self, prices):
        return self.calculate(prices, 0)

    def calculate(self, prices, s):
        maxprofit = 0
        max = 0
        if s >= len(prices):
            return 0

        for start in range(s, len(prices)):
            print('*' * 30)
            for i in range(start+1, len(prices)):
                print('start={},i={},maxprofit={}'.format(start, i,maxprofit))
                if prices[start] < prices[i]:
                    profit = self.calculate(prices, i+1) + prices[i] - prices[start]
                    print('profit={},maxprofit={}'.format(profit, maxprofit))
                    if profit > maxprofit:
                        maxprofit = profit

            if maxprofit > max:
                max = maxprofit
            print('start={},max={},maxprofit={}'.format(start, max, maxprofit))
        return max
'''


prices = [1, 7, 2, 3, 6, 4, 7]
tmp = Solution()
print(tmp.maxProfit(prices))