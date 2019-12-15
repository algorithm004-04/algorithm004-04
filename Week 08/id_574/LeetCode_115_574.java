package SuanFa.Week08;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
 *
 * 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 * 示例 1:
 *
 * 输入: S = "rabbbit", T = "rabbit"
 * 输出: 3
 * 解释:
 *
 * 如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 *
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 *
 *
 * 示例 2:
 *
 * 输入: S = "babgbag", T = "bag"
 * 输出: 5
 * 解释:
 *
 * 如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 *
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 *   ^  ^^
 * babgbag
 *     ^^^
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distinct-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Neo
 */
public class LeetCode_115_574 {

    // 选它还是不选它,Neo:第一想法是想到这个方法，DP功力不够 哈哈
    private static int numDistinct(String s, String t) {
        HashMap<String,Integer> map = new HashMap<>();  //缓存一下
        return numDistinctHelper(s,0,t,0,map);
    }

    private static int numDistinctHelper(String s, int s_start, String t, int t_start, HashMap<String, Integer> map) {
        // T是空串
        if (t_start == t.length())
        {
            return 1;
        }
        // S 是空串
        if (s_start == s.length())
        {
            return 0;
        }
        String key = s_start + "@" + t_start;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int count = 0;
        //当前字母相同
        if (s.charAt(s_start) == t.charAt(t_start)) {
            count = numDistinctHelper(s,s_start+1,t,t_start+1,map) + numDistinctHelper(s,s_start+1,t,t_start,map); //两种情况：1 选取S当前字母，所以S和T都跳过；2不选S当前字母，S跳T不跳
        }
        else {
            count = numDistinctHelper(s, s_start + 1, t, t_start, map); // 不相等所以S跳过当前字母，T不跳
        }
        map.put(key,count);
        return count;
    }

    // DP
    //当 S[j] == T[i] ,  dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
    //当 S[j] != T[i] ,  dp[i][j] = dp[i][j-1]
    private static int numDistinct1(String s, String t) {
        int[][] dp = new int[t.length()+1][s.length()+1];
        Arrays.fill(dp[0],1);
        for (int i =1; i<t.length()+1;i++) {
            for (int j=1;j<s.length()+1;j++) {
                if (t.charAt(i-1) == s.charAt(j-1)) dp[i][j] = dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                else dp[i][j] = dp[i][j];
            }
        }
        return dp[t.length()][s.length()];
    }

}
