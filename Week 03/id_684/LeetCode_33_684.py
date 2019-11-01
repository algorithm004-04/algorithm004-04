# -*- coding: utf8 -*-


"""
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。

示例 1:

输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
示例 2:

输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1
"""
class Solution(object):
    def binary_search(self,nums,target):
        """
        二分查找
        :param nums:
        :param target:
        :return:
        """
        left,right = 0,len(nums)-1
        while left <= right:
            mid = left + (right -left) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] > target:
                right = mid - 1
            else:
                left = mid + 1
        return None
    def find_roate_index(self,nums):
        """
        寻找选择数组的分割点
        :param nums:
        :return:
        """
        if not nums:return 0
        left,right = 0 , len(nums) -1
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] < nums[mid -1]:
                return mid
            else:
                if nums[mid] < nums[right]:
                    right = mid -1
                else:
                    left = mid + 1
        return 0

    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """

        pivot = self.find_roate_index(nums)
        numsa = nums[:pivot]
        numsb = nums[pivot:]
        resa = self.binary_search(numsa,target)
        resb = self.binary_search(numsb,target)
        if resa is not None:
            return resa
        if resb is not None:
            return pivot + resb
        if resa is None and resb is None:
            return -1

if __name__ == '__main__':
    slt = Solution()
    nums = [4, 5, 6, 7, 0, 1, 2]
    slt.search(nums, 6)
