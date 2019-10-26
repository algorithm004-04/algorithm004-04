#
# @lc app=leetcode.cn id=88 lang=python
#
# [88] 合并两个有序数组
#

# 1. 双指针由后往前依次比较.
# 2019.10.20 通过。


# class Solution(object):
#     def merge(self, nums1, m, nums2, n):
#         """
#         :type nums1: List[int]
#         :type m: int
#         :type nums2: List[int]
#         :type n: int
#         :rtype: None Do not return anything, modify nums1 in-place instead.
#         """

#         # nums1 长度限定在 m + n

#         while len(nums1) > m + n:
#             nums1.pop()
        
#         for i in range(m+n-1,-1,-1):
#             if n-1 < 0: break
#             if m-1 < 0:
#                 nums1[i] = nums2[n-1]
#                 n -= 1
#             elif nums1[m-1] > nums2[n-1]:
#                 nums1[i] = nums1[m-1]
#                 m -= 1
#             else:
#                 nums1[i] = nums2[n-1]
#                 n -= 1

#         return nums1


# 2. 思路一样，参考高分评论里面更简洁的写法。

# @lc code=start


class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: None Do not return anything, modify nums1 in-place instead.
        """

        while n > 0:
            if m <= 0 or nums1[m-1] <= nums2[n-1]:
                nums1[n+m-1] = nums2[n-1]
                n -= 1
            else:
                nums1[n+m-1] = nums1[m-1]
                m -= 1

# @lc code=end

