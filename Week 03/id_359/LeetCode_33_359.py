# https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
# 33. 搜索旋转数组
class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if not nums:
            return -1
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = (left + right) / 2
            if nums[mid] == target:
                return mid
            elif nums[mid] < target: 
                if target <= nums[right] or nums[left] <= nums[mid]:
                    left = mid + 1
                else:
                    right = mid - 1
            else:
                if nums[left] <= target or nums[right] >= nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
        return -1