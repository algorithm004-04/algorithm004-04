import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import sun.text.resources.sk.CollationData_sk;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 *
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * algorithms
 * Medium (72.18%)
 * Likes:    425
 * Dislikes: 0
 * Total Accepted:    53.8K
 * Total Submissions: 74.4K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 *
 */

// @lc code=start
class Solution {

    private void backtrack(int len, List<Integer> nums, List<List<Integer>> output, int first) {
        if (first == len) {
            output.add(new ArrayList<>(nums));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(nums, first, i);
            backtrack(len, nums, output, first + 1);
            Collections.swap(nums, first, i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new LinkedList<>();
        List<Integer> numsList = new ArrayList<Integer>();
        for (Integer val : nums) {
            numsList.add(val);
        }
        int len = nums.length;
        backtrack(len, numsList, output, 0);
        return output;
    }
}
// @lc code=end
