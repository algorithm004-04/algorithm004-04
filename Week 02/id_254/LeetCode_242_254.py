import collections
# class Solution:
#     def isAnagram(self, s, t):
#         if len(s) != len(t): return False
#         result = True
#         set_result = set(s)
#         if set_result == set(t):
#             for i in set_result:
#                 result = result and (s.count(i) == t.count(i))
#                 if not result:
#                     return False
#             return True
#         return False


class Solution:
    def isAnagram(self, s, t):
        return collections.Counter(s) == collections.Counter(t)
