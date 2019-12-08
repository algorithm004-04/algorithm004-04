/*
   DFS 深度优先搜索
*/
void dfs(char **grid,int current_row,int current_column,int row,int column) {
    if (current_row < 0 || current_column < 0 || current_row >= row || current_column >= column || grid[current_row][current_column] == '0') {
        return;
    }
    grid[current_row][current_column] = '0';
    dfs(grid,current_row-1,current_column,row,column);
    dfs(grid,current_row+1,current_column,row,column);
    dfs(grid,current_row,current_column-1,row,column);
    dfs(grid,current_row,current_column+1,row,column);
}

int numIslands(char** grid, int gridSize, int* gridColSize){
    int i,j,row,column,num_islands = 0;
    
    if (gridSize <= 0) {
        return 0;
    }
    
    row = gridSize;
    column = gridColSize[0];
    for (i = 0;i < row;i++) {
        for (j = 0;j < column;j++) {
            if (grid[i][j] == '1') {
                num_islands++;
                dfs(grid,i,j,row,column);
            }
        }
    }
    return num_islands; 
}



