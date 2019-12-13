/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * <p>
 * <p>
 * 链接：https://leetcode-cn.com/problems/jump-game
 */
public class LeetCode_55_009 {
    boolean flag;

    public static void main(String[] args) {
        LeetCode_55_009 test = new LeetCode_55_009();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(test.canJump2(nums));
    }

    /**
     * 方法一：回溯法（超时）
     * 时间复杂度：O(2^n)
     * 空间复杂度：O(n) 考虑栈的空间
     *
     * @param nums
     * @return
     */
    public boolean canJump1(int[] nums) {
        return dfs(nums, 0);
    }

    public boolean dfs(int[] nums, int index) {
        if (index == nums.length - 1) {
            return true;
        }

        for (int stepNum = 0; stepNum <= nums[index]; stepNum++) {       //每一个index位置对应的走法
            if (stepNum > 0 && index + stepNum <= nums.length - 1) {    //限制条件：至少走一步，走完之后走过的长度不超过总距离。
                if (dfs(nums, index + stepNum)) {
                    return true;
                }
            }
        }

        return false;
    }


    /**
     * 方法二：贪心法(从后往前判断)
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
