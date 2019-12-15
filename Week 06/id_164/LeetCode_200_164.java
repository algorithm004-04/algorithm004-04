/**
 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

 示例 1:

 输入:
 11110
 11010
 11000
 00000

 输出: 1
 *
 */
class Solution {
    public int numIslands(char[][] grid) {
        if (null == grid || grid.length == 0) {
            return 0;
        }

        int total = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (grid[row][column] == '1') {
                    total++;
                    dealGrid(grid, row, column);
                }
            }
        }

        return total;
    }

    void dealGrid(char[][] grid, int row, int column) {
        if (row < 0
                || column < 0
                || row >=  grid.length
                || column >= grid[0].length
                || grid[row][column] == '0') {
            return;
        }

        grid[row][column] = '0';
        dealGrid(grid, row - 1, column);
        dealGrid(grid, row + 1, column);
        dealGrid(grid, row, column - 1);
        dealGrid(grid, row, column + 1);
    }
}
