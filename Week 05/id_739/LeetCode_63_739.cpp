class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int w = obstacleGrid.size();
        if(w == 0 || obstacleGrid[0][0] == 1) return 0;
        int h = obstacleGrid[0].size();
        
        long long dp[w][h];
        dp[0][0] = 1;
        for(int i = 1; i < w; i++) dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i - 1][0];
        for(int j = 1; j < h; j++) dp[0][j] = obstacleGrid[0][j] == 1 ? 0 : dp[0][j - 1];
        
        for(int i = 1; i < w; i++){
            for(int j = 1; j < h; j++){
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[w - 1][h - 1];
    }
};
