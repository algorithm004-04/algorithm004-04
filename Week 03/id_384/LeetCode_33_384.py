class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1
        while left < right:
            mid = (left + right) // 2
            if nums[mid] == target:
                return mid
            elif (nums[mid] < nums[0]) ^ (nums[0] > target) ^ (target > nums[mid]):
                left = mid + 1
            else:
                right = mid
        if left == right and nums[left] == target:
            return left
        return -1
    
