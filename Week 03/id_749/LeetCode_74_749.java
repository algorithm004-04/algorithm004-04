public class Solution {
 public boolean searchMatrix(int[][] matrix, int target){
        if(matrix.length == 0) return false;
        int top = 0;
        int down = matrix.length - 1;
        int col = matrix[0].length - 1;
        while(top <= down){
            int mid = (top + down) / 2;
            //it takes O(logM) to find the row that has target
            if(matrix[mid][0] <= target && matrix[mid][col] >= target){
                return searchRow(matrix,mid,target); //O(logN)
            }
            if(matrix[mid][col] < target){
                top = mid + 1;
            }
            if(matrix[mid][0] > target){
                down = mid -1;
            }
        }
        return false;
    }
    
    public boolean searchRow(int[][] matrix, int rowIndex, int target){
        int left = 0;
        int right = matrix[rowIndex].length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(matrix[rowIndex][mid] < target){
                left = mid + 1;
            }else if(matrix[rowIndex][mid] > target){
                right = mid - 1;
            }else{
                return true;
            }
        }
        return false;
    }
}