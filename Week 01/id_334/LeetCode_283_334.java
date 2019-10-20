package Array;

//Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
// Example:
//
//
//Input: [0,1,0,3,12]
//Output: [1,3,12,0,0]
//
// Note:
//
//
// You must do this in-place without making a copy of the array.
// Minimize the total number of operations.
// Related Topics Array Two Pointers

//总结：以下三个方法时间复杂度皆为O(n)
// 第一个想法V1：将最前面的0与非0元素互换位置，核心在于最前面的0的位置会变动
// 第二个想法V2：发现一个规律，由于0都是往后放置，因此i-0的数量即为非0元素置换之后的位置；
//             换句话说就是0有几个，非0元素就往前移动几位即可
// 第三个想法V3：既然0都在后面，那么为何不直接把非0元素直接依次填充，然后需要append的0的长度=数组长度-非0元素长度
//              换句话说就是不关心移动几位，只关心需要尾部填充几个0；与之前两个主要区别在于需要多个循环，但由于不是嵌套，因此仍是O(n)
// 第四个想法V4：前三种其实都是站在0的思路上去想，如果考虑其他元素依次往前排的，那么可以用一个index记录下一次可以被非0元素填充的位置
//              其他位置默认为0

// -- 随着调用次数的减少，内存占用率也逐渐减少

import java.util.Arrays;

public class LeetCode_283_334 {

    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 0, 3, 12};
        moveZeroesV4(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Move Zeroes.
     * Memory Usage: 38 MB, less than 91.61% of Java online submissions for Move Zeroes.
     *
     * @param nums
     */
    public static void moveZeroesV1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int theFrontZeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];
            if (theFrontZeroIndex == -1 && t == 0) {
                theFrontZeroIndex = i;
                continue;
            }
            if (theFrontZeroIndex != -1 && t != 0) {
                nums[theFrontZeroIndex] = t;
                nums[i] = 0;
                theFrontZeroIndex++;
            }
        }
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Move Zeroes.
     * Memory Usage: 37.7 MB, less than 100.00% of Java online submissions for Move Zeroes.
     *
     * @param nums
     */
    public static void moveZeroesV2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int zeroNums = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroNums++;
                continue;
            }
            nums[i - zeroNums] = nums[i];
            if (zeroNums != 0) {
                nums[i] = 0;
            }
        }
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Move Zeroes.
     * Memory Usage: 36.5 MB, less than 100.00% of Java online submissions for Move Zeroes.
     */
    public static void moveZeroesV3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[zeroCount++] = nums[i];
            }
        }
        if (zeroCount != 0) {
            while (nums.length - zeroCount > 0) {
                nums[zeroCount++] = 0;
            }
        }
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Move Zeroes.
     * Memory Usage: 36.5 MB, less than 100.00% of Java online submissions for Move Zeroes.
     *
     * @param nums
     */
    public static void moveZeroesV4(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int nextNonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nextNonZeroIndex] = nums[i];
                if (i != nextNonZeroIndex++) {
                    nums[i] = 0;
                }
            }

        }
    }


}

