#!/usr/bin/env python
#-*-coding:utf-8-*-
# author:lwz

string = ")()())"
string2 = "((((())))))()))())(("

# class Solution:
#     def longestValidParentheses(self, s: str):
#         stack, result = [], 0
#         for i in range(len(s)):
#             if s[i] == "(":
#                 stack.append(s[i])
#             elif s[i] == ")" and len(stack) != 0:
#                 stack.pop()
#                 result += 2
#         return result



class Solution(object):
    def longestValidParentheses(self, s):
        stack, ans = [], 0
        stack.append(-1)
        for i in range(len(s)):
            if s[i] == '(':
                stack.append(i)
            else:
                stack.pop()
                if len(stack) == 0:
                    stack.append(i)
                else:
                    ans = max(ans, i - stack[-1])
        return ans


solution = Solution()
print(solution.longestValidParentheses(string2))