#
# @lc app=leetcode.cn id=74 lang=python3
#
# [74] 搜索二维矩阵
#
# https://leetcode-cn.com/problems/search-a-2d-matrix/description/
#
# algorithms
# Medium (35.88%)
# Likes:    96
# Dislikes: 0
# Total Accepted:    20.5K
# Total Submissions: 56.7K
# Testcase Example:  '[[1,3,5,7],[10,11,16,20],[23,30,34,50]]\n3'
#
# 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
# 
# 
# 每行中的整数从左到右按升序排列。
# 每行的第一个整数大于前一行的最后一个整数。
# 
# 
# 示例 1:
# 
# 输入:
# matrix = [
# ⁠ [1,   3,  5,  7],
# ⁠ [10, 11, 16, 20],
# ⁠ [23, 30, 34, 50]
# ]
# target = 3
# 输出: true
# 
# 
# 示例 2:
# 
# 输入:
# matrix = [
# ⁠ [1,   3,  5,  7],
# ⁠ [10, 11, 16, 20],
# ⁠ [23, 30, 34, 50]
# ]
# target = 13
# 输出: false
# 
#

# @lc code=start
class Solution:
    # 先二分查找所在的行，再二分查找所在行的位置
    # def searchMatrix(self, matrix: [[int]], target: int) -> bool:
    #     if not matrix or not matrix[0]: return False
    #     col, rowl, colH, rowH = 0, 0, len(matrix) - 1, len(matrix[0]) - 1
    #     if target < matrix[0][0] and target > matrix[colH][rowH]: return False
    #     while col < colH:
    #         mid = col + (colH - col) // 2
    #         if matrix[mid][0] <= target <= matrix[mid][rowH]:
    #             col = colH = mid
    #             break 
    #         if matrix[mid][0] > target: colH = mid - 1
    #         if matrix[mid][rowH] < target: col = mid + 1
        
    #     while rowl <= rowH:
    #         mid = rowl + (rowH - rowl) // 2
    #         if matrix[col][mid] == target: return True
    #         if matrix[col][mid] > target: rowH = mid - 1
    #         if matrix[col][mid] < target: rowl = mid + 1
    #     return False

    # 二维坐标一维化
    def searchMatrix(self, matrix: [[int]], target: int) -> bool:
        m = len(matrix)
        if not m: return False
        n = len(matrix[0])
        if not n: return False

        l, r = 0, m*n - 1
        while l <= r:
            mid = l + (r - l) // 2
            midNum = matrix[mid // n][mid % n]
            if target == midNum: return True
            if target < midNum: r = mid - 1
            if target > midNum: l = mid + 1
        return False


# @lc code=end

