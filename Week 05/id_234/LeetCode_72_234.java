package weak_05;

public class LeetCode_72_234 {
  /*
   * 1.构建二维数组dp[][] 初始化第一行第一列 为两个单词字母个数
   *   第一行表示 word1为空 每次操作都是插入操作
   *   第一列表示 word2为空 每次操作都是删除操作
   * 2.如果word1[i] == word2[j] 则 dp[i][j] = dp[i-1][j-1]
   *   如果word1[i] != word2[j] 取 dp[i-1][j-1], dp[i-1][j], dp[i][j-1]中的最小值 并+1
   *   则 dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1])+1
   *
   * */
  public int minDistance(String word1, String word2) {
    int n1 = word1.length();
    int n2 = word2.length();
    int[][] dp = new int[n1 + 1][n2 + 1];
    // 第一行
    for (int j = 1; j <= n2; j++) {
      dp[0][j] = dp[0][j - 1] + 1;
    }
    // 第一列
    for (int i = 1; i <= n1; i++) {
      dp[i][0] = dp[i - 1][0] + 1;
    }

    for (int i = 1; i <= n1; i++) {
      for (int j = 1; j <= n2; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
        }
      }
    }
    return dp[n1][n2];
  }
}
