# class Solution:
#     def removeDuplicates(self, nums: List[int]) -> int:
#         if not nums:
#             return 0
#         j = 0
#         for i in range(1,len(nums)):
#             if nums[i] != nums[j]:
#                 j += 1
#                 nums[j] = nums[i]
#         return (j + 1)
'''
给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
'''
def removeDuplicates(nums):
        if not nums:
            return 0
        j = 0
        for i in range(1,len(nums)):
            if nums[i] != nums[j]:
                j += 1
                nums[j] = nums[i]
        return (j + 1)

num = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
tmp = removeDuplicates(num)
print(tmp)
