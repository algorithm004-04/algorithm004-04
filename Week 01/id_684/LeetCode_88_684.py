# -*- coding: utf8 -*-



"""
https://leetcode-cn.com/problems/merge-sorted-array/
给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
示例:

输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]

"""

class Solution(object):

    def merge(self, nums1, m, nums2, n):
        """
        时间复杂度O(m+n),空间复杂度O(m+n)
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: None Do not return anything, modify nums1 in-place instead.
        """
        #拷贝一个新的list
        num1_copy = nums1[:]
        i = 0
        j = 0
        k = 0
        while 1:
            if i < m and j < n:
                if num1_copy[i] <= nums2[j]:
                    nums1[k]=num1_copy[i]
                    i += 1
                else:
                    nums1[k] = nums2[j]
                    j += 1
            elif i < m and j >= n:
                nums1[k]=num1_copy[i]
                i += 1
            elif i >= m and j < n:
                nums1[k] = nums2[j]
                j += 1
            else:break
            k += 1
        print(nums1)



if __name__ == '__main__':
    nums1 = [1, 2, 3, 0, 0, 0]
    m = 3
    nums2 = [2, 5, 6]
    n = 3
    # nums1 = [0]
    # m = 0
    # nums2 = [1]
    # n = 1
    slt = Solution()
    slt.merge(nums1, m, nums2, n)


