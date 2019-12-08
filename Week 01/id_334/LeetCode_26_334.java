package Array;
//Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
//
// Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
//
// Example 1:
//
//
//Given nums = [1,1,2],
//
//Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
//
//It doesn't matter what you leave beyond the returned length.
//
// Example 2:
//
//
//Given nums = [0,0,1,1,1,2,2,3,3,4],
//
//Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
//
//It doesn't matter what values are set beyond the returned length.
//
//
// Clarification:
//
// Confused why the returned value is an integer but your answer is an array?
//
// Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
//
// Internally you can think of this:
//
//
//// nums is passed in by reference. (i.e., without making a copy)
//int len = removeDuplicates(nums);
//
//// any modification to nums in your function would be known by the caller.
//// using the length returned by your function, it prints the first len elements.
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// Related Topics Array Two Pointers

// 第一个想法V1：双指针法，利用有序的特性用prev记录上次的重复值，非重复时移动j即可
//              时间复杂度o(n),空间复杂度o(1)

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_26_334 {

    public static void main(String[] args) {
//        int [] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int[] nums = new int[]{1, 2, 3};
        int i = removeDuplicatesV1_2(nums);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * Runtime: 1 ms, faster than 97.34% of Java online submissions for Remove Duplicates from Sorted Array.
     * Memory Usage: 41.6 MB, less than 17.02% of Java online submissions for Remove Duplicates from Sorted Array.
     */
    public static int removeDuplicatesV1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int prev = nums[0];
        int i = 1, j = 1;
        while (i < nums.length) {
            if (nums[i] != prev) {
                prev = nums[j++] = nums[i];
            }
            i++;
        }
        return j;
    }

    /**
     * 空间优化版本 - 优化点：
     *       (1)由于有序，因此nums[len -1] == nums[n-1] == prev，删除prev即可
     * Runtime: 1 ms, faster than 97.34% of Java online submissions for Remove Duplicates from Sorted Array.
     * Memory Usage: 39.4 MB, less than 99.47% of Java online submissions for Remove Duplicates from Sorted Array.
     */
    public static int removeDuplicatesV1_2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int len = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[len]) {

                nums[len++] = nums[i];
            }
        }
        return len + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
