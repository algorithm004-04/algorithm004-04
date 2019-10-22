#
# @lc app=leetcode.cn id=88 lang=python3
#
# [88] 合并两个有序数组
#
# https://leetcode-cn.com/problems/merge-sorted-array/description/
#
# algorithms
# Easy (45.50%)
# Likes:    329
# Dislikes: 0
# Total Accepted:    77.3K
# Total Submissions: 169.7K
# Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
#
# 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
# 
# 说明:
# 
# 
# 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
# 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
# 
# 
# 示例:
# 
# 输入:
# nums1 = [1,2,3,0,0,0], m = 3
# nums2 = [2,5,6],       n = 3
# 
# 输出: [1,2,2,3,5,6]
# 
#

# @lc code=start
class Solution:
    def merge(self, nums1: [int], m: int, nums2: [int], n: int) -> None:
        # 倒序由大到小插入数组。从m+n-1的位置开始填入正确的元素，m是nums1的倒序指针，n是nums2的倒序指针，将二者较大的元素填入即可
        m -= 1
        n -= 1
        for i in range(m + n-1, -1, -1):
            if n < 0: return
            if m < 0 or nums1[m] <= nums2[n]:
                nums1[i] = nums2[n]
                n -= 1
            else: 
                nums1[i] = nums1[m]
                m -= 1

        
# @lc code=end

