package id_429;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 来源：https://leetcode-cn.com/problems/search-a-2d-matrix
 *
 * @author liqiuying
 * @date 2019-11-03
 */
public class LeetCode_74_429 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        //1.判断tarhet在哪个一维数组
        //2.二分查找其是否在数组中
        if (matrix == null || matrix.length == 0 || (matrix.length == 1 && matrix[0].length == 0)) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (target > matrix[i][matrix[i].length - 1]) {
                continue;
            }
            for (int j = 0; j < matrix[i].length; j++) {
                if (binarySearch(matrix[i], target)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        while (left <= right) {
            if (nums[mid] == target) {
                return true;
            }
            //在mid左侧
            if (target <= nums[mid]) {
                right = mid - 1;
            } else {
                //在mid右侧
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(searchMatrix(nums, 3));
    }
}