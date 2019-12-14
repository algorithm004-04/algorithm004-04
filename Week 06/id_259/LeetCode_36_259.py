'''
36. 有效的数独
判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
数独部分空格内已填入了数字，空白格用 '.' 表示。

示例 1:
输入:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
输出: true
示例 2:
输入:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
输出: false
解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
说明:
一个有效的数独（部分已被填充）不一定是可解的。
只需要根据以上规则，验证已经填入的数字是否有效即可。
给定数独序列只包含数字 1-9 和字符 '.' 。
给定数独永远是 9x9 形式的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-sudoku
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
'''

'''
方法：一次迭代
复杂度分析
时间复杂度：O(1)，因为我们只对 81 个单元格进行了一次迭代。
空间复杂度：O(1)。

class Solution:
    def isValidSudoku(self, board):
        rows = [{} for i in range(9)]
        columns = [{} for i in range(9)]
        boxes = [{} for i in range(9)]
        print('rows:{}'.format(rows))
        for i in range(9):
            for j in range(9):
                if board[i][j] != '.':
                    num = int(board[i][j])
                    box_index = (i // 3) * 3 + (j // 3)
                    rows[i][num] = rows[i].get(num, 0) + 1
                    columns[j][num] = columns[j].get(num, 0) + 1
                    boxes[box_index][num] = boxes[box_index].get(num, 0) + 1
                    print('rows:{}'.format(rows))
                    print('columns:{}'.format(columns))
                    print('boxes:{}'.format(boxes))

                    if rows[i][num] > 1 or columns[j][num] > 1 or boxes[box_index][num] > 1:
                        return False
        return True
'''
'''
class Solution:
    def isValidSudoku(self, board):
        return (self.is_row_valid(board) and
                self.is_col_valid(board) and
                self.is_box_valid(board))
    def is_row_valid(self, board):
        for row in board:
            if not self.is_unit_valid(row):
                return False
        return True
    def is_col_valid(self, board):
        # print(zip(*board))
        for col in zip(*board):
            # print(col)
            if not self.is_unit_valid(col):
                return False
        return True
    def is_box_valid(self, board):
        for i in range(0, 7, 3):
            for j in range(0, 7, 3):
        #for i in (0, 3, 6):
            #for j in (0, 3, 6):
                print('i={},j={}'.format(i,j))
                square = [board[x][y] for x in range(i, i + 3) for y in range(j, j + 3)]
                # print(square)
                if not self.is_unit_valid(square):
                    return False
        return True
    def is_unit_valid(self, unit):
        unit = [i for i in unit if i != '.']
        return len(set(unit)) == len(unit)
'''
'''
class Solution:
    def isValidSudoku(self, board):
        big = set()
        for i in range(0, 9):
            for j in range(0, 9):
                if board[i][j] != '.':
                    curr = board[i][j]
                    # print((i // 3, j // 3, curr))
                    if (i, curr) in big or (curr, j) in big or(i // 3, j // 3, curr) in big:
                        return False
                    big.add((i, curr))
                    big.add((curr, j))
                    big.add((i // 3, j // 3, curr))
        return True
'''
# import collections
# class Solution:
#     def isValidSudoku(self, board):
#         seen=set()
#         return not any(x in seen or seen.add(x)
#                    for i, row in enumerate(board)
#                    for j, c in enumerate(row)
#                    if c != '.'
#                    for x in ((c, i), (j, c), (i//3, j//3, c)))
#
# class Solution:
#     def isValidSudoku(self, board):
#         seen = sum(([(c, i), (j, c), (i // 3, j // 3, c)]
#                     for i, row in enumerate(board)
#                     for j, c in enumerate(row)
#                     if c != '.'), [])
#         return len(seen) == len(set(seen))

class Solution:
    def isValidSudoku(self, board):
        seen = sum(
            ([(i, c), (c, j), (i // 3, j // 3, c)]
             for i in range(9) for j in range(9)
             for c in board[i][j] if c != '.'), []
        )
        print(seen)
        return len(seen) == len(set(seen))

# board = [["5","3",".",".","7",".",".",".","."],
#          ["6",".",".","1","9","5",".",".","."],
#          [".","9","8",".",".",".",".","6","."],
#          ["8",".",".",".","6",".",".",".","3"],
#          ["4",".",".","8",".","3",".",".","1"],
#          ["7",".",".",".","2",".",".",".","6"],
#          [".","6",".",".",".",".","2","8","."],
#          [".",".",".","4","1","9",".",".","5"],
#          [".",".",".",".","8",".",".","7","9"]]

board = [[".",".",".",".","5",".",".","1","."],
         [".","4",".","3",".",".",".",".","."],
         [".",".",".",".",".","3",".",".","1"],
         ["8",".",".",".",".",".",".","2","."],
         [".",".","2",".","7",".",".",".","."],
         [".","1","5",".",".",".",".",".","."],
         [".",".",".",".",".","2",".",".","."],
         [".","2",".","9",".",".",".",".","."],
         [".",".","4",".",".",".",".",".","."]]
tmp = Solution()
print(tmp.isValidSudoku(board))


