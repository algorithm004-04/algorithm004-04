# coding=utf-8

"""
编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

    每行中的整数从左到右按升序排列。
    每行的第一个整数大于前一行的最后一个整数。

示例 1:

输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
输出: true

示例 2:

输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-a-2d-matrix
"""
from typing import List


class Solution:
    # 二分查找
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        """
        矩阵有序；
        二分查找；

        :param matrix: 矩阵
        :param target: 目标值
        :return: 是否存在目标值
        """
        m = len(matrix)
        if not m:
            return False
        n = len(matrix[0])
        if not n:
            return False
        left = 0
        right = m * n - 1
        while left <= right:
            mid = (left + right) // 2
            _value = matrix[mid // n][mid % n]
            if _value == target:
                return True
            elif _value < target:
                left = mid + 1
            else:
                right = mid - 1
        return False


if __name__ == '__main__':
    test_params = [
        [
            [
                [1, 3, 5, 7],
                [10, 11, 16, 20],
                [23, 30, 34, 50]
            ],
            3,
            True
        ],
        [
            [
                [1, 3, 5, 7],
                [10, 11, 16, 20],
                [23, 30, 34, 50]
            ],
            13,
            False
        ]
    ]
    sol = Solution()
    for param_tuple in test_params:
        assert sol.searchMatrix(param_tuple[0], param_tuple[1]) == param_tuple[2]
