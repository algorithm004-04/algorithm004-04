'''
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

请找出其中最小的元素。

你可以假设数组中不存在重复元素。

'''

class Solution(object):
    def findMin(self, nums):

        if len(nums) == 1:
            return nums[0]


        left = 0

        right = len(nums) - 1

        if nums[right] > nums[0]:
            return nums[0]

        while right >= left:

            mid = left + (right - left) / 2

            if nums[mid] > nums[mid + 1]:
                return nums[mid + 1]

            if nums[mid - 1] > nums[mid]:
                return nums[mid]

            if nums[mid] > nums[0]:
                left = mid + 1

            else:
                right = mid - 1
