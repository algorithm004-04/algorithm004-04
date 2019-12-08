package algorithm.homework.week05;

public class LeetCode_72_374 {
    public static void main(String[] args) {

    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] res = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; ++i) {
            res[i][0] = i;
        }
        for (int i = 0; i < n + 1; ++i) {
            res[0][i] = i;
        }

        for (int i = 1; i < m + 1; ++i) {
            for (int j = 1; j < n + 1; ++j) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    res[i][j] = Math.min(Math.min(res[i - 1][j] + 1, res[i][j - 1] + 1), res[i - 1][j - 1]);
                } else {
                    res[i][j] = Math.min(Math.min(res[i - 1][j] + 1, res[i][j - 1] + 1), res[i - 1][j - 1] + 1);
                }
            }
        }
        return res[m][n];
    }
}
