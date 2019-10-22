#
# @lc app=leetcode.cn id=66 lang=python
#
# [66] 加一
#

# 1. 最后一个数值加一

# @lc code=start
class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """

        for i in range(len(digits)-1, -1, -1):
            if digits[i] < 9:
                digits[i] = digits[i] + 1
                return digits
            else:
                digits[i] = 0

        # 需要向前补 1 位
        digits.append(0)
        digits[0] = 1
        return digits
# @lc code=end

