/*
给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
*/
#include <string.h>
#include <stdio.h>
#if 0
int longestValidParentheses(char * s)
{
    int len = strlen(s);
    int maxLen = 0;
    int i;
    if (len < 2) {
        return 0;
    }
    int *dp = calloc(len, sizeof(int));
    if (s[0] == '(' && s[1] == ')') {
        dp[1] = 2;
        maxLen = maxLen > dp[1] ? maxLen : dp[1];
    }
    for (i = 2; i < len; i++) {
        if (s[i] == ')' && s[i-1] == '(') {
            dp[i] = dp[i-2] + 2;
        } else if (s[i] == ')' && s[i-1] == ')') {
            if ((i-dp[i-1]-1 >= 0) && s[i -  dp[i-1] - 1] == '(') {
                if (i-dp[i-1]-2 > 0) {
                    dp[i] = dp[i-1] + dp[i - dp[i-1] - 2] + 2;
                } else {
                    dp[i] = dp[i-1] + 2;
                }
            } else {
                dp[i] = 0;
            }

        } else {
            dp[i] = 0;
        }
        maxLen = maxLen > dp[i] ? maxLen : dp[i];
    }
    return maxLen;
}
#endif
/* stack */
int longestValidParentheses(char * s)
{
    int len = strlen(s);
    int top = 0;
    int stack[10] = {0}; 
    stack[top] = -1;
    int i;
    int maxLen = 0;
    int temp;
    for (i = 0 ; i < len; i++) {
        if (s[i] == '(') {
            stack[++top] = i;
        } else if (s[i] == ')') {
            if (top >=1) {
                temp = i - stack[--top];
                maxLen = maxLen > temp ? maxLen : temp;
            } else {
                stack[top] = i;
            }
        }
    }
    return maxLen;
}
void main() 
{
    char *s = "(()())";
    int n;
    n = longestValidParentheses(s);
    printf("%d ", n);
    return;
}