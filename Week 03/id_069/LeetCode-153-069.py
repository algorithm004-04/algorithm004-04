# 20191102

# Dnoe

"""
    二分查找
"""
class Solution:
    def findMin(self, nums):
        left, right = 0, len(nums) - 1
        while left < right:
            mid = left + (right - left) // 2
            print("left: {}, right: {}, mid: {}".format(left, right, mid))
            print(nums[left:right+1])
            if nums[mid] > nums[right]:
                # 中间大于右边，则最小元素在右边
                left = mid + 1
            else:
                # 中间小于右边，则最小元素在左边
                right = mid
        return nums[left]


class Solution:
    def findMin(self, nums):
        left, right = 0, len(nums)-1

        while left < right:
            mid = left + (right - left) // 2

            if nums[mid] > nums[right]:
                #左边为升序
                left = mid + 1
            elif nums[mid] < nums[right] and nums[left] > nums[right]:
                # 右边为升序
                right = mid
            else:
                right = mid
        return nums[left]


s = Solution()
print(s.findMin([5, 6, 7, 0, 1, 2, 3]))
print(s.findMin([5, 1, 2, 3, 4]))