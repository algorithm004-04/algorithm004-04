#
# @lc app=leetcode.cn id=20 lang=python
#
# [20] 有效的括号
#

# 1. Stack method

# @lc code=start
class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """

        stack = []

        map = {")":"(", "]":"[", "}":"{"}

        for char in s:
            if char in map and len(stack) > 0 and map[char] == stack[-1]:
                stack.pop()
            elif char not in map:
                stack.append(char)
            else: 
                return False

        if stack == []:
            return True
        else:
            return False

        
# @lc code=end

