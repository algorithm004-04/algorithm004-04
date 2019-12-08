package algorithm.dp;

public class LeetCode_62_374 {
    public static void main(String[] args) {
        LeetCode_62_374 leetCode_62_374 = new LeetCode_62_374();
        System.out.println(leetCode_62_374.uniquePaths(3, 2));
    }

    /**
     * 1.重复子问题：res[m][n] = res[m][n+1] + res[m+1][n]
     * 2.状态存储：res[][]
     * 3.递推公式：res[m][n] = res[m-1][n] + res[n-1][m]
     */

    public int uniquePaths(int m, int n) {

        int[][] res = new int[m][n];
        for (int i = 0; i < m; ++i) {
            res[i][n - 1] = 1;
        }
        for (int i = 0; i < n; ++i) {
            res[m - 1][i] = 1;
        }
        for (int i = m - 2; i >= 0; --i) {
            for (int j = n - 2; j >= 0; --j) {
                res[i][j] = res[i][j + 1] + res[i + 1][j];
            }
        }
        return res[0][0];
    }
}
