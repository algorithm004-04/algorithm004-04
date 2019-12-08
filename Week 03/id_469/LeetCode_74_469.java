/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0)
            return false;
        int n = matrix[0].length;

        // 二分查找
        int left = 0, right = m * n - 1;
        int pivotIdx, pivotElement;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement)
                return true;
            else {
                if (target < pivotElement)
                    right = pivotIdx - 1;
                else
                    left = pivotIdx + 1;
            }
        }
        return false;

        //
        // int midMArrayIndex = matrix.length % 2 > 0 ? matrix.length / 2 + 1 :
        // matrix.length / 2;
        // int[] midMArrayValue = matrix[midMArrayIndex];

        // int midNArrayIndex = midMArrayValue.length % 2 > 0 ? midMArrayValue.length /
        // 2 + 1 : midMArrayValue.length / 2;
        // int midNArrayValue = midMArrayValue[midMArrayIndex];

        // int maxValue = matrix[matrix.length - 1][matrix[matrix.length - 1].length -
        // 1];
        // if (target > maxValue) {
        // return false;
        // }

        // if (target == midNArrayValue) {
        // return true;
        // } else if (target == midMArrayValue[midMArrayValue.length - 1]) {
        // return true;
        // } else if (midNArrayValue < target && target <
        // midMArrayValue[midMArrayValue.length - 1]) {
        // // TODO:
        // } else if (target > midMArrayValue[midMArrayValue.length - 1]) {
        // // TODO:
        // }

        // while (target <= mid) {

        // }

    }
}
// @lc code=end
