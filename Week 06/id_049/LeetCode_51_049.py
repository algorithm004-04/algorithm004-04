# https://leetcode-cn.com/problems/n-queens/
class Solution:
    def solveNQueens(self, n):
        self.res = []
        self.cols = set()
        self.pie = set()
        self.na = set()
        self.DFS(n, 0, [])
        return self.generate_result(n)

    def DFS(self, n, row, cur_state):
        if row >= n:
            self.res.append(cur_state)
            return
        for col in range(n):
            if col in self.cols or row + col in self.pie or row - col in self.na:
                continue
            self.cols.add(col)
            self.pie.add(row + col)
            self.na.add(row - col)

            self.DFS(n, row + 1, cur_state + [col])

            self.cols.remove(col)
            self.pie.remove(row + col)
            self.na.remove(row - col)

    def generate_result(self, n):
        board = []
        for res in self.res:
            for i in res:
                board.append("." * i + "Q" + "." * (n - i -1))
        return [board[i: i+n] for i in range(0, len(board), n)]