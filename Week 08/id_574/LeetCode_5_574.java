package SuanFa.Week08;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 *
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Neo
 */
public class LeetCode_5_574 {
    private static int l, maxlen;
    private static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        for (int i = 0; i<len-1; i++) {
            extendPalindrome(s,i,i);    //标在中间
            extendPalindrome(s,i,i+1);  //标在两个字符中间
        }
        return s.substring(l, l + maxlen);
    }

    private static void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k <s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxlen < k - j - 1) {
            l = j + 1;
            maxlen = k - j - 1;
        }
    }

    private static String longestPalindrome1(String s) {
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        for (int i = n-1; i > n; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i+1][j-1]);   //字串长度小于2
                if (dp[i][j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j+1);
                }
            }
        }
        return res;
    }
}
