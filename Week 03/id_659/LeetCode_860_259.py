#
# @lc app=leetcode.cn id=860 lang=python3
#
# [860] 柠檬水找零
#

# @lc code=start
class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        change={5:0,10:0,20:0}
        for i in bills:
            if i ==5:
                change[5]+=1
            elif i==10 and change[5]>0:
                change[5]-=1
                change[10]+=1
            elif i==20 and change [10]>0 and change[5]>0:
                change[5]-=1
                change[10]-=1
            elif i==20 and change [10]==0 and change[5]>2:
                change[5]-=3
            else:
                return False
        return True
      