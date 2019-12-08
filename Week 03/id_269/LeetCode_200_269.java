/*
 * 200. 岛屿数量
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

 * 解题思路
 * floodfill
 *
 * 依次遍历二维数组中的每一个元素，当前元素是1时，说明是陆地，然后根据当前元素位置，上右下左四个方位依次往下进行。知道最后没有陆地为止，一块陆地完成
 * 然后进行第二块陆地寻找
 *
 * 需要辅助的元素
 * 1.
 * */
public class LeetCode_200_269 {

    int[][] d = new int[][]{
            new int[]{0, 1},
            new int[]{1, 0},
            new int[]{0, -1},
            new int[]{-1, 0},

    };

    /**
     * 答案是多少
     */
    int num = 0;

    /**
     * 有多少行
     */
    int m;
    /**
     * 有多少列
     */
    int n;

    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    private void dfs(char[][] grid, int x, int y) {
        if (grid[x][y] == '1') {
            grid[x][y] = '0';
            for (int i = 0; i < 4; i++) {
                int newX = x + d[i][0];
                int newY = y + d[i][1];
                if (isInArea(newX, newY)) {
                    dfs(grid, newX, newY);
                }
            }
        }
    }

    private boolean isInArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
