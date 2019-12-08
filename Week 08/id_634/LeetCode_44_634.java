class Solution {
    
    //1.DFS
    public boolean isMatch(String s, String p) {
        int[][] memo = new int[s.length()][p.length()];
        return helper(s, p, 0, 0, memo);
    }
    
    private boolean helper(String s, String p, int i, int j, int[][] memo) {
        if (i == s.length() && j == p.length()) return true;
        if (j == p.length()) return false;
        if (i < s.length() && memo[i][j] != 0) return memo[i][j] == 1 ? true : false;
        int pchr = p.charAt(j);
        if (i == s.length() && pchr != '*') return false;
        
        if(pchr == '?') {
            return helper(s, p, i + 1, j + 1, memo);
        } else if (pchr == '*') {
            while(i <= s.length()) {
                boolean flag = helper(s, p, i, j + 1, memo);
                if(i < s.length() && j + 1 < p.length()) memo[i][j] = flag ? 1 : 2;
                if(flag)return true;
                i++;
            }
            return false;
        } else {
            return pchr == s.charAt(i) && helper(s, p, i + 1, j + 1, memo);
        }
    }
        
    //2.DP
    // public boolean isMatch(String s, String p) {
    //     int m = s.length(), n = p.length();
    //     boolean [][] dp = new boolean[s.length()+1][p.length()+1];
    //     dp[0][0] = true;
    //     for (int i = 1; i <= n; ++i) {
    //         if (p.charAt(i - 1) == '*') dp[0][i] = dp[0][i - 1];
    //     }
    //     for (int i = 1; i <= m; ++i) {
    //         for (int j = 1; j <= n; ++j) {
    //             if (p.charAt(j - 1) == '*') {
    //                 dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
    //             } else {
    //                 dp[i][j] = (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') && dp[i - 1][j - 1];
    //             }
    //         }
    //     }
    //     return dp[m][n];
    // }
    
    //3.遍历
    // public boolean isMatch(String s, String p) {
    //     int i = 0, j = 0, iStar = -1, jStar = -1, m = s.length(), n = p.length();
    //     while (i < m) {
    //         if (j < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
    //             ++i; ++j;
    //         } else if (j < n && p.charAt(j) == '*') {
    //             iStar = i;
    //             jStar = j++;
    //         } else if (iStar >= 0) {
    //             i = ++iStar;
    //             j = jStar + 1;
    //         } else return false;
    //     }
    //     while (j < n && p.charAt(j) == '*') ++j;
    //     return j == n;
    // }
    
}