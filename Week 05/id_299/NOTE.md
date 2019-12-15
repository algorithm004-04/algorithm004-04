# NOTE

## 解题思路

1. 升高维度
2. 空间换时间

## 动态规划
往往题目要求的是最优解,比如 求解最少，最多，最长，最短 等，可使用动态规划解答
1. 分解子问题（分治）
2. 定义状态数组
3. DP方程
   1. 自底向上
   2. 自顶向下

## 复杂的问题
复杂的问题中分治、回溯、递归、动态规划本质区别不大，都是分解子问题找到相似性归纳出方程式。

## 案例
菲波拉契数
```js
console.time('fib');
function fib(n){
  return n <=1 ? n :fib(n-1)+ fib(n-2);
}
// fib(30)就已经 21.08s了 
// 2014款 mac mini中配 chrome v78.0.3904.97
// 机器不一样可能有误差
// fib(100) js 100次直接卡死  
fib(30) 
console.timeEnd('fib');

// 1. 尾递归优化
function fib(n){
  return youhua(n,0,1);
}
function youhua(n,prev,total){
  if(n <=1){
    return total;
  } 
  return youhua(n-1, total, prev + total);
}
console.time('fib');
console.log(fib(30)); // fib: 0.2041015625ms
console.timeEnd('fib');

// 2. 优化 + 缓存
console.time('fib2');
function fib2(n){
  if(n<= 1){
    return 1;
  }

  const memo = [];
  for(let i = 0;i< n;i++){
    if(i<= 1){
      memo.push(1);
    } else {
      memo.push(memo[i-1] +memo[i-2]);
    }
  }

  return memo[n-1];
}
fib2(30);
console.timeEnd('fib2');// 0.092041015625ms
```

最小路径和
```js
// 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

// 说明：每次只能向下或者向右移动一步。

// 示例:

// 输入:
// [
//   [1,3,1],
//   [1,5,1],
//   [4,2,1]
// ]
// 输出: 7
// 解释: 因为路径 1→3→1→1→1 的总和最小。

// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/minimum-path-sum
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

function minPathSum(grid) {
    // 定义状态数组
    var dp = grid;
    var ilen = dp.length -1,jlen = dp[0].length -1;
    var i = ilen, j = jlen; 
    // DP方程 自底向上
    for (i = ilen;i >= 0;i--){
        for(j = jlen; j>=0;j--){
            // 分解子问题 
            // 从最后一步起 最后一列往上累加
            if(i == ilen && j != jlen){
              dp[i][j] = dp[i][j] + dp[i][j+1]; // 累加数字
            // 从最后一步起 最后一行往左累加
            } else if(j == jlen && i != ilen){
              dp[i][j] = dp[i][j] + dp[i+1][j];
            // 从最后一步起 取向左 向上最有小值累加
            } else if(j != jlen && i != ilen){
              dp[i][j] = dp[i][j] + Math.min(dp[i+1][j],dp[i][j+1]);
            }
        }
    }
    // 路径最优和累加在状态数组终点
    return dp[0][0];
}
```

