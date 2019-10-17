# -*- coding: utf8 -*-



"""
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
示例 2:

输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。

"""

class Solution(object):

    def plus_one(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        i = len(digits) - 1
        while i >=0:
            digits[i] += 1
            digits[i] %=10
            if digits[i] !=0:
                return digits
            i -= 1
        return [1] + digits



if __name__ == '__main__':
    slt = Solution()
    digits = [9,9]
    print(slt.plus_one(digits))