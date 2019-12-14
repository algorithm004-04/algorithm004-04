package algorithm;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_32_299 {
    public static void main(String[] args) {
        String s = ")))))(())";
        int i = LeetCode_32_299(s);
        System.out.println("最长----------->"+i);
    }

    public static int LeetCode_32_299(String s){
        int max = 0;

        // 分解子问题
        // 定义状态数组
        int[] dp = new int[s.length()];
        int len = s.length();
        // dp方程
        for(int i =1;i < len;i++){ // 下标从1开始 括号是一对
            if(')' == s.charAt(i)){ //有长度 后一位一定要是)
                if(s.charAt(i-1) == '('){
                    dp[i] = ((i >= 2) ? dp[i-2]:0 ) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                max = Math.max(max , dp[i]);
            }
        }

        return max;
    }
}
