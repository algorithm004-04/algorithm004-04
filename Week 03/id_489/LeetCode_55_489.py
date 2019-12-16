from typing import List
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        start = 0
        end = 0
        n = len(nums)
        while start <= end and end < len(nums) - 1:
            end = max(end, nums[start] + start)
            start += 1
        return end >= n-1


if __name__ == '__main__':
    solution = Solution()
    print(solution.canJump([2, 3, 1, 1, 4]))