#
# @lc app=leetcode.cn id=78 lang=python3
#
# [78] 子集
#
# https://leetcode-cn.com/problems/subsets/description/
#
# algorithms
# Medium (74.91%)
# Likes:    368
# Dislikes: 0
# Total Accepted:    41.9K
# Total Submissions: 55.9K
# Testcase Example:  '[1,2,3]'
#
# 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
# 
# 说明：解集不能包含重复的子集。
# 
# 示例:
# 
# 输入: nums = [1,2,3]
# 输出:
# [
# ⁠ [3],
# [1],
# [2],
# [1,2,3],
# [1,3],
# [2,3],
# [1,2],
# []
# ]
# 
#

# @lc code=start
class Solution:
    # 迭代法，结果数组中首先放入空数组，然后将待选数组中的每个元素与结果数组中已存在的元素依次组成新的元素添加进结果数组。
    # def subsets(self, nums: [int]) -> [[int]]:
    #     res = [[]]
    #     for n in nums:
    #         res += [[n] + r for r in res]
    #     return res

    # 回溯法（递归）,对于待选数组中的每个元素，在三元素组合中，都可以有选中和不选两种可能
    def subsets(self, nums: [int]) -> [[int]]:
        if not nums: return [[]]
        # list代表一个待填入结果的组合
        def dfs(list:[int], res:[], index:int):
            if index == len(nums):
                res.append(list)
                return
            
            dfs(list.copy(), res, index + 1)
            list.append(nums[index])
            dfs(list.copy(), res, index + 1)

        res = []
        dfs([], res, 0)
        return res

# @lc code=end

