from typing import List

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) < 2:
            return len(nums)
            
        uniq_pos = 0  # 遍历时用于标记唯一值的位置
        for i in range(1, len(nums)):
            if nums[i] != nums[uniq_pos]:
                uniq_pos += 1
                nums[uniq_pos] = nums[i]

        return uniq_pos + 1
