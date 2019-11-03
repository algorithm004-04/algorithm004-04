# coding=utf-8

"""
给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
示例 1:

给定数组 nums = [1,1,2],
函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
你不需要考虑数组中超出新长度后面的元素。

示例 2:
给定 nums = [0,0,1,1,1,2,2,3,3,4],
函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
你不需要考虑数组中超出新长度后面的元素。

说明:

为什么返回数值是整数，但输出的答案是数组呢?
请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
"""
from typing import List


class Solution:
    # 暴力法
    # def removeDuplicates(self, nums: List[int]) -> int:
    #     int2count = {}
    #     for i in nums:
    #         if i not in int2count:
    #             int2count[i] = 1
    #         else:
    #             int2count[i] += 1
    #     for k, v in int2count.items():
    #         for _ in range(v-1):
    #             nums.remove(k)
    #     return len(nums)

    # 快慢指针法 O(n)
    # 优化了上个解法中remove的多余消耗
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) == 0: return 0
        slow = 0
        sub = 0
        for fast in range(1, len(nums)):
            if nums[fast] != nums[slow]:
                slow += 1
                nums[slow] = nums[fast]
            sub = fast - slow
        for _ in range(sub):
            nums.pop(-1)
        return len(nums)


if __name__ == '__main__':
    solution = Solution()
    origin = [1, 1, 2]
    solution.removeDuplicates(origin)
    print(origin)
