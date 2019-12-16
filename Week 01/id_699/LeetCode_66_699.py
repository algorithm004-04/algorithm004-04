#
# @lc app=leetcode.cn id=66 lang=python3
#
# [66] 加一
#
# https://leetcode-cn.com/problems/plus-one/description/
#
# algorithms
# Easy (41.17%)
# Likes:    367
# Dislikes: 0
# Total Accepted:    90.2K
# Total Submissions: 216.6K
# Testcase Example:  '[1,2,3]'
#
# 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
# 
# 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
# 
# 你可以假设除了整数 0 之外，这个整数不会以零开头。
# 
# 示例 1:
# 
# 输入: [1,2,3]
# 输出: [1,2,4]
# 解释: 输入数组表示数字 123。
# 
# 
# 示例 2:
# 
# 输入: [4,3,2,1]
# 输出: [4,3,2,2]
# 解释: 输入数组表示数字 4321。
# 
# 
#

# @lc code=start
class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        def _plusOne(idx, digits, isCarry=True):
            if idx < -len(digits):
                if isCarry:
                    digits.insert(idx, 1)
                return
            if isCarry:
                digits[idx] += 1
                isCarry = False
            if digits[idx] >= 10:
                digits[idx] = digits[idx] % 10
                isCarry = True
            _plusOne(idx-1, digits, isCarry)

        _plusOne(-1, digits)
        return digits

        
# @lc code=end

