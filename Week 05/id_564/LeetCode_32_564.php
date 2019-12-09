<?php
/*
 * @lc app=leetcode.cn id=32 lang=php
 *
 * [32] 最长有效括号
 *
 * https://leetcode-cn.com/problems/longest-valid-parentheses/description/
 *
 * algorithms
 * Hard (28.40%)
 * Likes:    386
 * Dislikes: 0
 * Total Accepted:    27.7K
 * Total Submissions: 96.6K
 * Testcase Example:  '"(()"'
 *
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 
 * 示例 1:
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
 * 
 */

// @lc code=start
class Solution {

    /**
     * @param String $s
     * @return Integer
     */
    function longestValidParentheses($s) {
        $max = 0;
        $dp = array_fill(0, strlen($s), 0);
        for ($i = 1; $i < strlen($s); $i++) {
            if ($s[$i] == ')') {
                //右括号前边是左括号
                if ($s[$i - 1] == '(') {
                    $dp[$i] = ($i >= 2 ? $dp[$i - 2] : 0) + 2;
                    ///右括号前边是右括号，并且除去前边的合法序列的前边是左括号
                } else if ($i - $dp[$i - 1] > 0 && $s[$i - $dp[$i - 1] - 1] == '(') {
                    $dp[$i] = $dp[$i - 1] + (($i - $dp[$i - 1]) >= 2 ? $dp[$i - $dp[$i - 1] - 2] : 0) + 2;
                }
                $max = max($max, $dp[$i]);
            }
        }
        return $max;
    }

    function longestValidParentheses2($s) {
        $res = 0;
        $stack = [-1];
        for ($i = 0; $i < strlen($s); $i++) {
            if ($s[$i] == '(') {
                array_push($stack, $i);
            } else {
                array_pop($stack);
                if (empty($stack)) {
                    array_push($stack, $i);
                } else {
                    $res = max($res, $i-end($stack));
                }
            }
        }
        return $res;
    }

    function longestValidParentheses1($s) {
        $res = 0;
        $start = 0;
        $stack = new SplStack();
        for ($i = 0; $i < strlen($s); $i++) {
            if ($s[$i] == '(') {
                $stack->push($i);
            } else {
                if ($stack->isEmpty()) {
                    $start = $i + 1;
                } else {
                    $stack->pop();
                    $res = $stack->isEmpty() ? max($res, $i-$start+1):max($res, $i-$stack->top());
                }
            }
        }
        return $res;
    }
}
// @lc code=end


?>