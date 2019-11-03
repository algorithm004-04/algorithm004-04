/**
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 来源：https://leetcode-cn.com/problems/move-zeroes
 *
 * @author liqiuying
 * @date 2019-10-18
 */
public class LeetCode_283_429 {
    /**
     * 移动零算法
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        //非零index计数器
        int nonZeroIndex = 0;
        //零元素计数器
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && i != nonZeroIndex) {
                //将非零的数字向前放
                nums[nonZeroIndex] = nums[i];
            }
            if (nums[i] == 0) {
                //零数量加一
                zeroCount++;
            } else {
                nonZeroIndex++;
            }
        }
        //置zero位零数字
        for (int i = 0; i < zeroCount; i++) {
            nums[nums.length - 1 - i] = 0;
        }
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}

