#20191025

"""
    解法1：
    1. 先不处理括号合法问题
    2. 判断括号合法并输出
"""

# class Solution:
#     def generateParenthesis(self, n):
#         res = []
#         self.generate(0, 2*n, "", res)
#         final = []
#         for i in res:
#             if self.judge(i):
#                 final.append(i)
#         return final

#     def generate(self, level, max_n, s, res):
#         if level >= max_n:
#             res.append(s)
#             return res
        
#         self.generate(level+1, max_n, s+"{", res)
#         self.generate(level+1, max_n, s+"}", res)

#     def judge(self, input):
#         stack = []
#         for index, value in enumerate(input):
#             if value == "{":
#                 stack.append(value)
#             else:
#                 if stack:
#                     stack.pop()
#                 else:
#                     return False
#         if not stack:
#             return True
#         else:
#             return False


"""
    解法2：
        1. 左括号可以任意时刻放，并小于n
        2. 右括号必须有左括号是放，并小于左括号
"""

class Solution:
    def generateParenthesis(self, n):
        res = []
        self.generate(0, 0, n, "", res)
        return res

    def generate(self, left, right, n, s, res):
        if left == n and right == n:
            res.append(s)
        if left < n:
            self.generate(left + 1, right, n, s + '(', res)
        if right < left:
            self.generate(left, right + 1, n, s + ')', res)





    

s = Solution()
print(s.generateParenthesis(3))
        