# NOTE

##### 动态规划、状态转移方程
递归模板

``` Java
public void recur(int level, int param) {

    // terminator
    if(level > MAX_LEVEL) {
        // process result
        return;
    }

    // process current logic
    process(level, param);

    // drill down
    recur(level:level + 1, newParam)；

    // restore current status
}
```

分治模板

``` Java
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

动态规划顺推模板

``` Java
dp = [][] // 二维情况

for(int j = 0; j < n; j++) d[n][j]=a[n][j];// 边界处理

for(int i = n - 1; i >= 0; i--) {
    for(int j = 1; j < i; j++) // 枚举范围视情况而定
        d[i][j] = a[i][j] + max(d[i + 1][j], d[i + 1][j + 1]);// 状态转移
}
```

关键步骤：
1.定义状态数组：现实的问题定义为一个数组保存状态，数组可能是一维、二维或多维
2.状态转移方程：最小或累加减或小的循环  从之前的k个状态中找到最值

关键点：
1.最优子结构 opt[n] = best_of(opt[n-1], opt[n-2], ...)
2.储存中间状态： opt[i]
3.递推公式（状态转移方程或DP方程）
Fib: opt[i] = opt[n-1] + opt[n-2]

##### 典型场景递推公式

爬楼梯
``` Java
dp[i] // 状态数组 i步数
dp[i] = dp[i - 1] + dp[i - 2]
```

不同路径
``` Java
dp[i][j] // 状态数组 i表示x坐标   j表示y坐标
dp[i, j] = dp[i - 1][j] + dp[i][j - 1]
```

不同路径2
``` Java
dp[i][j] // 状态数组 i表示x坐标   j表示y坐标
if (arr[i][j] == 1) {
    dp[i][j] = 0; // 遇到障碍就是0
} else {
    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // dpdpdp
}
```

打家劫舍
``` Java
// 方法一
dp[i] // 偷第i个房屋
dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])

// 方法二
dp[i][0] // 第i天 0 没偷 nums[i]
dp[i][1] // 第i天 1 偷了 nums[i]
dp[i][0] = max(dp[i - 1][0], dp[i - 1][1]);
dp[i][1] = dp[i - 1][0] + nums[i]
```

最小路径和
``` Java
dp[i][j] // 1-i 和 1-j 最小的路径
dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + arr[i][j]
```

股票买卖
``` Java
dp[i][k][0 or 1] // i 天数 k 最多交易次数 [0,1]是否持有股票
dp[i][k][s] = max(buy, sell, rest)

dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
// max (选 rest, 选 sell)
// 今天我没持有股票, 有两种可能
// -昨天就没持有, 今天选rest, 所以今天还是没有持有;
// -昨天持有股票, 但今天sell, 所以今天没有持有股票;
dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] + prices[i])
// max (选 rest, 选 buy)
// -昨天持有股票, 今天选rest, 所以今天还持有股票
// -昨天本没持有, 但今天buy, 所以今天就持有股票了
```

##### 高级DP
复杂度来源
1.状态拥有更多维度（二维、三维、或者更多、甚至需要压缩）
2.状态方程更加复杂
本质：内功、逻辑思维、数学

爬楼梯改进
1.步数1、2、3
2.x1, x2, ..., xm 步
3.不能走相同步

编辑距离-典型的字符串比较
如果word1[i]与word2[j]相同，显然dp[i][j]=dp[i-1][j-1]
如果word1[i]与word2[j]不同，那么dp[i][j]可以通过
1.在dp[i-1][j-1]的基础上做replace操作达到目的
2.在dp[i-1][j]的基础上做insert操作达到目的
3.在dp[i][j-1]的基础上做delete操作达到目的
取三者最小情况即可

##### 字符串算法

字符串不同语言定义可变性
java python go JavaScript string immutable不可变
ruby php c c++ string mutable可变

字符串基础问题
1.字符串遍历
2.字符串比较  x==y 比较指针  x.equals(y) 比较内容
3.First unique 不重复查找
4.Atoi 整数转换

字符串操作问题
1.Longest common prefix 最长公共前缀
2.Reverse string 字符串翻转
3.Anagram 异位词问题
4.Palindrome 回文串问题

##### 高级字符串算法
最长子串、子序列问题
1.最长子序列
``` Java
dp[i][j] // i word1.substr(0,i) j word2.substr(0,j)
if word1[i-1]==word2[j-1]
    dp[i][j] = dp[i-1][j-1] + 1
else
    dp[i][j] = max(dp[i-1][j], dp[i][j-1])
```
2.最长子串
``` Java
dp[i][j] // i word1.substr(0,i) j word2.substr(0,j)
if word1[i-1]==word2[j-1]
    dp[i][j]=dp[i-1] + 1
else
    dp[i][j] = 0
