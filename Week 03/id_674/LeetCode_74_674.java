//1.找规律，首先此二维数组是有序的，我们可以从右上角开始查找，每次只需要左移或下移即可，也就是row++或col--；
//2.初始化右上角数字下标的指针常量，如果target等于当前数则return true，如果大于右上角的数字，那么target肯定不在当前行，row++，省去了一行的比较，如果target小于右上角的数字，则target肯定不在当前列，那么col++即可。

class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0)
			return false;

		int row = 0, col = matrix[0].length - 1;
		while (row < matrix.length && col >= 0) {
			if (target == matrix[row][col])
				return true;
			else if (target > matrix[row][col])
				row++;
			else
				col--;
		}
		return false;

	}
}

//2. 方法：二分查找
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

    }
}