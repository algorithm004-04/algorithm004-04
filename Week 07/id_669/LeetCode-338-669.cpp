/*
 * @lc app=leetcode.cn id=338 lang=cpp
 *
 * [338] 比特位计数
 *
 * https://leetcode-cn.com/problems/counting-bits/description/
 *
 * algorithms
 * Medium (73.52%)
 * Likes:    204
 * Dislikes: 0
 * Total Accepted:    20.6K
 * Total Submissions: 28.1K
 * Testcase Example:  '2'
 *
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * 
 * 示例 1:
 * 
 * 输入: 2
 * 输出: [0,1,1]
 * 
 * 示例 2:
 * 
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 
 * 进阶:
 * 
 * 
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 * 
 * 
 */

// @lc code=start
// 解法一
// 奇偶判断
// 奇数： 上一个偶数+1
// 0 ==> 0 0;    1 ==> 0 1
// 2 ==> 1 0;    3 ==> 1 1

// 偶数： 上一个偶数/2
// 2 ==> 1 0;    4 ==> 1 0 0;   8 ==> 1 0 0 0
// 6 ==> 1 1 0;  12 ==>  1 1 0 0  24 ==> 1 1 0 0 0     
class Solution {
public:
    vector<int> countBits(int num) {
        vector<int> ans(num+1, 0);

        for (int i = 1; i <= num; ++i) {
            if ((i & 1) == 0) {
                ans[i] = ans[i/2];
            } else {
                ans[i] = ans[i-1] + 1;
            }
        }

        return ans;
    }
};

// 解法二
// Y = X & (X-1) 清零最低位的1
// 因为Y < X， 所以Y是计算过的
// 所以要计算X， 就等于Y的值+1
class Solution {
public:
    vector<int> countBits(int num) {
        vector<int> ans(num+1, 0);

        for (int i = 1; i <= num; ++i) {
            ans[i] += ans[i & (i - 1)] + 1;
        }

        return ans;
    }
}
// @lc code=end

