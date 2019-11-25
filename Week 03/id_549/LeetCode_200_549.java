//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
//
// 示例 1:
//
// 输入:
//11110
//11010
//11000
//00000
//
//输出: 1
//
//
// 示例 2:
//
// 输入:
//11000
//11000
//00100
//00011
//
//输出: 3
//
// Related Topics 深度优先搜索 广度优先搜索 并查集

class Solution {
    public int numIslands(char[][] grid) {

        if(grid.length == 0) {
            return 0;
        }

        int xlen = grid.length;
        int ylen = grid[0].length;
        int islandNums = 0 ;
        for(int i = 0;i < xlen;i++) {
            for(int j =0;j < ylen;j++) {

                if(grid[i][j] == '1') {
                    islandNums++;

                    dfs(grid,i,j);
                }

            }
        }

        return islandNums;
    }

    private void dfs(char[][] grid, int x, int y) {

        int xlen = grid.length;
        int ylen = grid[0].length;
        if(x < 0 || y < 0 || x >= xlen || y >= ylen || grid[x][y] == '0') {
            return;
        }

        grid[x][y] = '0';

        dfs(grid,x-1,y);
        dfs(grid,x+1,y);
        dfs(grid,x,y-1);
        dfs(grid,x,y+1);


    }
}