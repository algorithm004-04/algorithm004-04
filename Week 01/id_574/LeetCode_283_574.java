package SuanFa;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 说明:
 *
 *
 * 	必须在原数组上操作，不能拷贝额外的数组。
 * 	尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Neo
 */
public class LeetCode_283_574 {
    public static void main(String[] args) {
        int nums[] = {0,1,0,1,3,12};
        moveZeroes1(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int nums[]) {
        int j=0;
        for (int i=0;i<nums.length;i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public static void moveZeroes1(int nums[]) {
        int count = 0;
        for (int i=0;i<nums.length;i++) {
            if (nums[i] == 0) {
                count ++;
            }
            else {
                nums[i-count] = nums[i];
            }
        }
        for (int i=0;i<count;i++) {
            nums[nums.length-1-i] = 0;
        }
    }
}
