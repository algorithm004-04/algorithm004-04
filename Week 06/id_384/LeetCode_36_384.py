class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row = [{} for i in range(9)]
        col = [{} for i in range(9)]
        box = [{} for i in range(9)]
        for i in range(9):
            for j in range(9):
                if board[i][j] != '.':
                    num = int(board[i][j])
                    row[i][num] = row[i].get(num, 0) + 1
                    col[j][num] = col[j].get(num, 0) + 1
                    box_index = (i // 3) * 3 + j // 3
                    box[box_index][num] = box[box_index].get(num, 0) + 1
                    if row[i].get(num) > 1 or col[j].get(num) > 1 or box[box_index].get(num) > 1:
                        return False
        return True
