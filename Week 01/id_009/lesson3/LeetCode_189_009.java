package lesson3;

import java.util.Arrays;

/**
 * 【旋转数组】
 * <p>
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 示例 1:
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * <p>
 * 说明:
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * <p>
 * 链接：https://leetcode-cn.com/problems/rotate-array
 */
public class LeetCode_189_009 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        LeetCode_189_009 test = new LeetCode_189_009();
        test.rotate3(nums, 3);
        System.out.println(Arrays.toString(nums));
    }


    /**
     * 方法一：暴力法
     * 1）分k次完成，每一次实现一步右移
     * 2）一位右移的实现方法：从前往后遍历，每次都和最后一个元素交换位置。
     * <p>
     * 时间复杂度：O(n*k)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        int temp;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                temp = nums[j];
                nums[j] = nums[nums.length - 1];
                nums[nums.length - 1] = temp;
            }
        }
    }


    /**
     * 方法二：辅助结构
     * nums[(i+k)%nums.length]=nums[i]，如果直接在原数组中用此公式赋值，会出现给前段部分赋值时后段的元素已经变了。
     * 开辟辅助空间，遍历时nums[(i+k)%nums.length]=nums[i]给辅助空间赋值，然后遍历辅助空间赋值给原数组。
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[(i + k) % nums.length] = nums[i];
        }

        for (int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }
    }


    /**
     * 方法三：使用反转
     * 1）分别反转前n-k个元素，后k个元素。
     * 2）反转整个数组。
     * <p>
     * 如：[1,2,3,4,5,6,7] -> [4,3,2,1] 和 [7,6,5] -> [4,3,2,1,7,6,5] -> [5,6,7,1,2,3,4]
     * <p>
     * 时间复杂度啊：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }


    //反转数组
    public void reverse(int[] nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            ++start;
            --end;
        }
    }

}
