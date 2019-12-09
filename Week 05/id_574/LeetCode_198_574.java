package SuanFa.Week05;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Neo
 */
public class LeetCode_198_574 {
    public static void main(String[] args) {
        int nums[] = {1,2,3,1};
        System.out.println(rob(nums));
        System.out.println(rob1(nums));
    }

    /**
     * 通过升维把偷与不偷的状态带进去
     * @param nums
     * @return
     */
    private static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int [][] a = new int [n][2];
        a[0][0] = 0;
        a[0][1] = nums[0];
        for (int i = 1; i< n;i++) {
            a[i][0] = Math.max(a[i-1][1],a[i-1][0]);
            a[i][1] = a[i-1][0] + nums[i];
        }
        return Math.max(a[n-1][0],a[n-1][1]);
    }

    private static int rob1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        int [] a = new int [n];
        a[0] = nums[0];
        a[1] = Math.max(a[0],nums[1]);
        int res = Math.max(a[0],a[1]);
        for (int i = 2; i< n;i++) {
            a[i] = Math.max(a[i-1],a[i-2] + nums[i]);
            res = Math.max(res,a[i]);
        }
        return res;
    }

    /**
     * 不用保留数组空间，参考爬楼梯
     * @param nums
     * @return
     */
    private static int rob2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int prevMax = 0;
        int currMax = 0;
        for (int x : nums) {
            int temp = currMax;
            currMax = Math.max(prevMax + x,currMax);
            prevMax = temp;
        }
        return currMax;
    }
}
