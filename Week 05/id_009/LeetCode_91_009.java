/**
 * https://leetcode-cn.com/problems/decode-ways
 */
public class LeetCode_91_009 {
    public static void main(String[] args) {
        LeetCode_91_009 test = new LeetCode_91_009();
        String s = "17";

        System.out.println(test.numDecodings3(s));
    }

    /**
     * 方法一：递归
     * 12113的解码方法总数  为 1：21113 和 12：1113 两种情况的总和。
     *
     * @param s
     * @return
     */
    public int numDecodings1(String s) {
        return recursive1(s, 0);
    }

    public int recursive1(String s, int start) {
        if (start == s.length()) {
            return 1;
        }

        if (s.charAt(start) == '0') {
            return 0;
        }

        int res1 = recursive1(s, start + 1);
        int res2 = 0;
        if (start < s.length() - 1) {
            int one = (int) s.charAt(start) - '0';
            int two = (int) s.charAt(start + 1) - '0';
            if (one * 10 + two <= 26) {
                res2 = recursive1(s, start + 2);
            }
        }
        return res1 + res2;
    }


    /**
     * 方法二：递归（记忆数组）
     *
     * @param s
     * @return
     */
    public int numDecodings2(String s) {
        Integer[] memo = new Integer[s.length()];
        return recursive2(s, 0, memo);
    }

    public int recursive2(String s, int start, Integer[] memo) {
        if (start == s.length()) {
            memo[s.length() - 1] = 1;
            return 1;
        }

        if (s.charAt(start) == '0') {
            return 0;
        }

        if (memo[start] != null) {
            return memo[start];
        }

        int res1 = recursive2(s, start + 1, memo);
        int res2 = 0;
        if (start < s.length() - 1) {
            int one = (int) s.charAt(start) - '0';
            int two = (int) s.charAt(start + 1) - '0';
            if (one * 10 + two <= 26) {
                res2 = recursive2(s, start + 2, memo);
            }
        }
        return res1 + res2;
    }


    /**
     * 动态规划：dp[i] = dp[i-1] + dp[i-2]
     * 合法性判断：若当前解码1位，则该位不可为0；若当前解码2位，则首位为1或首位为2 && 次位<7
     * tips：dp数组多一位，方便边界条件的处理
     *
     * @param s
     * @return
     */
    public int numDecodings3(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;    //dp数组多一位，方便边界条件的处理
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i < n + 1; i++) {
            dp[i] = s.charAt(i - 1) == '0' ? 0 : dp[i - 1];
            if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7')) {
                dp[i] = dp[i] + dp[i - 2];
            }
        }

        return dp[n];

    }

}

