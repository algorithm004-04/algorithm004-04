from typing import List
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> int:
        m = len(matrix)
        if m == 0:
            return False
        n = len(matrix[0])
        left, right = 0, m * n - 1
        while left <= right:
            pivot_idx = (left + right) // 2
            pivot_element = matrix[pivot_idx // n][pivot_idx % n]
            if target == pivot_element:
                return True
            else:
                if target < pivot_element:
                    right = pivot_idx - 1
                else:
                    left = pivot_idx + 1
        return False


if __name__ == '__main__':
    solution = Solution()
    print(solution.searchMatrix([
                                [1,   3,  5,  7],
                                [10, 11, 16, 20],
                                [23, 30, 34, 50]], 3))