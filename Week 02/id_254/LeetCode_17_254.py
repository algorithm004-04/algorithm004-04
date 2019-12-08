# class Solution:
#     def letterCombinations(self, digits: str) -> List[str]:
#         phone = {'2': ['a', 'b', 'c'],
#                  '3': ['d', 'e', 'f'],
#                  '4': ['g', 'h', 'i'],
#                  '5': ['j', 'k', 'l'],
#                  '6': ['m', 'n', 'o'],
#                  '7': ['p', 'q', 'r', 's'],
#                  '8': ['t', 'u', 'v'],
#                  '9': ['w', 'x', 'y', 'z']}
#         output = []

#         def backTrack(conbination, next_digits):
#             if not next_digits:
#                 output.append(conbination)
#             else:
#                 cur = phone[next_digits[0]]
#                 for val in cur:
#                     backTrack(conbination+val, next_digits[1:])

#         if not digits:
#             return []
#         backTrack('', digits)
#         return output


class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        mapping = {'2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl',
                   '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz'}
        if len(digits) == 0:
            return []
        if len(digits) == 1:
            return list(mapping[digits[0]])
        pre = self.letterCombinations(digits[:-1])
        addCondition = mapping[digits[-1]]
        return [s+c for s in pre for c in addCondition]
