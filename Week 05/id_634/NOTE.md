# NOTE

##### 动态规划的实现及关键点

较为复杂的数据结构：分治+回溯+递归+动态规划

递归代码模板
``` java
public void recur(int level, int param) {
	// terminator
	if(level > MAX_LEVEL) {
		// process result
		return;
	}

	// process current logic
	process(level, param);

	//drill down
	recur(level + 1, new Param);

	// restore current status
}
``` 

分治代码模板
``` java
public void divide_conquer(problem, param1, param2, ...) {
	// recursion terminator
	if(problem == null) {
		return
	}

	// prepare data
	data = prepare_data(problem);
	subproblems = split_problem(problem, data);

	// conquer subproblems
	subresult1 = self.divide_conquer(subproblem[0], p1, ...);
	subresult2 = self.divide_conquer(subproblem[1], p1, ...);
	subresult3 = self.divide_conquer(subproblem[2], p1, ...);
	...

	// process and generate the final result
	result = process_result(subresult1, subresult2, subresult3, ...);

	// revert the current level states
}
``` 

总结：
1.人肉递归低效、很累、容易出错
2.找最近最简方法、将其拆解成可重复性解决的问题
3.数学归纳法思维
本质：寻找重复性->计算机指令集

动态规划 Dynamic Programming
1.Wiki定义：
https://en.wikipedia.org/wiki/Dynamic_programming
2."Simplifying a complicated problem by breaking it down into simpler sub-problems"
(in a recursive manner)
3.Divide & Conquer + Optimal substructure(分治 + 最优子结构)

关键点：
1.最优子结构 opt[n] = best_of(opt[n-1], opt[n-2], ...)
2.储存中间状态： opt[i]
3.递推公式（状态转移方程或DP方程）
Fib: opt[i] = opt[n-1] + opt[n-2]

简化过程：
1.第一步简化  简洁  并没有改变时间复杂度 O（2^n)
2.第二步简化  记忆化搜索 增加缓存 时间复杂度将为O（n)  
right clean code 简洁清晰代码
3.第三步简化 自底向上循环  时间复杂度将为O（n)  
一般比较熟练或者是竞赛只要是递归都是for循环自底向上进行递推

复杂的（DP）动态递推：
1.维度变化状态二维或三维 
2.中间有取舍最优子结构


##### 12.4. 实战题目解析：三角形最小路径和  中爬楼梯的2个问题
``` java
public class ClimbingStairs {

    //DP 1 2 3 三种走法
    public static int climbStairsII(int n) {
        /*
         * DP
         * 1.重复性（分治）
         * 2.定义状态数组  int[] dp
         * 3.DP方程： dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
         */
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 3;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    //DP 1 2 3 相邻步伐不能相同
    public static int climbStairsIII(int steps[], int stepKinds, int target){
        /*
         * DP
         * 1.重复性（分治）
         * 2.定义状态数组  int[][] dp
         * 3.DP方程： dp[i][j] += dp[i - 1][j - k * steps[i - 1]]
         */
        int[][] dp = new int[stepKinds + 1][target + 1];
        for (int i = 0; i <= stepKinds; i++){
            dp[i][0] = 1;
        }
        dp[0][target] = 0;
        for (int i = 1; i <= stepKinds; i++){
            for (int j = 1; j <= target; j++){
                dp[i][j] = 0;
                for (int k = 0; k <= j / steps[i - 1]; k++){//<=
                    if((dp[i - 1][j] - dp[i][j - 1]) != steps[i - 1]) {
                        dp[i][j] += dp[i - 1][j - k * steps[i - 1]];//+=
                    }else{
                        dp[i][j] = 0;
                    }
                }
            }
        }
        return dp[stepKinds][target];
    }

    public static void main(String[] args) {
//        System.out.println(climbStairsII(5));
        int[] steps = {1, 2, 3};
        System.out.println(climbStairsIII(steps, 3, 10) );
    }

}

``` 

