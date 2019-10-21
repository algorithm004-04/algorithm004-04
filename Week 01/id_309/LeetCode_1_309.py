from __future__ import annotations

class Solution1:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for a in nums:
            b = target - a
            check_nums = list(nums)
            check_nums.remove(a)
            if b in check_nums:
                if a not in check_nums:
                    return [nums.index(a), nums.index(b)]
                else:
                    reverse_nums = list(nums)
                    reverse_nums.reverse()
                    index_b = len(nums) - 1 - reverse_nums.index(b)
                    return [nums.index(a), index_b]

class Solution2:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for a in nums:
            b = target - a
            index_a = nums.index(a)
            if b in nums[index_a + 1:]:
                if a not in nums[index_a + 1:]:
                    return [index_a, nums.index(b)]
                else:
                    return [i for i,x in enumerate(nums) if x==a]

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for a in nums:
            b = target - a
            index_a = nums.index(a)
            last_nums = nums[index_a + 1:]
            if b in last_nums:
                if a != b:
                    return [index_a, nums.index(b)]
                else:
                    index_b = index_a + 1 + last_nums.index(b)
                    return [index_a, index_b]


if __name__ == "__main__":
    nums = [3, 1, 1, 3]
    target = 6
    a = Solution().twoSum(nums, target)
    print(a)
