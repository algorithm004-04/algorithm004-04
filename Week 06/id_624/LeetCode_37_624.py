#
# @lc app=leetcode.cn id=37 lang=python3
#
# [37] 解数独
#
# https://leetcode-cn.com/problems/sudoku-solver/description/
#
# algorithms
# Hard (57.05%)
# Likes:    265
# Dislikes: 0
# Total Accepted:    14K
# Total Submissions: 24.1K
# Testcase Example:  '[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]'
#
# 编写一个程序，通过已填充的空格来解决数独问题。
# 
# 一个数独的解法需遵循如下规则：
# 
# 
# 数字 1-9 在每一行只能出现一次。
# 数字 1-9 在每一列只能出现一次。
# 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
# 
# 
# 空白格用 '.' 表示。
# 
# 
# 
# 一个数独。
# 
# 
# 
# 答案被标成红色。
# 
# Note:
# 
# 
# 给定的数独序列只包含数字 1-9 和字符 '.' 。
# 你可以假设给定的数独只有唯一解。
# 给定数独永远是 9x9 形式的。
# 
# 
#

# @lc code=start
class Solution:
    def solveSudoku(self, board: [[str]]) -> None:
        col = [set(range(1, 10)) for _ in range(9)]
        row = [set(range(1, 10)) for _ in range(9)]
        blo = [set(range(1, 10)) for _ in range(9)]
        empty = []
        
        for i in range(9):
            for j in range(9):
                cur = board[i][j]
                if cur != '.':
                    for p in (col[i], row[j], blo[j//3*3 + i//3]): p.remove(int(cur))
                else:
                    empty.append((i, j))
        
        def dfs(level=0):
            if level == len(empty): return True
            i, j = empty[level]
            b = j//3*3 + i//3

            for val in col[i] & row[j] & blo[b]:
                board[i][j] = str(val)
                for p in (col[i], row[j], blo[b]): p.remove(val)
                if dfs(level+1): return True
                for p in (col[i], row[j], blo[b]): p.add(val)
            return False
        
        dfs()

# @lc code=end

