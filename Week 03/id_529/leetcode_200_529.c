/*200. 岛屿数量
给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-islands
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

int dfs(char **grid, int gridSize, int gridColSize, int i, int j) {
    if ((i > gridSize - 1) || (j > gridColSize - 1) || i < 0 || j < 0 || (grid[i][j] == '0')) {
        return 0;
    }
    grid[i][j] = '0';
    dfs(grid, gridSize, gridColSize, i+1, j); 
    dfs(grid, gridSize, gridColSize, i-1, j); 
    dfs(grid, gridSize, gridColSize, i, j+1); 
    dfs(grid, gridSize, gridColSize, i, j-1); 
}
int numIslands(char** grid, int gridSize, int* gridColSize)
{
    int i;
    int count = 0;
    for (i = 0; i < gridSize; i++) {
        for (int j = 0; j < *gridColSize; j++) {
            if (grid[i][j] == '1') {
                dfs(grid, gridSize ,*gridColSize, i, j);
                count++;
            }
        }
    }
    return count;
}