package SuanFa.Week08;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 *
 *
 * 两个字符串完全匹配才算匹配成功。
 *
 * 说明:
 *
 *
 * 	s 可能为空，且只包含从 a-z 的小写字母。
 * 	p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 *
 *
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 *
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 *
 *
 * 示例 3:
 *
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 *
 *
 * 示例 4:
 *
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 *
 *
 * 示例 5:
 *
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输入: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wildcard-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Neo
 */
public class LeetCode_44_574 {
    private static boolean isMatch(String s,String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] f = new boolean[m+1][n+1];
        f[0][0] = true;
        for (int i=0;i<n;i++) {
            f[0][i] = f[0][i-1] && p.charAt(i-1) == '*';
        }
        for (int i = 1; i<=m; i++) {
            for (int j =1; i<=n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j-1) == '?') {
                    f[i][j] = f[i-1][j-1];
                }
                if (p.charAt(j-1) == '*') {
                    f[i][j] = f[i][j-1] || f[i-1][j];
                }
            }
        }
        return f[m][n];
    }
}
