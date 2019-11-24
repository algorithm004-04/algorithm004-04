class Solution:
    def solve(self, board: List[List[str]]) -> None:


        if not board: return

        row = len(board)
        col = len(board[0])

        if row < 3 or col < 3: return


        def dfs(i, j):

            if i < 0 or j < 0 or i >= row or j >= col or board[i][j] != 'O':
                return

            board[i][j] = '#'

            dfs(i - 1, j)
            dfs(i + 1, j)
            dfs(i, j - 1)
            dfs(i, j + 1)

        for i in range(row):

            dfs(i, 0)
            dfs(i, col - 1)

        for i in range(col):

            dfs(0, i)
            dfs(row - 1, i)

        for i in range(0, row):
            for j in range(0, col):
                if board[i][j] == 'O':
                    board[i][j] = 'X'
                if board[i][j] == '#':
                    board[i][j] = 'O'

