'''
51. N皇后
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

示例:

输入: 4
输出: [
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
解释: 4 皇后问题存在两个不同的解法。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-queens
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
'''

'''
class Solution:
    def solveNQueens(self, n):
        res = []
  
        # 回溯实现：
        # queens和xy_diff、xy_sum在DFS递归的本层都没有被改变，只是复制了一份到
        # 下一层的递归调用函数，所以当下一层循环完成后回到本层，这些列表值并没有被改变
        # p: 行
        # q：列
    
        def DFS(queens, xy_dif, xy_sum):
            p = len(queens)
            print('p={},queens:{},xy_dif:{},xy_sum:{}'.format(p,queens,xy_dif,xy_sum))
            if p == n:
                res.append(queens)
                return None
            for q in range(n):
                print("**********************q=",q)
                if q not in queens and (p - q) not in xy_dif and (p + q) not in xy_sum:
                    DFS(queens + [q], xy_dif + [p - q], xy_sum + [p + q])
                print('###########queens:{}'.format(queens))
        DFS([], [], [])
        print('res:{}'.format(res))
        return [['.' * i + 'Q' + '.' * (n - i - 1) for i in sol] for sol in res]

class Solution:
    def solveNQueens(self, n):
        stack, res = [[(0, i)] for i in range(n)], []
        print(stack)
        while stack:
            board = stack.pop()
            row = len(board)
            print('***************')
            print('board={},row={}'.format(board, row))
            if row == n:
                res.append([''.join('Q' if i == c else '.' for i in range(n))
                            for r, c in board])
            for col in range(n):
                print('col={}'.format(col))
                # for r, c in board:
                #     print('r={},c={}'.format(r, c))
                if all(col != c and abs(row - r) != abs(col - c) for r, c in board):
                    # print()
                    stack.append(board +[(row, col)])
                    print(stack)
        return res
 '''

'''

'''
class Solution:
    def solveNQueens(self, n):
        ans = []
        queens = [-1] * n
        columns = [True] * n + [False] #col with dummy for boundary
        print('columns:{}'.format(columns))
        back = [True] * n * 2       # col - row,主对角线
        print('back:{}'.format(back))
        forward = [True] * n * 2    #row + col，副对角线
        row = col = 0
        while True:
            print('***********************')
            print('col={},row={},queens:{}'.format(col, row, queens))
            # print('columns:{}'.format(columns))
            # print('back:{}'.format(back))
            # print('forward:{}'.format(forward))
            if columns[col] and back[col - row + n] and forward[col + row]:
                queens[row] = col
                columns[col] = back[col - row + n] = forward[col + row] = False
                row += 1
                col = 0
                if row == n:
                    print('queens:{}'.format(queens))
                    ans.append(['.' * q + 'Q' + '.' * (n - q - 1) for q in queens])
            else:
                if col == n or row == n:
                    if row == 0:
                        return ans
                    row -= 1
                    col = queens[row]
                    columns[col] = back[col - row + n] = forward[col + row] = True
                col += 1


n = 4
tmp = Solution()
print(tmp.solveNQueens(n))