```

3.编辑距离
``` Java
dp[i][j] // i word1.substr(0,i) j word2.substr(0,j)
if word1[i] == word1[j]
    dp[i,j] = dp[i-1][j-1]
else
    dp[i,j] = MIN(dp[i-1][j-1] + 1, dp[i-1][j] + 1, dp[i][j-1] + 1)
```
4.最长回文子串
a.枚举从中心扩散 奇偶数长度
b.dp
``` Java
dp[i][j] // i 起点 j 终点  dp[i][j] = true 是回文串 false 不是回文串
if s[i] == s[j] //只要s[i] == s[j] 就可以继续扩散
    dp[i,j] = dp[i+1][j-1]
```
c.Manacher算法

5.通配符匹配问题
``` Java
dp[i][j] // i word1.substr(0,i) j word2.substr(0,j) = true 可以匹配 false 不能匹配

// 如果 word1 的第 i 个字符和 word2 的第 j 个字符相同，或者 word2 的第 j 个字符为 “.”
dp[i][j] = dp[i - 1][j - 1]
// 如果 word2 的第 j 个字符为 *
// --如果 word2 的第 j 个字符匹配空串 
        dp[i][j] = dp[i][j - 1]
// --如果 word2 的第 j 个字符匹配 word1 的第 i 个字符
        dp[i][j] = dp[i - 1][j]
```

6.不同子序列出现个数
``` Java    
dp[i][j] // T前i字符串可以由s前j字符串组成最多匹配的个数
// 如果 S[j]==T[i]
    dp[i][j] = dp[i-1][j-1] + dp[i][j-1]
// 如果 S[j]!=T[i]
    dp[i][j] = dp[i][j - 1]
```

##### 字符串匹配算法
暴力法(brute force)
``` Java
public static int forceSearch(String txt, String pat) {
    int M = txt.length();
    int N = pat.length();
    for (int i = 0; i <= M - N; i++) {
        int j;
        for (j = 0; j < N; j++) {
            if(txt.charAt(i + j)!= pat.charAt(j))
                break;
        }
        if (j == N) {
            return i;
        }
    }
    return -1;
}
```

Rabin-Karp算法
1.假设子串的长度为M(pat),目标字符串的长度为N(txt)
2.计算子串的hash值hash_pat
3.计算目标字符串txt中每个长度为M的子串的hash值(共需要计算N-M+1次)
4.比较hash值：如果hash值不同，字符串必然不匹配；如果hash值相同，还需要使用朴素算法再次判断
``` Java
public final static int D = 256; //256个字符 每位的权重是256相应的次方
public final static int Q = 9997;//素数取模

static int RabinKarpSearch(String txt, String pat) {
    int M = pat.length();
    int N = txt.length();
    int i, j;
    int patHash = 0, txtHash = 0;

    for (int i = 0; i < M; i++) {
        patHash = (D * patHash + pat.charAt(i)) % Q;
        txtHash = (D * txtHash + txt.charAt(i)) % Q;
    }

    int highestPow = 1; // pow(256, M-1) 最高位权重
    for (int i = 0; i < M -1; i++) {
        highestPow = (highestPow * D) % Q;
    }
    for (int i = 0; i <= N - M; i++) { //枚举起点
        if (patHash == txtHash) {
            for(int j = 0; j < M; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }
            if (j == M) {
                return i;
            }
        }
        if (i < N - M) {//如果不相等去除最高位权重，在加滑动窗口后新增最低位的权重 O(1)时间复杂度
            txtHash = (D * (txtHash - txt.charAt(i) * highestPow + txt.charAt(i + M))) % Q;
            if (txtHash < 0) {
                txtHash += Q;
            }
        }
    }
}
```

KMP算法-最大前后缀匹配
KMP算法是一种改进的字符串匹配算法，由D.E.Knuth，J.H.Morris和V.R.Pratt提出的，因此人们称它为克努特—莫里斯—普拉特操作（简称KMP算法）。KMP算法的核心是利用匹配失败后的信息，尽量减少模式串与主串的匹配次数以达到快速匹配的目的。具体实现就是通过一个next()函数实现，函数本身包含了模式串的局部匹配信息。KMP算法的时间复杂度O(m+n)。

Boyer-Moore算法
KMP在匹配过程中从左至右与主串字符做比较，Boyer-Moore算法是从模式串的尾字符开始从右至左做比较。下面讨论的一些递推式都与BM算法的这个特性有关。

Sunday算法
Sunday算法由Daniel M.Sunday在1990年提出，它的思想跟BM算法很相似。只不过Sunday算法是从前往后匹配，在匹配失败时关注的是主串中参加匹配的最末位字符的下一位字符。
1.如果该字符没有在模式串中出现则直接跳过，即移动位数 = 模式串长度 + 1；
2.否则，其移动位数 = 模式串长度 - 该字符最右出现的位置(以0开始) = 模式串中该字符最右出现的位置到尾部的距离 + 1。
