class Solution {
    

    public int minPathSum(int[][] grid) {
    
        int M = grid[0].length;
        int N = grid.length;
        
        
        for(int i=0;i<N;i++){
                
            for(int j=0;j<M;j++){
                
               if(i==0&&j==0){
                   continue;
               }           
               
                if(i==0&&j>0){
                    
                    grid[0][j] += grid[0][j-1];
                    continue;
                }    
                
                 if(j==0&&i>0){
                    
                    grid[i][0] += grid[i-1][0];
                    continue;
                  }   
                
                grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
                
                
            }    
            
            
        }
        
        return grid[N-1][M-1];
        
        
    }
}
