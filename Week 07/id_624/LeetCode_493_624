#
# @lc app=leetcode.cn id=493 lang=python3
#
# [493] 翻转对
#
# https://leetcode-cn.com/problems/reverse-pairs/description/
#
# algorithms
# Hard (19.16%)
# Likes:    51
# Dislikes: 0
# Total Accepted:    2K
# Total Submissions: 9.5K
# Testcase Example:  '[1,3,2,3,1]'
#
# 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
# 
# 你需要返回给定数组中的重要翻转对的数量。
# 
# 示例 1:
# 
# 
# 输入: [1,3,2,3,1]
# 输出: 2
# 
# 
# 示例 2:
# 
# 
# 输入: [2,4,3,5,1]
# 输出: 3
# 
# 
# 注意:
# 
# 
# 给定数组的长度不会超过50000。
# 输入数组中的所有数字都在32位整数的表示范围内。
# 
# 
#

# @lc code=start
class Solution:
    count = 0
    def reversePairs(self, nums: [int]) -> int:

        def mergeSort(l, r) -> int:
            if l >= r: return 0
            mid = l + (r - l) // 2
            count = mergeSort(l, mid) + mergeSort(mid + 1, r)
            j = mid + 1
            for i in range(l, mid+1):
                while j <= r and nums[i] / 2 > nums[j]: j += 1
                count += j - mid - 1

            # merge(l, mid, r)
            nums[l:r+1] = sorted(nums[l:r+1])
            return count

        # def merge(l, mid, r):
        #     i, j ,res = l, mid + 1, []
        #     while i <= mid and j <= r:
        #         if nums[i] <= nums[j]:
        #             res.append(nums[i]); i += 1
        #         else:
        #             res.append(nums[j]); j += 1
        #     if i <= mid: res += nums[i:mid+1]
        #     if j <= r: res += nums[j:r+1]
        #     nums[l:r+1] = res

        return mergeSort(0, len(nums)-1)


# @lc code=end

