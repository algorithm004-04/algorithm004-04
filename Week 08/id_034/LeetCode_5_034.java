/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */

/**
 * LeetCode_5_034
 *
 * @Author mengdebiao@duxiaoman.com
 * @Date 2019/12/8 7:17 PM
 **/
public class LeetCode_5_034 {

    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i --) {
            for (int j = i; j < n; j ++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}
