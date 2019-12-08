# 20191103

# Done
class Solution:
    def search(self, nums, target):
        left, right = 0, len(nums)-1

        while left < right:
            mid = left + (right - left) // 2
            if nums[0] <= nums[mid] and (target > nums[mid] or target < nums[0]):
                left = mid + 1
            elif target > nums[mid] and target < nums[0]:
                left = mid + 1
            else:
                right = mid
        return left if left == right and nums[left] == target else -1



s = Solution()
print(s.search([4,5,6,0,1,2], 0))