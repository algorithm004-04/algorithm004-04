# 中间元素与右边界比较
class Solution:
    def search(self, nums, target):
        size = len(nums)
        if size == 0:
            return -1
        left = 0
        right = size - 1
        while left < right:
            mid = left + (right - left + 1) // 2
            # mid = (left + right + 1) >> 1
            if nums[mid] < nums[right]:
                # [7,8,9,1,2,3,4,5,6], 后半部分有序
                if nums[mid] <= target <= nums[right]:
                    left = mid
                else:
                    right = mid - 1
            else:
                # 注意：写这个 if 语句的时候，要让分支和上面一样
                # [4,5,6,7,8,9,0,1,2]，前半部分有序
                if nums[left] <= target <= nums[mid - 1]:
                    right = mid - 1
                else:
                    left = mid
        # 后处理
        return left if nums[left] == target else -1


if __name__ == '__main__':
    solution = Solution()
    print(solution.search([4, 5, 6, 7, 0, 1, 2], 0))
