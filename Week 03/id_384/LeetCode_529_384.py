class Solution:
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        i, j = click[0], click[1]
        if board[i][j] == 'M':
            board[i][j] = 'X'
            return board
        q = [(i, j)]
        tt = []
        m = 0
        ll = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]
        while q:
            x, y = q.pop(0)
            if board[x][y] != 'E':
                continue
            for l in ll:
                dx = x + l[0]
                dy = y + l[1]
                if 0 <= dx < len(board) and 0 <= dy < len(board[0]):
                    if board[dx][dy] == 'M':
                        m += 1
                    else:
                        tt.append((dx, dy))
            if m:
                board[x][y] = str(m)
                m = 0
            else:
                board[x][y] = 'B'
                q.extend(tt)
            tt = []
        return board
