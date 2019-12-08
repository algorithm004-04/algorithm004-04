#
# @lc app=leetcode.cn id=51 lang=python3
#
# [51] N皇后
#
# https://leetcode-cn.com/problems/n-queens/description/
#
# algorithms
# Hard (65.82%)
# Likes:    248
# Dislikes: 0
# Total Accepted:    16.8K
# Total Submissions: 25.3K
# Testcase Example:  '4'
#
# n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
# 
# 
# 
# 上图为 8 皇后问题的一种解法。
# 
# 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
# 
# 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
# 
# 示例:
# 
# 输入: 4
# 输出: [
# ⁠[".Q..",  // 解法 1
# ⁠ "...Q",
# ⁠ "Q...",
# ⁠ "..Q."],
# 
# ⁠["..Q.",  // 解法 2
# ⁠ "Q...",
# ⁠ "...Q",
# ⁠ ".Q.."]
# ]
# 解释: 4 皇后问题存在两个不同的解法。
# 
# 
#

# @lc code=start
class Solution:
    def solveNQueens(self, n: int) -> [[str]]:
        res, queues = [], []
        dale, hill, colset = set(), set(), set()

        def canplace(col: int, row: int) -> bool:
            return row - col not in dale and row + col not in hill and col not in colset

        def placeQueue(col: int, row: int):
            queues.append((col, row))
            dale.add(row - col)
            hill.add(row + col)
            colset.add(col)

        def removeQueue(col: int, row: int):
            queues.remove((col, row))
            colset.remove(col)
            dale.remove(row - col)
            hill.remove(row + col)

        def addSolution():
            sol = []
            for col, _ in queues:
                row = ""
                for i in range(n):
                    if i == col:
                        row += "Q"
                    else:
                        row += "."
                sol.append(row)
            res.append(sol)

        def backtrace(row=0):
            # 遍历每一列
            for col in range(n):
                # 如果可以放入
                if canplace(col, row):
                    # 放入
                    placeQueue(col, row)
                    # 如果到达最后一行，就说明得到一个解，将解加入输出结果中
                    if row == n-1: 
                        addSolution()
                    else:
                        # 进入下一行
                        backtrace(row + 1)
                    # 当成功得到一个解或者一行遍历完都没有一个可以填入都空位，就移除上一次填入都皇后。这里稍微难理解，注意这一行代码只有在成功找到一个解或某一列整体都没有解都情况才会执行。如果找到解那么移除最后一次填入的皇后之后会回溯一步，并尝试寻找下一个可以填入的列，如果没有则会继续回溯。
                    removeQueue(col, row)
                    
        backtrace()
        return res

# @lc code=end

Solution().solveNQueens(4)
