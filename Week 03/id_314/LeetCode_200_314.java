//Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//
// Example 1:
//
//
//Input:
//11110
//11010
//11000
//00000
//
//Output: 1
//
//
// Example 2:
//
//
//Input:
//11000
//11000
//00100
//00011
//
//Output: 3
// Related Topics Depth-first Search Breadth-first Search Union Find


public class LeetCode_200_314 {
    public int numIslands(char[][] grid) {

        int nums = 0;
        if (grid == null || grid.length == 0) {
            return nums;
        }


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    nums += dfsIsland(grid, i, j);
                }
            }
        }

        return nums;

    }


    private int dfsIsland(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return 0;
        }

        grid[i][j] = '0';

        dfsIsland(grid, i - 1, j);
        dfsIsland(grid, i + 1, j);
        dfsIsland(grid, i, j - 1);
        dfsIsland(grid, i, j + 1);

        return 1;
    }
}

