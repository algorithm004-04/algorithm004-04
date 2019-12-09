import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_529_minesweeper {

    public char[][] updateBoard(char[][] board, int[] click) {
        dfs(board, click[0], click[1]);
        return board;
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        if (board[i][j] == 'E') {
            int m = 0;
            if (i > 0 && board[i - 1][j] == 'M') {
                m++;
            }
            if (i < board.length - 1 && board[i + 1][j] == 'M') {
                m++;
            }
            if (j > 0 && board[i][j - 1] == 'M') {
                m++;
            }
            if (j < board[0].length - 1 && board[i][j + 1] == 'M') {
                m++;
            }
            if (i > 0 && j > 0 && board[i - 1][j - 1] == 'M') {
                m++;
            }
            if (i > 0 && j < board[0].length - 1 && board[i - 1][j + 1] == 'M') {
                m++;
            }
            if (j > 0 && i < board.length - 1 && board[i + 1][j - 1] == 'M') {
                m++;
            }
            if (i < board.length - 1 && j < board[0].length - 1 && board[i + 1][j + 1] == 'M') {
                m++;
            }
            System.out.println((char) (m + 48));
            board[i][j] = m == 0 ? 'B' : (char) (m + 48);
            if (m == 0) {
                dfs(board, i + 1, j);
                dfs(board, i - 1, j);
                dfs(board, i, j + 1);
                dfs(board, i, j - 1);
                dfs(board, i + 1, j + 1);
                dfs(board, i - 1, j + 1);
                dfs(board, i + 1, j - 1);
                dfs(board, i - 1, j - 1);
            }
        } else if (board[i][j] == 'M') {
            board[i][j] = 'X';
        }
    }


    //使用bfs
    Queue<POS> q;
    boolean[][] vis;
    int xi[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    int yi[] = {-1, 0, 1, -1, 1, -1, 0, 1};

    public char[][] updateBoard1(char[][] board, int[] click) {
        q = new LinkedList();
        int row = board.length;
        int col = board[0].length;
        vis = new boolean[row][col];
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M')
            board[x][y] = 'X';
        else {
            q.add(new POS(x, y));
            vis[x][y] = true;
            bfs(row, col, board);
        }
        return board;
    }

    void bfs(int row, int col, char[][] board) {
        while (!q.isEmpty()) {
            POS s = q.remove();
            int count = 0;
            for (int i = 0; i < 8; i++) {
                int x_ = s.x + xi[i];
                int y_ = s.y + yi[i];
                if (isIn(x_, y_, row, col)) {
                    if (board[x_][y_] == 'M')
                        count++;
                }
            }
            if (count == 0) {
                board[s.x][s.y] = 'B';
                for (int i = 0; i < 8; i++) {
                    int x_ = s.x + xi[i];
                    int y_ = s.y + yi[i];
                    if (isIn(x_, y_, row, col)) {
                        if (!vis[x_][y_] && board[x_][y_] == 'E') {
                            vis[x_][y_] = true;
                            q.add(new POS(x_, y_));
                        }
                    }
                }
            } else
                board[s.x][s.y] = (char) ('0' + count);
        }
    }

    boolean isIn(int i, int j, int x, int y) {
        return i < x && j < y && i >= 0 && j >= 0;
    }

    class POS {
        int x;
        int y;

        POS(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
