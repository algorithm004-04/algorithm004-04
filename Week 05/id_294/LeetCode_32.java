package week05;

public class LeetCode_32 {

    /**
     * 有效子串：满足括号匹配规则
     * dp状态定义 dp[i] 表示以第i个字符结尾的[最长_有效_连续_子串]的长度
     * dp方程(from back to front)
     * s[i] == ")" && s[i-1] == "(", dp[i] = dp[i-2] + 2
     * s[i] == ")" && s[i-1] == ")", dp[i] = s[i-dp[i-1]-1] == "(" ? (i-dp[i-1]-2 >= 2 ? dp[i-dp[i-1]-2] : 0) + dp[i-1] + 2 : 0
     *
     * 因为是从后向前查找，所以考虑的是右括号，以左括号结尾的子串肯定不是有效的
     * 第一条很好理解，如果连续的两个字符是成对的括号，那么他们是独立存在的有效子串，无需再与其他括号匹配
     * 第二条，如果连续两个字符都是右括号，如果s[i],s[i-1]都有匹配的左括号，那么与s[i]匹配的左括号肯定在s[i-1]匹配的左括号左边一位
     * 匹配完s[i]，还要考虑以s[i]结尾的有效子串时不时最长，因为它的前面可能存在情况1那种独立存在的已匹配的子串，这时，需要把他们的长度
     * 加上
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int maxLen = 0;
        for(int i=1;i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i-1) == '(') {
                    dp[i] = (i >= 2? dp[i-2] : 0) + 2;
                } else {
                    if (i-dp[i-1]-1 >= 0 && s.charAt(i-dp[i-1]-1) == '(') {
                        dp[i] = (i - dp[i-1] - 2 >= 1 ? dp[i-dp[i-1]-2] : 0) + dp[i-1] + 2;
                    }
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = ")()())";
        int len = longestValidParentheses(s);
        System.out.println(len);
    }
}
