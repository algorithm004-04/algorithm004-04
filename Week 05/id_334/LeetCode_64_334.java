package Algorithms.homework;

//Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
//
// Note: You can only move either down or right at any point in time.
//
// Example:
//
//
//Input:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//Output: 7
//Explanation: Because the path 1→3→1→1→1 minimizes the sum.
//
// Related Topics Array Dynamic Programming



//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_64_334 {
    public int minPathSum(int[][] grid) {
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if(i == grid.length - 1 && j != grid[0].length - 1){
                    grid[i][j] = grid[i][j] +  grid[i][j + 1];
                    continue;
                }
                if(j == grid[0].length - 1 && i != grid.length - 1){
                    grid[i][j] = grid[i][j] + grid[i + 1][j];
                    continue;
                }
                if(j != grid[0].length - 1 && i != grid.length - 1)
                    grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j],grid[i][j + 1]);
            }
        }
        return grid[0][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


