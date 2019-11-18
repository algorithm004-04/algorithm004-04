//斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： 
//
// F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
// 
//
// 给定 N，计算 F(N)。 
//
// 
//
// 示例 1： 
//
// 输入：2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
// 
//
// 示例 2： 
//
// 输入：3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
// 
//
// 示例 3： 
//
// 输入：4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
// 
//
// 
//
// 提示： 
//
// 
// 0 ≤ N ≤ 30 
// 
// Related Topics 数组



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //top down
    public int fib(int N) {
        if (N <= 1) return N;
        int[] memo = new int[N+1];

        return helper(memo, N);
    }

    public int helper(int[] memo, int n){
        if (n <= 1) return n;
        if (memo[n] == 0) {
            memo[n] = helper(memo,n - 1) + helper(memo,n - 2);
        }
        return memo[n];
    }

    //bottom up
//    public int fib(int N) {
//        if (N <= 1) return N;
//        int[] memo = new int[N + 1];
//        memo[1] = 1;
//        return helper(memo, N);
//    }
//
//    public int helper(int[] memo, int N) {
//        for (int i = 2; i <= N; i++) {
//            memo[i] = memo[i - 1] + memo[i - 2];
//        }
//        return memo[N];
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
