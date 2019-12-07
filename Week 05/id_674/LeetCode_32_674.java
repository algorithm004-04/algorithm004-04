//暴力

public class Solution {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push('(');
			} else if (!stack.empty() && stack.peek() == '(') {
				stack.pop();
			} else {
				return false;
			}
		}
		return stack.empty();
	}

	public int longestValidParentheses(String s) {
		int maxlen = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 2; j <= s.length(); j += 2) {
				if (isValid(s.substring(i, j))) {
					maxlen = Math.max(maxlen, j - i);
				}
			}
		}
		return maxlen;
	}
}

//动态规划
public class Solution {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}

//栈
class Solution {
	public:
		int longestValidParentheses(string s) {
			int n = s.length(), longest = 0;
			stack<int> st;
			for (int i = 0; i < n; i++) {
				if (s[i] == '(') st.push(i);
				else {
					if (!st.empty()) {
						if (s[st.top()] == '(') st.pop();
						else st.push(i);
					}
					else st.push(i);
				}
			}
			if (st.empty()) longest = n;
			else {
				int a = n, b = 0;
				while (!st.empty()) {
					b = st.top(); st.pop();
					longest = max(longest, a-b-1);
					a = b;
				}
				longest = max(longest, a);
			}
			return longest;
		}
};

