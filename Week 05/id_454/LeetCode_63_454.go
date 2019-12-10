func longestValidParentheses(s string) int {
    n := len(s)
    max := 0
    dp := make([]int, n)
    for i:=1;i<n;i++ {
        // 有效字符串必须以)结尾
        if s[i] == ')' {
            // 情况1 ...()
            if s[i-1] == '(' {
                if i >= 2 {
                    dp[i] = dp[i-2] + 2
                }else {
                    dp[i] = 2
                }
            }else if i - dp[i-1] > 0 && s[i - dp[i - 1] - 1] == '(' {
                // 情况2 s[i-1] == ')'
                // 在 i - dp[i - 1] - 1 位置必须有(来匹配
                // (...))
                dp[i] = dp[i - 1] + 2
                
                // 如果在s[i - dp[i - 1] - 1]之前的子串也是有效的，需要加上
                if (i - dp[i - 1]) >= 2 {
                    dp[i] += dp[i - dp[i - 1] - 2]
                }
            }
            if dp[i] > max {
                max = dp[i]
            }
        }
    }
    return max
}