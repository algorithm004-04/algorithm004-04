class Solution {
    private int[] rows = new int[9];
private int[] columns = new int[9];
private int[] boxes = new int[9];

public boolean isValidSudoku(char[][] board) {
    for (int row = 0; row < 9; row++) {
        for (int column = 0; column < 9; column++) {
            char c = board[row][column];
            if (c == '.') {
                continue;
            }
            int val = 1 << c - '1';
            int i = row/3*3 + column/3;
            if (((rows[row] | columns[column] | boxes[i]) & val) > 0) {
                return false;
            }
            rows[row] |= val;
            columns[column] |= val;
            boxes[i] |= val;
        }
    }
    return true;
}

}
