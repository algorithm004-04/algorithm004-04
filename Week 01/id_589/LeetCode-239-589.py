#
# @lc app=leetcode.cn id=239 lang=python3
#
# [239] 滑动窗口最大值
#
# https://leetcode-cn.com/problems/sliding-window-maximum/description/
#
# algorithms
# Hard (42.73%)
# Likes:    167
# Dislikes: 0
# Total Accepted:    18.8K
# Total Submissions: 43.9K
# Testcase Example:  '[1,3,-1,-3,5,3,6,7]\n3'
#
# 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k
# 个数字。滑动窗口每次只向右移动一位。
# 
# 返回滑动窗口中的最大值。
# 
# 
# 
# 示例:
# 
# 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
# 输出: [3,3,5,5,6,7] 
# 解释: 
# 
# ⁠ 滑动窗口的位置                最大值
# ---------------               -----
# [1  3  -1] -3  5  3  6  7       3
# ⁠1 [3  -1  -3] 5  3  6  7       3
# ⁠1  3 [-1  -3  5] 3  6  7       5
# ⁠1  3  -1 [-3  5  3] 6  7       5
# ⁠1  3  -1  -3 [5  3  6] 7       6
# ⁠1  3  -1  -3  5 [3  6  7]      7
# 
# 
# 
# 提示：
# 
# 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
# 
# 
# 
# 进阶：
# 
# 你能在线性时间复杂度内解决此题吗？
# 
#

# @lc code=start
from collections import deque
class Solution:
    # 方法一：暴力法
    # 最简单直接的方法是遍历每个滑动窗口，找到每个窗口的最大值。
    # 一共有 N - k + 1 个滑动窗口，每个有 k 个元素，于是算法的时间复杂度为 {O}(N k)O(Nk)，表现较差。
    def maxSlidingWindow1(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        if n * k == 0:
            return []

        return [max(nums[i:i+k]) for i in range(n - k + 1)]

    # 方法二：双向队列

    # 直觉
    # 如何优化时间复杂度呢？首先想到的是使用堆，因为在最大堆中 heap[0] 永远是最大的元素。
    # 在大小为 k 的堆中插入一个元素消耗 \log(k)log(k) 时间，因此算法的时间复杂度为 {O}(N \log(k))O(Nlog(k))。
    # 能否得到只要 {O}(N)O(N) 的算法？
    # 我们可以使用双向队列，该数据结构可以从两端以常数时间压入/弹出元素。
    # 存储双向队列的索引比存储元素更方便，因为两者都能在数组解析中使用。

    # 算法非常直截了当：
    # 处理前 k 个元素，初始化双向队列。
    # 遍历整个数组。在每一步 :
    # 清理双向队列 :
    #   - 只保留当前滑动窗口中有的元素的索引。
    #   - 移除比当前元素小的所有元素，它们不可能是最大的。
    # 将当前元素添加到双向队列中。
    # 将 deque[0] 添加到输出中。
    # 返回输出数组。
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        # base cases
        n = len(nums)
        if n * k == 0:
            return []
        if k == 1:
            return nums
        
        def clean_deque(i):
            # remove indexes of elements not from sliding window
            if deq and deq[0] == i - k:
                deq.popleft()                
            # remove from deq indexes of all elements 
            # which are smaller than current element nums[i]
            while deq and nums[i] > nums[deq[-1]]:
                deq.pop()
        
        # init deque and result，
        # Note: deque only save the store the index, not the value
        # Note: result save the value
        deq = deque()
        max_idx = 0
        for i in range(k):
            clean_deque(i)
            deq.append(i)
            # compute max in nums[:k]
            if nums[i] > nums[max_idx]:
                max_idx = i
        result = [nums[max_idx]]
        
        # build result
        for i in range(k, n):
            clean_deque(i)          
            deq.append(i)
            result.append(nums[deq[0]])
        return result

    # 双端队列详细说明版
    def maxSlidingWindow3(self, nums: List[int], k: int) -> List[int]:
        # Checking for base case
        if not nums:
            return []
        if k == 0:
            return nums
        # Defining Deque and result list
        deq = deque()
        result = []
        
        # First traversing through K in the nums and only adding maximum value's index to the deque.
        # Note: We are only storing the index and not the value.
        # Now, Comparing the new value in the nums with the last index value from deque,
        # and if new valus is less, we don't need it
        for i in range(k):
            while len(deq) != 0:
                if nums[i] > nums[deq[-1]]:
                    deq.pop()
                else:
                    break
            deq.append(i)
            
        # Here we will have deque with index of maximum element for the first subsequence of length k.	
        # Now we will traverse from k to the end of array and do 4 things
        # 1. Appending left most indexed value to the result
        # 2. Checking if left most is still in the range of k (so it only allows valid sub sequence)
        # 3. Checking if right most indexed element in deque is less than the new element found, if yes we will remove it
        # 4. Append i at the end of the deque  (Not: 3rd and 4th steps are similar to previous for loop) 
        for i in range(k, len(nums)):
            result.append(nums[deq[0]])           
            if deq[0] < i - k + 1: # if the deque's first index is not the left most of ranctangle, remove it 
                deq.popleft()           
            while len(deq) != 0:
                if nums[i] > nums[deq[-1]]:
                    deq.pop()
                else:
                    break           
            deq.append(i)
        
        #Adding the maximum for last subsequence
        result.append(nums[deq[0]])

        return result
    

# @lc code=end

