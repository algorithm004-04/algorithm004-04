# 20191027


"""
    递归
"""

# class Solution:
#     def subsets(self, nums):
#         ans = []
#         if nums == None:
#             return ans
#         self.dfs(ans, nums, [], 0)
#         return ans

#     def dfs(self, ans, nums, arrayList, index):
#         if index == len(nums):
#             ans.append(arrayList[:])
#             return
#         self.dfs(ans, nums, arrayList, index + 1)
#         arrayList.append(nums[index])
#         self.dfs(ans, nums, arrayList, index + 1)

#         arrayList.pop()


"""
    迭代
"""
# class Solution:
#     def subsets(self, nums):
#         res = [[]]
#         for num in nums:
#             newsets = []
#             for subset in res:
#                 new_subset = subset + [num]
#                 newsets.append(new_subset)
#             res.extend(newsets)
#         return res

"""
    简写迭代
"""

class Solution:
    def subsets(self, nums):
        res = [[]]
        for num in nums:
            res = res + [[num] + i for i in res]
        return res

s = Solution()
print(s.subsets([1, 2, 3]))