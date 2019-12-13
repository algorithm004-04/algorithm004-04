class Solution:
    def canJump(self, nums: List[int]) -> bool:
        leftmost = len(nums)-1
        for i in range(leftmost, -1, -1):
            if i + nums[i] >= leftmost:
                leftmost = i
        return leftmost == 0