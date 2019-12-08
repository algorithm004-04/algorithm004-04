package algorithm;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_64_299 {
    public static void main(String[] args) {
        int[][] path = {
            {1,3,1},
            {1,4,1},
            {4,2,1},
        };
        int min = minPathSum(path);
        System.out.println("最小路径----->"+min);
    }
    public static int minPathSum(int[][] grid) {
        // 定义状态数组
        int[][] dp = grid;
        // DP方程 自底向上
        for (int i = dp.length -1;i >= 0;i--){
            for(int j = dp[0].length -1; j>=0;j--){
                // 分解子问题 从最后一步起
                if(i == dp.length-1 && j != dp[0].length -1){
                    dp[i][j] = dp[i][j] + dp[i][j+1]; // 累加数字
                } else if(j == dp[0].length -1 && i != dp.length -1){
                    dp[i][j] = dp[i][j] + dp[i+1][j];
                } else if(j != dp[0].length -1 && i != dp.length -1){
                    dp[i][j] = dp[i][j] + Math.min(dp[i+1][j],dp[i][j+1]);
                }
            }
        }

        return dp[0][0];
    }
}
