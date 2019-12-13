class Solution:
    def totalNQueens(self, n):


        def is_not_under_attack(row, col):
            return not (rows[col] or hills[row - col] or dales[row + col])

        def place_queen(row, col):
            rows[col] = 1
            hills[row - col] = 1
            dales[row + col] = 1

        def remove_queen(row, col):
            rows[col] = 0
            hills[row - col] = 0
            dales[row + col] = 0

        def backtrack(row=0, count=0):
            for col in range(n):
                if is_not_under_attack(row, col):
                    place_queen(row, col)
                    if row + 1 == n:
                        count += 1
                    else:
                        count = backtrack(row + 1, count)
                    remove_queen(row, col)
            return count

        rows = [0] * n
        hills = [0] * (2 * n - 1) 
        dales = [0] * (2 * n - 1)
        return backtrack()


