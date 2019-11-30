'''
37、解数独
编写一个程序，通过已填充的空格来解决数独问题。
一个数独的解法需遵循如下规则：
数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
空白格用 '.' 表示。

Note:
给定的数独序列只包含数字 1-9 和字符 '.' 。
你可以假设给定的数独只有唯一解。
给定数独永远是 9x9 形式的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sudoku-solver
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
'''
# class Solution:
#     def isValid(self, unit):
#         seen = sum(
#             ([(i, c), (c, j), (i // 3, j // 3, c)]
#             for i in range(9) for j in range(9)
#             for c in unit[i][j] if c != '.'), []
#         )
#
#     def solveSudoku(self, board):
#         res = board
#         dic = ['1', '2', '3', '4', '5', '6', '7', '8', '9']
#         for i in (0, 3, 6):
#             for j in(0, 3, 6):
#                 for x in range(i, i + 3):
#                     for y in range(j, j + 3):
#                         if res[x][y] == '.':
#                             for i in dic:
#                                 res[x][y] = i
#                                 if self.isValid(res):
#                                     self.solveSudoku(res)
#         return res
'''
from collections import defaultdict
class Solution:
    def solveSudoku(self, board):
        """
        :type board:List[List[str]]
        :rtype: void do not return anying, modify board in-place instead
        """
        def could_place(d, row, col):
            """
            check if one could place a number d in(row, col) cell
            :param d:
            :param row:
            :param col:
            :return:
            """
            return not (d in rows[row] or d in columns[col]
                        or d in boxes[box_index(row, col)])

        def place_number(d, row, col):
            rows[row][d] += 1
            columns[col][d] += 1
            boxes[box_index(row, col)][d] += 1
            board[row][col] = str(d)

        def remove_number(d, row, col):
            del rows[row][d]
            del columns[col][d]
            del boxes[box_index(row, col)][d]
            board[row][col] = '.'

        def place_next_number(row, col):
            if col == N - 1 and row == N - 1:
                nonlocal sudoku_solved
                sudoku_solved = True
            else:
                if col == N - 1:
                    backtrack(row + 1, 0)
                else:
                    backtrack(row, col + 1)

        def backtrack(row = 0, col = 0):
            if board[row][col] == '.':
                for d in range(1, 10):
                    if could_place(d, row, col):
                        place_number(d, row, col)
                        place_next_number(row, col)
                        if not sudoku_solved:
                            remove_number(d, row, col)
            else:
                place_next_number(row, col)

        n = 3
        N = n * n
        box_index = lambda x, y: (x // n) * n + (y // n)
        rows = [defaultdict(int) for i in range(N)]
        print(rows)
        columns = [defaultdict(int) for i in range(N)]
        print(columns)
        boxes = [defaultdict(int) for i in range(N)]
        for i in range(N):
            for j in range(N):
                if board[i][j] != '.':
                    d = int(board[i][j])
                    place_number(d, i, j)
        sudoku_solved = False
        backtrack()
'''
from collections import defaultdict
class Solution:
    def solveSudoku(self, board):
        rows, cols, triples, visited = defaultdict(set), defaultdict(set), defaultdict(set), []
        for r in range(9):
            for c in range(9):
                if board[r][c] != '.':
                    rows[r].add(board[r][c])
                    cols[c].add(board[r][c])
                    triples[(r // 3, c // 3)].add(board[r][c])
                else:
                    visited.append((r, c))
        def BFS():
            if not visited:
                return True
            r, c = visited[0]
            t = (r // 3, c // 3)
            for dig in ['1', '2', '3', '4', '5', '6', '7', '8', '9']:
                if dig not in rows[r] and dig not in cols[c] and dig not in triples[t]:
                    board[r][c] = dig
                    rows[r].add(dig)
                    cols[c].add(dig)
                    triples[t].add(dig)
                    visited.pop(0)
                    if BFS():
                        return True
                    else:
                        board[r][c] = '.'
                        rows[r].discard(dig)
                        cols[c].discard(dig)
                        triples[t].discard(dig)
                        visited.insert(0,(r, c))
            return False
        BFS()

'''
JAVA 1ms改写python版
有问题

import numpy as np
class Solution:
    ALL_ZEROS = 0
    ALL_ONES = 0x3FE
    row_bitmap, col_bitmap, cube_bitmap = np.zeros(9, dtype=int), np.zeros(9, dtype=int), np.zeros(9, dtype=int)
    entry, sequence = np.empty(81, dtype=int), np.empty(81, dtype=int)
    square_to_row, square_to_col, square_to_cube = \
        np.empty(81, dtype=int), np.empty(81, dtype=int), np.empty(81, dtype=int)
    seq_start = 0

    def solveSudoku(self,board):
        row_bitmap, col_bitmap, cube_bitmap = np.zeros(9, dtype=int), np.zeros(9, dtype=int), np.zeros(9, dtype=int)
        entry = np.empty(81, dtype=int)
        square_to_row, square_to_col, square_to_cube = \
            np.empty(81, dtype=int), np.empty(81, dtype=int), np.empty(81, dtype=int)
        seq_start = 0
        # for i in range(9):
        #     row_bitmap[i] = col_bitmap[i] = cube_bitmap[i] = self.ALL_ONES

        for i in range(81):
            self.sequence[i] = i

        for i in range(9):
            for j in range(9):
                square = i * 9 + j
                square_to_row[square] = i
                square_to_col[square] = j
                square_to_cube[square] = (i // 3) * 3 + j // 3

        for i in range(9):
            for j in range(9):
                if board[i][j] != '.':
                    tmp = i * 9 + j
                    val = int(board[i][j])
                    valbit = 1 << val
                    row_bitmap[i] &= (~valbit)
                    col_bitmap[j] &= (~valbit)
                    cube_bitmap[i // 3 +j // 3] &= (~valbit)
                    entry[tmp] = valbit
                    seq_iter = seq_start
                    while seq_iter < 81 and self.sequence[seq_iter] != tmp:
                        seq_iter += 1

                    if seq_start < 81 and seq_iter < 81:
                        self.swapSeq(seq_start, seq_iter)
                    seq_start += 1
                    success = self.place(seq_start)
                    if not success:
                        exit()
                    for s in range(81):
                        i = square_to_row[s]
                        j = square_to_col[s]
                        board[i][j] = str(self.numberOfTrailingZeros(i))

    def place(self, seq_pos):
        if seq_pos >= 81:
            return True
        seq_next = self.nextPos(seq_pos)
        self.swapSeq(seq_pos, seq_next)
        square = self.sequence[seq_pos]
        row_idx = self.square_to_row[square]
        col_idx = self.square_to_col[square]
        cube_idx = self.square_to_cube[square]
        cell_bitmap = self.row_bitmap[row_idx] & self.col_bitmap[col_idx] & self.cube_bitmap[cube_idx]
        while cell_bitmap > 0:
            next_digit_bit = cell_bitmap & -cell_bitmap
            cell_bitmap &= ~next_digit_bit
            self.entry[square] = next_digit_bit
            self.row_bitmap[row_idx] &= ~next_digit_bit
            self.col_bitmap[col_idx] &= ~next_digit_bit
            self.cube_bitmap[cube_idx] &= ~next_digit_bit

            if self.place(seq_pos + 1):
                return True

            self.row_bitmap[row_idx] |= next_digit_bit
            self.col_bitmap[col_idx] |= next_digit_bit
            self.cube_bitmap[cube_idx] |= next_digit_bit
            self.entry[square] = self.ALL_ZEROS
        self.swapSeq(seq_pos, seq_next)
        return False


    def nextPos(self, pos):
        min_idx = pos
        min_digit_count = 100
        for i in range(pos, 81):
            square = self.sequence[i]
            cell_bitmap = self.row_bitmap[self.square_to_row[square]] & self.col_bitmap[self.square_to_col[square]] \
                          & self.cube_bitmap[self.square_to_cube[square]]
            num_possible_digit = self.bitCount(cell_bitmap)
            if num_possible_digit < min_digit_count:
                min_idx = i
                min_digit_count = num_possible_digit
        return min_idx


    def swapSeq(self, s1, s2):
        # tmp = self.sequence[s1]
        # self.sequence[s1] = self.sequence[s2]
        # self.sequence[s2] = tmp
        self.sequence[s1], self.sequence[s2] = self.sequence[s2], self.sequence[s1]



    def numberOfTrailingZeros(self, i):
        i = int(i)
        if i == 0:
            return 32
        n = 31
        y = i << 16
        if y != 0:
            n = n - 16
            i = y
        y = i << 8
        if y != 0:
            n = n - 8
            i = y
        y = i << 4
        if y != 0:
            n = n - 4
            i = y
        y = i << 2
        if y != 0:
            n = n - 2
            i = y
        return n - ((i << 1) >> 31)

    def bitCount(self, i):
        i = int(i)
        i = i - ((i >> 1) & 0x55555555)
        i = (i & 0x33333333) + ((i >> 2) & 0x33333333)
        i = (i + (i >> 4)) & 0x0f0f0f0f
        i = i + (i >> 8)
        i = i + (i >> 16)
        return i & 0x3f
'''






board = [["5","3",".",".","7",".",".",".","."],
         ["6",".",".","1","9","5",".",".","."],
         [".","9","8",".",".",".",".","6","."],
         ["8",".",".",".","6",".",".",".","3"],
         ["4",".",".","8",".","3",".",".","1"],
         ["7",".",".",".","2",".",".",".","6"],
         [".","6",".",".",".",".","2","8","."],
         [".",".",".","4","1","9",".",".","5"],
         [".",".",".",".","8",".",".","7","9"]]
tmp = Solution()
tmp.solveSudoku(board)
print('board:{}'.format(board))
