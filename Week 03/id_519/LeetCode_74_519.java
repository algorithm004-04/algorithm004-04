package algorithm.chapter3.first.binarysearch;

/**
 * 【74. 搜索二维矩阵】编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。 示例 1: 输入: matrix = [ [1, 3, 5, 7], [10, 11, 16, 20],
 * [23, 30, 34, 50] ] target = 3 输出: true 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class LeetCode_74_519 {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (null != matrix && matrix.length > 0) {
			int m = matrix.length;
			int n = matrix[0].length;
			int begin = 0;
			int end = m * n - 1;
			while (begin <= end) {
				int mid = (begin + end) / 2;
				int x = mid / n;
				int y = mid % n;
				if (matrix[x][y] == target) {
					return true;
				}
				if (matrix[x][y] > target) {
					end = mid - 1;
				} else {
					begin = mid + 1;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		LeetCode_74_519 a = new LeetCode_74_519();
		int[][] matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };

		System.out.println(a.searchMatrix(matrix, 55));
	}
}
