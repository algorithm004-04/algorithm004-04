#
# @lc app=leetcode.cn id=70 lang=python3
#
# [70] 爬楼梯
#
# https://leetcode-cn.com/problems/climbing-stairs/description/
#
# algorithms
# Easy (46.86%)
# Likes:    665
# Dislikes: 0
# Total Accepted:    89.8K
# Total Submissions: 191.5K
# Testcase Example:  '2'
#
# 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
# 
# 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
# 
# 注意：给定 n 是一个正整数。
# 
# 示例 1：
# 
# 输入： 2
# 输出： 2
# 解释： 有两种方法可以爬到楼顶。
# 1.  1 阶 + 1 阶
# 2.  2 阶
# 
# 示例 2：
# 
# 输入： 3
# 输出： 3
# 解释： 有三种方法可以爬到楼顶。
# 1.  1 阶 + 1 阶 + 1 阶
# 2.  1 阶 + 2 阶
# 3.  2 阶 + 1 阶
# 
# 
#

# @lc code=start
class Solution:
    def climbStairs(self, n: int) -> int:
        if n <= 2: return n
        f1, f2, res = 1, 2, 3
        for _ in range(3, n+1) :
            res = f1 + f2
            f1 = f2
            f2 = res
        return res

    # 递归方法
    # def climbStairs(self, n: int) -> int:
    #     if n < 3: return n
    #     return self.climbStairs(n-1) + self.climbStairs(n-2)

# @lc code=end

