package week03;

/**74
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
public class searchmartrix {
    public static void main(String[] args) {
        //int[][] matrix = new int[][] {{1,3,5,7,9},{10,11,16,20},{23,30,34,50}};
        int[][] matrix = new int[][] {{1}};
        int target = 2;
        boolean res= searchMatrix(matrix,target);
        System.out.println(res);

    }

    //  最直观的两次二分
    public static boolean searchMatrix_bin(int[][] matrix, int target) {
        int left=0, right=matrix.length-1;
        if(right < 0 ) return false;
        if(matrix[0].length ==0) return false;
        while(left <= right) {
            int mid = (left + right) /2;
            if(target < matrix[mid][0])
                right = mid-1;
            else{
                if(target >matrix[mid][matrix[mid].length-1])
                    left = mid+1 ;
                else {
                    //System.out.println(matrix[mid]);
                    System.out.println(mid);
                    if (binsearch(matrix[mid], target))
                        return true;
                    else
                        return false;
                }
            }
            //System.out.println(mid);
        }
        return false;
    }
    public static boolean binsearch(int[] list_res,int target) {
        int left=0,right =list_res.length-1;
        int mid =0;
        while(left <= right) {
            mid = (left + right) /2 ;

            if(target == list_res[mid])
                return true;

            if(target > list_res[mid])
                left = mid+1;
            if(target < list_res[mid])
                right = mid-1;

        }
        return false;
    }
    // take it as 1d sorted list
    public static boolean searchMatrix(int[][] matrix, int target) {
        int start=0;
        int row =matrix.length;
        if(row < 1 ) return false;
        int col = matrix[0].length;
        if(col ==0) return false;
        int end = row * col -1;
        while(start <= end) {
            int mid = (start + end) /2;

            if(matrix[mid/col][mid%col] == target)
                return true;
            if(matrix[mid/col][mid%col] > target)
                end = mid -1;
            if(matrix[mid/col][mid%col] < target)
                start = mid +1;
        }
        return false;
    }



}
