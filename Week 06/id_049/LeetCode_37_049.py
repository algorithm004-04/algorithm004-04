class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        row = [set(range(1, 10)) for _ in range(9)]
        col = [set(range(1, 10)) for _ in range(9)]
        block = [set(range(1, 10)) for _ in range(9)]

        empty = []
        for i in range(9):
            for j in range(9):
                if board[i][j] != '.':
                    num = int(board[i][j])
                    row[i].remove(num)
                    col[i].remove(num)
                    block[(i // 3) * 3 + j // 3].remove(num)
                else:
                    empty.append((i, j))

        def backtrack(iter=0):
            if iter == len(empty):
                return True
            i, j = empty[iter]
            b = (i // 3) * 3 + j // 3
            for val in row[i] & col[j] & block[b]:
                row[i].remove(val)
                col[j].remove(val)
                block[b].remove(val)
                board[i][j] = str(val)
                if backtrack(iter+1):
                    return True
                row[i].add(val)
                col[j].add(val)
                block[b].add(val)
            return False
        backtrack()


