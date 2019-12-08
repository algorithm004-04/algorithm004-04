import java.util.LinkedList;
import java.util.List;

import javax.naming.LinkException;

import jdk.nashorn.internal.ir.ReturnNode;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 *
 * https://leetcode-cn.com/problems/combinations/description/
 *
 * algorithms
 * Medium (70.84%)
 * Likes:    174
 * Dislikes: 0
 * Total Accepted:    22.9K
 * Total Submissions: 32.3K
 * Testcase Example:  '4\n2'
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 *
 */

// @lc code=start
class Solution {
    int n;
    int k;
    List<List<Integer>> output = new LinkedList<>();

    private void backtrack(int first, LinkedList<Integer> curr) {
        if (curr.size() == k) {
            output.add(new LinkedList<>(curr));
            return;
        }
        for (int i = first; i <= n; i++) {
            curr.add(i);
            backtrack(i + 1, curr);
            curr.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;

        backtrack(1, new LinkedList<Integer>());

        return output;
    }
}
// @lc code=end
