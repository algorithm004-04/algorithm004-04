class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if no digits:
            return
        res = []
        phone = {'2': ['a', 'b', 'c'],
                 '3': ['d', 'e', 'f'],
                 '4': ['g', 'h', 'i'],
                 '5': ['j', 'k', 'l'],
                 '6': ['m', 'n', 'o'],
                 '7': ['p', 'q', 'r', 's'],
                 '8': ['t', 'u', 'v'],
                 '9': ['w', 'x', 'y', 'z']}

        def helper(s, digits, i):
            if i == len(digits):
                res.append(s)
                return
            letters = phone.get(digits[i])
            for letter in letters:
                helper(s+letter, digits, i+1)
        helper('', digits, 0)
        return res
