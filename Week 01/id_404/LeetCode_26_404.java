/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

 /*
 方法 1： 暴力破解。遇到相同项，就删除掉，并将后面所有的数字往前移动一格。
 方法 2： 双指针标记。首先想到滚雪球的方法，将相同的数字慢慢往后滚，写代码后发现这样只能移动一个数字，无法实现。
 后来看到解法发现双指针法。慢慢体会到其实这也是一种滚雪球原理，只不过不是把相同项往后滚，而是把有效数字往后滚。
 */
// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                p++;
                nums[p] = nums[q];
            }
            q++;
        }
        return p + 1;
    }
}
// @lc code=end
