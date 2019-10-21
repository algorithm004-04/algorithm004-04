#
# @lc app=leetcode.cn id=66 lang=python3
#
# [66] 加一
#

# @lc code=start
class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        addOne = False
        for i in range(len(digits)-1,-1,-1):
            if digits[i]==9 and i == 0:
                digits[i]=0
                addOne = True
            elif  digits[i]==9 and i >0:
                digits[i]=0
            else:
                digits[i]=digits[i]+1
                break
        if addOne:
            one =[1]
            digits = one+digits
        
        return digits


                


          
# @lc code=end

           

