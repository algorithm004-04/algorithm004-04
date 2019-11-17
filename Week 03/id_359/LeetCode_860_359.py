# https://leetcode-cn.com/problems/lemonade-change/description/
# 860. 柠檬水找零
# 贪心策略，注意必须顺序找零（terminator）

class Solution(object):
    def lemonadeChange(self, bills):
        """
        :type bills: List[int]
        :rtype: bool
        """
        i10, i5 = 0, 0
        for i in bills:
            if i5 < 0: # terminator：5块钱被超额使用
                return False
            if i == 20:
                if i10: # 找10+5
                    i10 -= 1
                    i5 -= 1
                else: # 找3张5
                    i5 -= 3
            elif i == 10:
                i10 += 1 # 收下10
                i5 -= 1 # 支出5
            else:
                i5 += 1
        return i5 >= 0