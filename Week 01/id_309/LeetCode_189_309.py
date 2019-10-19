from __future__ import annotations

class Solution1:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        x = 0
        lenth = len(nums)
        while x < k:
            tmp = nums[-1]
            x += 1
            i = 1
            while i < lenth:
                nums[-i] = nums[-i-1]
                i += 1
            nums[0] = tmp

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        import collections
        a = collections.deque(nums)
        a.rotate(k)
        nums[:] = list(a)

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k = k % n
        nums[:] = nums[n-k:] + nums[:n-k]


if __name__ == "__main__":
    nums = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21]
    k = 29
    Solution().rotate(nums, k)
    print(nums)


