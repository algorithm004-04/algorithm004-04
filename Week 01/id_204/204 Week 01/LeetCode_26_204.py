'''
Descripe:
1.给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
2.不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

Author: 大宇

Week 01 Homework

'''

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        count,index,temp = 0,0,nums[0]
        done_index = [0]
        while count < len(nums):
            count,target = count+1, (index + k) % len(nums)
            temp,nums[target] = nums[target],temp
            if target not in done_index:
                index = target
            elif target + 1 < len(nums):
                index,temp = target + 1,nums[target + 1]
            done_index.append(index)




