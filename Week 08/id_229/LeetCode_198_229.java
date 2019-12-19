public class LeetCode_198_打家劫舍 {


    /*
        f(k) = 从前 k 个房屋中能抢劫到的最大数额，Ai= 第 i 个房屋的钱数

        n = 1的情况，f(1) = A1
        n = 2的情况, f(2) = max(A1,A2)
        对于n = 3，有两个选项:
            1、抢第三个房子，将数额与第一个房子相加
            2、不抢第三个房子，保持现有最大数额

         显然，你想选择数额最大的选项。于是可以总结出公式：
         f(k) = max(f(k-2) + Ak, f(k-1))

         时间复杂度 O(n) 空间复杂度O(1)

     */
    public int rob(int[] num) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : num) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }


    /*
        使用容易理解方案
     */
    public int rob1(int[] num) {
        //0代表不偷 1偷
        int[][] dp = new int[num.length][2];
        if (num.length > 0) {
            dp[0][1] = Math.max(0, num[0]);
        } else {
            return 0;
        }

        for (int i = 1; i < num.length; i++) {
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][0] + num[i]);
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
        }
        return Math.max(dp[num.length - 1][1], dp[num.length - 1][0]);

    }


    public int rob2(int[] num) {
        int prev0 = 0;
        int prev1 = 0;
        int curr0 = 0;
        int curr1 = 0;

        if (num.length > 0) {
            prev1 = Math.max(0, num[0]);
        } else {
            return 0;
        }

        for (int i = 1; i < num.length; i++) {
            curr1 = Math.max(prev0, prev0 + num[i]);
            curr0 = Math.max(prev1, prev0);
            prev0 = curr0;
            prev1 = curr1;
        }
        return Math.max(curr1, curr0);
    }


}
