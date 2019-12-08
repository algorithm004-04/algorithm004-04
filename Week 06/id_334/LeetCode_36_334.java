package Algorithms.HashTable;

//Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
//
//
// Each row must contain the digits 1-9 without repetition.
// Each column must contain the digits 1-9 without repetition.
// Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
//
//
//
//A partially filled sudoku which is valid.
//
// The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
//
// Example 1:
//
//
//Input:
//[
//  ["5","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//Output: true
//
//
// Example 2:
//
//
//Input:
//[
//  ["8","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//Output: false
//Explanation: Same as Example 1, except with the 5 in the top left corner being
//    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
//
//
// Note:
//
//
// A Sudoku board (partially filled) could be valid but is not necessarily solvable.
// Only the filled cells need to be validated according to the mentioned rules.
// The given board contain only digits 1-9 and the character '.'.
// The given board size is always 9x9.
//
// Related Topics Hash Table


//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_36_334 {

    //除了hash，看到这个解法的时候被惊艳到了，还是学习一把
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] rowCheck = new boolean[9];
            boolean[] colCheck = new boolean[9];
            boolean[] boxCheck = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                } else if (rowCheck[board[i][j] - '1']) {
                    return false;
                } else {
                    rowCheck[board[i][j] - '1'] = true;
                }

                if (board[j][i] == '.') {
                } else if (colCheck[board[j][i] - '1']) {
                    return false;
                } else {
                    colCheck[board[j][i] - '1'] = true;
                }

                int m = i / 3 * 3 + j / 3;
                int n = i % 3 * 3 + j % 3;
                if (board[m][n] == '.') {
                } else if (boxCheck[board[m][n] - '1']) {
                    return false;
                } else {
                    boxCheck[board[m][n] - '1'] = true;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

