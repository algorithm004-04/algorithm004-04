package SuanFa.Week05;

import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 *
 *
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Neo
 */
public class LeetCode_32_574 {
    public static void main(String[] args) {
        String s = "()((())";
        System.out.println(longesValidParentheses(s));
        System.out.println(longesValidParentheses1(s));
    }

    /**
     * 用栈的思路匹配
     * @param s
     * @return
     */
    private static int longesValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int maxans = 0;
        stack.push(-1);
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                }
                else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    /**
     * 利用两个计数器 leftleftleft 和 rightrightright 。首先，我们从左到右遍历字符串，对于遇到的每个 ‘(’\text{‘(’}‘(’，我们增加 leftleftleft 计算器，对于遇到的每个 ‘)’\text{‘)’}‘)’ ，我们增加 rightrightright 计数器。每当 leftleftleft 计数器与 rightrightright 计数器相等时，我们计算当前有效字符串的长度，并且记录目前为止找到的最长子字符串。如果 rightrightright 计数器比 leftleftleft 计数器大时，我们将 leftleftleft 和 rightrightright 计数器同时变回 000 。
     * 接下来，我们从右到左做一遍类似的工作。
     * @param s
     * @return
     */
    private static int longesValidParentheses1(String s) {
        int left =0, right = 0, maxLength = 0;
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == '(') {
                left++;
            }
            else {
                right++;
            }
            if (left == right) {
                maxLength = Math.max(maxLength, 2 * right);
            }
            else if (right >= left) {
                left = 0;
                right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i>=0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            }
            else {
                right++;
            }
            if (left == right) {
                maxLength = Math.max(maxLength, 2 * left);
            }
            else if (left >= right) {
                left = right = 0;
            }
        }
        return maxLength;
    }
}
