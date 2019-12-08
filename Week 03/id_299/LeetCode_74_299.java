package algorithm;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_74_299 {
    public static  boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1; // 二维数组当成一位数组
        int midIndex,midValue;
        while (left <= right){
            midIndex = (left + right) >>> 1;
            midValue = matrix[midIndex / n][midIndex % n];
            if (target == midValue) {
                return true;
            } else if(target < midValue){
                right = midIndex - 1;
            }else {
                left = midIndex + 1;
            }
        }

        return false;
    };

    public static void main(String[] args) {
        int[][] array = new int[][]{
            {1,3,5,7},
            {10,11,16,20},
            {23,30,34,50}
        };
        boolean i = LeetCode_74_299.searchMatrix(array,3);
        System.out.println("i--------->"+i);
    }
}
