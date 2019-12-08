/*
 * @lc app=leetcode.cn id=32 lang=cpp
 *
 * [32] 最长有效括号
 */

// @lc code=start
#include <iostream>
#include <algorithm>
#include <stack>
#include <vector>

using namespace std;

/*
    方法一: 栈

 	时间复杂度：O(n)
 	空间复杂度：O(n)

class Solution {
public:
    int longestValidParentheses(string s) {
        stack<int> stk;
        stk.push(-1);
        int maxL = 0;

        for(int i = 0; i < s.size(); i++)
        {
            int t = stk.top();
            if(t != -1 && s[i] == ')' && s[t] == '(')
            {
                stk.pop();
                maxL = max(maxL, i - stk.top());
            }
            else
                stk.push(i);
        }
        return maxL;
    }
};
*/

/*
    方法二: 动态规划 

 	时间复杂度：O(n)
 	空间复杂度：O(n)

*/
class Solution {
public:
    int longestValidParentheses(string s) {
        int cnt = 0; // count of "("
        vector<int> dp(s.size() + 1, 0);
        
        for (size_t i = 1; i <= s.size(); i++) {
            if (s[i-1] == '(') {
                cnt++;
            } else {
                if (cnt > 0) {  // there exists an unclosed "(" to match ")"
                    cnt--;
                    dp[i] = 2;
                    if (s[i-2] == ')')  // add the length of previous closed ")" neighbor
                        dp[i] += dp[i-1];                        
                    dp[i] += dp[i-dp[i]]; // add the length of previous valid parentheses
                }
            }
        }
        
        return *max_element(dp.begin(), dp.end());        
    }
};

// @lc code=end

