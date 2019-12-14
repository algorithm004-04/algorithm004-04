class Solution {
    public int maximalSquare(char[][] matrix) {
        // base condition
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;

        int height = matrix.length;
        int width = matrix[0].length;
        int maxSide = 0;

        // 相当于已经预处理新增第一行、第一列均为0
//        int[][] dp = new int[height + 1][width + 1];
        int[] dp = new int[width + 1];
        int northwest = 0; // 西北角、左上角

//        for (int row = 0; row < height; row++) {
        for (char[] chars : matrix) {
            for (int col = 0; col < width; col++) {
                int nextNorthwest = dp[col + 1];
                if (chars[col] == '1') {
//                    dp[row + 1][col + 1] = Math.min(Math.min(dp[row + 1][col], dp[row][col + 1]), dp[row][col]) + 1;
                    dp[col + 1] = Math.min(Math.min(dp[col], dp[col + 1]), northwest) + 1;

//                    maxSide = Math.max(maxSide, dp[row + 1][col + 1]);
                    maxSide = Math.max(maxSide, dp[col + 1]);
                } else {
                    dp[col + 1] = 0;
                }
                northwest = nextNorthwest;
            }
        }
        return maxSide * maxSide;
    }
}