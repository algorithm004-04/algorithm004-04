#1.先寻找目标在哪一个子数组中，找到后，对这个数组进行二分查找
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]:
            return False
        m = 0
        for i in range(len(matrix)):
            if matrix[i][0] <= target <= matrix[i][-1]:
                m = i
                break
        left = 0
        right = len(matrix[0]) - 1
        while left <= right:
            mid = (left + right) // 2
            if matrix[m][mid] == target:
                return True
            elif matrix[m][mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return False
                


#2.直接将整个二维数组看成一个大的数组，对其使用二分查找，注意获取下标的值时可以采用matrix[mid // 子数组长度]][mid % 子数组长度]
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or target is None:
            return False
        left = 0
        right = len(matrix) * len(matrix[0]) - 1
        while left <= right:
            mid = (left + right) // 2
            if matrix[mid // len(matrix[0])][mid % len(matrix[0])] == target:
                return True
            elif matrix[mid // len(matrix[0])][mid % len(matrix[0])] < target:
                left = mid + 1
            else:
                right = mid - 1
        return False
