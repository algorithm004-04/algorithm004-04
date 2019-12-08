package algorithm.chapter4.first.homework;

/**
 * 【64. 最小路径和】给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。 示例: 输入: [   [1,3,1], [1,5,1], [4,2,1] ] 输出: 7 解释: 因为路径
 * 1→3→1→1→1 的总和最小。 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class LeetCode_64_519 {
	public int minPathSum(int[][] grid) {
		if (null != grid) {
			int m = grid.length;// 行
			int n = grid[0].length;// 列
			int[][] dp = new int[m][n];
			dp[m-1][n - 1]= grid[m-1][n - 1];
			// 初始化 最后一列
			for (int i = m - 2; i >= 0; i--) {
				dp[i][n - 1] = grid[i][n - 1] + dp[i + 1][n - 1];
			}
			for (int i = n - 2; i >= 0; i--) {
				dp[m - 1][i] = grid[m - 1][i] + dp[m - 1][i + 1];
			}
			for (int i = m - 2; i >= 0; i--) {
				for (int j = n - 2; j >= 0; j--) {
					dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
				}
			}
			return dp[0][0];
		}
		return 0;
	}

	public static void main(String[] args) {
		LeetCode_64_519 a = new LeetCode_64_519();
		int[][] grid = new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		System.out.println(a.minPathSum(grid));
	}
}
