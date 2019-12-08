class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        h = {}
        for i, e in enumerate(nums):
            t = target - e
            if t not in h:
                h[e] = i
            else:
                return [h[t], i]
