#1.利用python列表生成式
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        m = {'2': list('abc'), '3': ('def'), '4': ('ghi'), '5': ('jkl'), '6': ('mno'), '7': ('pqrs'), '8': ('tuv'), '9': ('wxyz')}
        if not digits:
            return []
        res = ['']
        for i in digits:
            res = [x + y for x in res for y in m[i]]
        return res

#2.递归：
#同生成括号，每个位置看成一个槽，依次将元素循环放入
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []
        self.m = {'2': list('abc'), '3': ('def'), '4': ('ghi'), '5': ('jkl'), '6': ('mno'), '7': ('pqrs'), '8': ('tuv'), '9': ('wxyz')}
        self.a = []
        self.xun(digits, '')
        return self.a
    
    def xun(self, d, s):
        if not d:
            self.a.append(s)
            return
        for i in self.m[d[0]]:
            self.xun(d[1: ], s + i)

