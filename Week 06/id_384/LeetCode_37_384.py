class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        self.row = [set(range(1, 10)) for _ in range(9)]
        self.col = [set(range(1, 10)) for _ in range(9)]
        self.box = [set(range(1, 10)) for _ in range(9)]
        empty = []
        for i in range(9):
            for j in range(9):
                if board[i][j] != '.':
                    num = int(board[i][j])
                    self.row[i].remove(num)
                    self.col[j].remove(num)
                    self.box[(i // 3) * 3 + j // 3].remove(num)
                else:
                    empty.append((i, j))
        self.xun(board, 0, empty)

    def xun(self, board, level, empty):
        if level == len(empty):
            return True
        i, j = empty[level]
        b = (i // 3) * 3 + j // 3
        for num in self.row[i] & self.col[j] & self.box[b]:
            self.row[i].remove(num)
            self.col[j].remove(num)
            self.box[b].remove(num)
            board[i][j] = str(num)
            if self.xun(board, level + 1, empty):
                return True
            self.row[i].add(num)
            self.col[j].add(num)
            self.box[b].add(num)
        return False

