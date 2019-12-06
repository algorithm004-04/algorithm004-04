#
# @lc app=leetcode.cn id=56 lang=python3
#
# [56] 合并区间
#
# https://leetcode-cn.com/problems/merge-intervals/description/
#
# algorithms
# Medium (38.86%)
# Likes:    217
# Dislikes: 0
# Total Accepted:    39.5K
# Total Submissions: 100.5K
# Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
#
# 给出一个区间的集合，请合并所有重叠的区间。
# 
# 示例 1:
# 
# 输入: [[1,3],[2,6],[8,10],[15,18]]
# 输出: [[1,6],[8,10],[15,18]]
# 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
# 
# 
# 示例 2:
# 
# 输入: [[1,4],[4,5]]
# 输出: [[1,5]]
# 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
# 
#

# @lc code=start
class Solution:
    def merge(self, intervals: [[int]]) -> [[int]]:
        def mergeArr(l, mid, r):
            i, j, temp = l, mid + 1, []
            while i <= mid and j <= r:
                if intervals[i][0] <= intervals[j][0]: 
                    temp.append(intervals[i]); i += 1
                else:
                    temp.append(intervals[j]); j += 1
            if i <= mid: temp += intervals[i:mid+1]
            if j <= r: temp += intervals[j:r+1]
            intervals[l:r+1] = temp

        def mergeSort(l=0, r=len(intervals)-1):
            if l >= r: return
            mid = l + (r - l) // 2
            mergeSort(l, mid)
            mergeSort(mid + 1, r)
            mergeArr(l, mid, r)
        
        mergeSort()

        res = []
        for item in intervals:
            if not res or res[-1][-1] < item[0]: res.append(item)
            else: res[-1][-1] = max(item[-1], res[-1][-1])
        return res

    # def merge(self, intervals: [[int]]) -> [[int]]:
    #     intervals.sort()
    #     res = []
    #     for item in intervals:
    #         if not res or res[-1][-1] < item[0]: res.append(item)
    #         else: res[-1][-1] = max(item[-1], res[-1][-1])
                
    #     return res


# print(Solution().merge([[1,3],[2,6],[8,10],[15,18]]))
# @lc code=end

