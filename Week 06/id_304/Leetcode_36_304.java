class Solution {
    public boolean isValidSudoku(char[][] board) {
       for (int i = 0; i < 9; i++) {
		HashSet<Character> row = new HashSet<>();// 行
		HashSet<Character> column = new HashSet<>();// 列
		HashSet<Character> cube = new HashSet<>();// 宫
		for (int j = 0; j < 9; j++) {
			if (board[i][j] != '.' && !row.add(board[i][j])) {
				return false;
			}
			if (board[j][i] != '.' && !column.add(board[j][i])) {
				return false;
			}
			// 行号+偏移量
			int rowIndex = 3 * (i / 3) + j / 3;
			// 列号+偏移量
			int colIndex = 3 * (i % 3) + j % 3;
			if (board[rowIndex][colIndex] != '.' && !cube.add(board[rowIndex][colIndex])) {
				return false;
			}
		}
	}
	return true;
    }
}
