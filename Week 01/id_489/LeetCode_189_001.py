# 思路一：插入
# class Solution:
#     def rotate(self, nums, k):
#         n = len(nums)
#         k %= n
#         for _ in range(k):
#             nums.insert(0, nums.pop())
#         return nums

# 思路二：拼接
# class Solution:
#     def rotate(self, nums, k):
#         n = len(nums)
#         # k %= n
#         nums[:] = nums[-k:] + nums[:-k]
#         return nums

# 思路三：辅助数组
# class Solution:
#     def rotate(self, nums, k):
#         size = len(nums)
#         _nums = [num for num in nums]
#         for i in range(size):
#             nums[(i+k)%size] = _nums[i]
#         return nums

# 思路四：三重反转
class Solution:
    def rotate(self, nums, k):
        k %= len(nums)
        nums[:] = nums[::-1]
        nums[:k] = nums[:k][::-1]
        nums[k:] = nums[k:][::-1]
        return nums


a = Solution()
print(a.rotate([1, 2, 3, 4, 5], 2))