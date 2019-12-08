#!/usr/bin/env python
#-*-coding:utf-8-*-
# author:lwz


def search(nums, target):
    nums = sorting(nums) # 排序
    left, right = 1, len(nums) - 1
    while left <= right:
        mid = int((left + right) / 2)
        if nums[mid] == target:
            return mid
        elif nums[mid] > target:
            right = mid - 1
        elif nums[mid] < target:
            left = mid + 1
    return -1


def sorting(nums):
    "二分查找将旋转的数组恢复单调排序"
    left, right = 0, len(nums) - 1
    rotate = 0
    while left < right:
        mid = int((left + right) / 2)
        if nums[mid] < nums[mid - 1]:
            rotate = mid
            break
        else:
            if nums[mid] > nums[left]: # mid在旋转点的左侧
                left = mid
            else: # mid在旋转点的右侧
                right = mid

    front = nums[rotate:len(nums)]
    behind = nums[0:rotate]
    return front + behind


def search2(nums, target):
    "二分法"
    L, H = 0, len(nums)
    while L < H:
        M = (L + H) // 2
        if nums[M] < nums[0] <= target:  # +inf
            H = M
        elif nums[M] > nums[0] > target:  # -inf
            L = M + 1
        elif nums[M] < target:
            L = M + 1
        elif nums[M] > target:
            H = M
        else:
            return M
    return -1



list = [4,5,6,7,0,1,2]

print(search(list, 5))



