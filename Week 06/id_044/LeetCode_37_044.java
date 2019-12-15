package week_06.lesson14;

public class SudokuSolver {

    private int n = 3;

    private int N = n * n;

    private int[][] rows = new int[N][N + 1];
    private int[][] columns = new int[N][N + 1];
    private int[][] boxes = new int[N][N + 1];

    private char[][] board;

    private boolean sudokuSolved = false;

    public void solveSudoku(char[][] board) {

        this.board = board;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int d = Character.getNumericValue(num);
                    //填充数字
                    placeNumber(d, i, j);
                }
            }
        }
        backTrack(0, 0);
    }

    private void placeNumber(int d, int row, int col) {
        int idx = (row / n) * n + col / n;
        rows[row][d]++;
        columns[col][d]++;
        boxes[idx][d]++;
        board[row][col] = (char) (d + '0');
    }

    private void backTrack(int row, int col) {

        if (board[row][col] == '.') {
            for (int d = 1; d < N + 1; d++) {
                if (couldPlace(d, row, col)) {
                    placeNumber(d, row, col);
                    placeNextNumbers(row, col);
                    if (!sudokuSolved) {
                        removeNumber(d, row, col);
                    }
                }
            }
        } else {
            placeNextNumbers(row, col);
        }

    }

    private void removeNumber(int d, int row, int col) {
        int idx = (row / n) * n + col / n;
        rows[row][d]--;
        columns[col][d]--;
        boxes[idx][d]--;
        board[row][col] = '.';
    }

    private void placeNextNumbers(int row, int col) {
        if ((col == N - 1) && (row == N - 1)) {
            sudokuSolved = true;
        } else {
            if (col == N - 1) {
                backTrack(row + 1, 0);
            } else {
                backTrack(row, col + 1);
            }
        }
    }

    private boolean couldPlace(int d, int row, int col) {
        int idx = (row / n) * n + col / n;
        return rows[row][d] + columns[col][d] + boxes[idx][d] == 0;
    }


}
