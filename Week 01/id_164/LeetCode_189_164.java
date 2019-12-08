/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 */
class Solution {
    public void rotate(int[] nums, int k) {
        int kk = k % nums.length;
        for (int i = 0; i< nums.length / 2; i++) {
            int a = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = a;
        }

        for (int j = 0; j < kk / 2; j++) {
            int b = nums[j];
            nums[j] = nums[kk - j - 1];
            nums[kk - j - 1] = b;
        }

        for (int n = kk; n < kk + (nums.length - kk) / 2; n++) {
            int c = nums[n];
            nums[n] = nums[nums.length - n + kk - 1];
            nums[nums.length - n + kk - 1] = c;
        }
    }
}
