package medium;

public class LC115 {
    public int numDistinct(String s, String t) {
        int s_len = s.length();
        int t_len = t.length();
        int[][] dp = new int[s_len + 1][t_len + 1];
        //当 T 为空串时，所有的 s 对应于 1
        for (int i = 0; i <= s_len; i++) {
            dp[i][t_len] = 1;
        }

        //倒着进行，T 每次增加一个字母
        for (int t_i = t_len - 1; t_i >= 0; t_i--) {
            dp[s_len][t_i] = 0; // 这句可以省去，因为默认值是 0
            //倒着进行，S 每次增加一个字母
            for (int s_i = s_len - 1; s_i >= 0; s_i--) {
                //如果当前字母相等
                if (t.charAt(t_i) == s.charAt(s_i)) {
                    //对应于两种情况，选择当前字母和不选择当前字母
                    dp[s_i][t_i] = dp[s_i + 1][t_i + 1] + dp[s_i + 1][t_i];
                    //如果当前字母不相等
                } else {
                    dp[s_i][t_i] = dp[s_i + 1][t_i];
                }
            }
        }
        return dp[0][0];
    }

}
