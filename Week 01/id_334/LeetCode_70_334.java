package Array;

//You are climbing a stair case. It takes n steps to reach to the top.
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//
// Note: Given n will be a positive integer.
//
// Example 1:
//
//
//Input: 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
//
//
// Example 2:
//
//
//Input: 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
//
// Related Topics Dynamic Programming

//  第一个想法V1：发现一个规律 假设有n个台阶，一次只能上1或2，那么有f(1) =1 ,f(2) =2 且当n >2 时f(n) = f(n - 1) + f(n -2)
//           很典型的递归思路，举个例子论证，假设n=4:
//                  对于f(4) , 要么3+1，那么2+2，总的情况数即f(4) = f(3) + f(2)
//                  对于f(3) , 要么2+1，要么1+2，总的情况数即f(3) = f(2) + f(1)
//           递归的时间复杂度时O(2^n),空间复杂度O(n)

//  第二个想法V2：非递归想法，用空间换时间，由于存在f(n) = f(n - 2) + f(n - 1)，由于暴力递归不会存储每层的结果，
//              那么可以用数组缓存每层的结果集，减少重复计算；时间复杂度为O(n),空间复杂度O(n)

//  第三个想法V3：还是通过f(n) = f(n - 2) + f(n - 1)发现，其实并不需要存储每一次结果，只要存上上一次即f(n-2)和上一次即f(n-1)的结果就好了，
//              这就把所有存储项改成只存最近的两次结果就好了(从老师给的"最近"重复数得到启发，就存最近的2次即可);
//              时间复杂度为O(n),空间复杂度O(1)

//  第四个想法V4：此题有明显的斐波那契特征，直接用斐波那契函数计算；缓存一个梗号5；时间复杂度O(log(n)) - pow计算,空间复杂度O(1)


// 看了老师的视频后学到了：计算机的重复思想if/loop/recursion;暴力法;找最近重复数; -> 重复数就是找重复规律

//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_70_334 {

    public static void main(String[] args) {
        System.out.println(climbStairsV3(5));
    }


    /**
     * Time Limit Exceeded
     *
     * @param n
     * @return
     */
    public static int climbStairsV1(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n less than 0");
        }
        if (n <= 2) {
            return n;
        }
        return climbStairsV1(n - 1) + climbStairsV1(n - 2);
    }


    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
     * Memory Usage: 33.1 MB, less than 5.26% of Java online submissions for Climbing Stairs.
     *
     * @param n
     * @return
     */
    public static int climbStairsV2(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n less than 0");
        }
        if (n <= 2) {
            return n;
        }
        int[] cache = new int[n];
        cache[0] = 1;
        cache[1] = 2;
        int i = 2;
        while (i < n) {
            cache[i] = cache[i - 2] + cache[i - 1];
            i++;
        }
        return cache[n - 1];
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
     * Memory Usage: 32.7 MB, less than 5.26% of Java online submissions for Climbing Stairs.
     *
     * @param n
     * @return
     */
    public static int climbStairsV3(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n less than 0");
        }
        if (n <= 2) {
            return n;
        }
        int pre = 1;
        int current = 2;
        int i = 3;
        while (i <= n) {
            int t = current;
            current += pre;
            pre = t;
            i++;
        }
        return current;
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
     * Memory Usage: 32.7 MB, less than 5.26% of Java online submissions for Climbing Stairs.
     *
     * @param n
     * @return
     */
    public static int climbStairsV4(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n less than 0");
        }
        if (n <= 2) {
            return n;
        }
        double sqrt5 = Math.sqrt(5);
        double fib = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) (fib / sqrt5);
    }

}
//leetcode submit region end(Prohibit modification and deletion)


