//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //general recursion(timeout)
    public int climbStairs2(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        return climbStairs(n-1) + climbStairs(n-2);
    }

    HashMap<Integer, Integer> map = new HashMap<>();

    /*
    iteration + memory array
    执行耗时:0 ms,击败了100.00% 的Java用户
	内存消耗:33.1 MB,击败了71.64% 的Java用户
     */
    public int climbStairs3(int n) {
        //初始化一个记忆数组,用来放置1-n阶对应的不同方法
        //此处由于n从1开始，而数组下标从0开始，故需要申请n+1个元素的数组
        int[] memo = new int[n+1];
        if (n == 1) return 1;
        if (n == 2) return 2;
        memo[0] = 0; memo[1] = 1; memo[2] = 2;
        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n];
    }

    /*
    recursion+ hashMap
    执行耗时:2 ms,击败了37.71% 的Java用户
	内存消耗:33.3 MB,击败了66.09% 的Java用户
     */
    public int climbStairs(int n) {
        //初始化一个记忆数组,用来放置1-n阶对应的不同方法
        //此处由于n从1开始，而数组下标从0开始，故需要申请n+1个元素的数组
        int[] memo = new int[n+1];
        if (n == 1) return 1;
        if (n == 2) return 2;
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 2);
        if(!map.containsKey(n)) {
            map.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        };

        return map.get(n);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
