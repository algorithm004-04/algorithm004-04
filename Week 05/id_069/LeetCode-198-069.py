# 20191117

"""
DP:
    1. 分治
    2. 状态定义
    3. DP方程
"""
class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return 0
        n = len(nums)
        a = [[0] * 2 for _ in range(n)]
        a[0][0] = 0
        a[0][1] = nums[0]
        for i in range(1, n):
            a[i][0] = max(a[i - 1][0], a[i - 1][1])
            a[i][1] = a[i - 1][0] + nums[i]

        return max(a[n - 1][0], a[n - 1][1])

class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0]

        n = len(nums)
        a = [0] * n

        a[0] = nums[0]
        a[1] = max(nums[0], nums[1])
        res = max(a[0], a[1])

        for i in range(2, n):
            a[i] = max(a[i-1], a[i-2] + nums[i])
            res = max(res, a[i])
        return res
