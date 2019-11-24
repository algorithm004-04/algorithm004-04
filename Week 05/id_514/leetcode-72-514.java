class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] a = new int[n1 + 1][n2 + 1];
        for (int j = 1; j <= n2; j++) a[0][j] = a[0][j - 1] + 1;
        for (int i = 1; i <= n1; i++) a[i][0] = a[i - 1][0] + 1;
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) a[i][j] = a[i - 1][j - 1];
                else a[i][j] = Math.min(Math.min(a[i - 1][j - 1], a[i][j - 1]), a[i - 1][j]) + 1;
            }
        }
        return a[n1][n2];  
    }
}