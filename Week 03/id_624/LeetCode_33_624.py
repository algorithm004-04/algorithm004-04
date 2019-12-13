#
# @lc app=leetcode.cn id=33 lang=python3
#
# [33] 搜索旋转排序数组
#
# https://leetcode-cn.com/problems/search-in-rotated-sorted-array/description/
#
# algorithms
# Medium (36.08%)
# Likes:    396
# Dislikes: 0
# Total Accepted:    51.6K
# Total Submissions: 143K
# Testcase Example:  '[4,5,6,7,0,1,2]\n0'
#
# 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
# 
# ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
# 
# 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
# 
# 你可以假设数组中不存在重复的元素。
# 
# 你的算法时间复杂度必须是 O(log n) 级别。
# 
# 示例 1:
# 
# 输入: nums = [4,5,6,7,0,1,2], target = 0
# 输出: 4
# 
# 
# 示例 2:
# 
# 输入: nums = [4,5,6,7,0,1,2], target = 3
# 输出: -1
# 
#

# @lc code=start
class Solution:
    # 此题考虑，若中值大于左值，则左侧有序，如果目标值在左侧范围内，则右界移到中点左侧；反之若中值小于左值则说明右侧有序，若目标值在右侧范围内，则左界移动到中点右侧。若某个中点值等于目标值则说明找到。
    def search(self, nums: [int], target: int) -> int:
        l, r = 0, len(nums)-1
        while l <= r:
            mid = l + (r - l) // 2
            if nums[mid] == target: return mid
            if nums[l] <= nums[mid]:
                if nums[l] <= target <= nums[mid]: r = mid - 1
                else: l = mid + 1
            else:
                if nums[mid] <= target <= nums[r]: l = mid + 1
                else: r = mid - 1
        return -1
                
            
# @lc code=end

