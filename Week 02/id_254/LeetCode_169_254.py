class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        candidate, count = nums[0], 1
        for val in nums[1:]:
            if val != candidate:
                if count == 0:
                    count = 1
                    candidate = val
                else:
                    count = count - 1
            elif val == candidate:
                count = count + 1
        return candidate
