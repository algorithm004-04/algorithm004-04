/*
 * @lc app=leetcode.cn id=64 lang=cpp
 *
 * [64] 最小路径和
 */

// @lc code=start

#include <iostream>
#include <algorithm>
#include <stack>
#include <vector>

using namespace std;

/*
    方法一: 动态规划

 	时间复杂度：O(m*n)
 	空间复杂度：O(1)

*/

class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        vector<int> cur(m, grid[0][0]);

        for (int i = 1; i < m; i++)
            cur[i] = cur[i - 1] + grid[i][0]; 

        for (int j = 1; j < n; j++) {
            cur[0] += grid[0][j]; 
            for (int i = 1; i < m; i++)
                cur[i] = min(cur[i - 1], cur[i]) + grid[i][j];
        }

        return cur[m - 1]; 
    }
};
// @lc code=end

