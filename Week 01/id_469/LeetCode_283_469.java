/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {

        f1(nums);

        // f2(nums);

    }

    /**
     * 方法二：遇见非零往前放，记录0的个数，后续统一赋值
     * 
     * @param nums
     */
    private void f2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j++;
            } else {
                nums[i - j] = nums[i];
            }
        }
        for (int k = nums.length - j; k < nums.length; k++) {
            nums[k] = 0;
        }
    }

    /**
     * 方法一：遇见非0往前放,后面放0
     * 
     * @param nums
     */
    private void f1(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];

                if (i != j) {
                    nums[i] = 0;
                }

                j++;
            }

        }
    }
}
// @lc code=end
