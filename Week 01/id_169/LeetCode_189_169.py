from typing import List


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        方法一：使用一个新数组存储交换位置以后的数据，再覆盖原数组
        """
        k %= len(nums)
        if k == 0: return
        new_nums = nums[-k:] + nums[:-k]
        for i in range(len(nums)):
            nums[i] = new_nums[i]

    def rotate2(self, nums: List[int], k: int) -> None:
        """
        方法二：暴力旋转
        """
        k %= len(nums)
        if k == 0: return
        for i in range(k):
            fill = nums[len(nums) - 1]
            for j in range(len(nums)):
                fill, nums[j] = nums[j], fill

    def rotate3(self, nums: List[int], k: int) -> None:
        """
        方法三：多次反转
        """
        k %= len(nums)
        if k == 0: return
        self.rev(nums, 0, len(nums) - 1)
        self.rev(nums, 0, k - 1)
        self.rev(nums, k, len(nums) - 1)

    def rev(self, nums: List[int], start: int, end: int) -> None:
        while start < end:
            nums[start], nums[end], start, end = nums[end], nums[start], start + 1, end - 1
