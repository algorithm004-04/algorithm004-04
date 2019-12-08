    private int girdRows;
    private int girdCols;
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0){
            return 0;
        }
        int result=0;
        girdRows=grid.length;
        girdCols=grid[0].length;
        for(int i=0;i<girdRows;i++){
            for (int j=0;j<girdCols;j++){
                if(grid[i][j]=='1'){
                    result++;
                    dfs(grid,i,j);
                }
            }
        }
        return result;

    }

    private void dfs(char[][] grid,int row,int col){
        if(row<0||row>=girdRows||col<0||col>=girdCols||grid[row][col]=='0'){
            return;
        }
        grid[row][col]='0';
        dfs(grid,row-1,col);
        dfs(grid,row+1,col);
        dfs(grid,row,col-1);
        dfs(grid,row,col+1);
    }
