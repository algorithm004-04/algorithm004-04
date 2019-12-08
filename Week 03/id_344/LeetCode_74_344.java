class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        int middle = 0;
        int result = 0;
        while(left <= right) {
            middle = (left + right) / 2;
            result = matrix[middle / n][middle % n];
            if (target == result) {
                return true;
            } else if (target < result) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return false;
    }

}