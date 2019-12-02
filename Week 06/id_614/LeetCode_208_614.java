class Solution {
    boolean[][] flag;
    int[] vi = {-1, 0, 1, 0};
    int[] vj = {0, 1, 0, -1};
    public void solve(char[][] board) {
        int n = board.length;

        if(n < 3) return;
        int m = board[0].length;
        if(m < 3) return;
        flag = new boolean[n][m];
        int i = 0, j = 0, a = 0, b = 0, d = 1;
        int total = 2 * (m + n) - 4;
        for(int k = 1; k <= total; k++){
            if(board[i][j] == 'O')
                dfs(i, j, n, m, board);
            a = i + vi[d];
            b = j + vj[d];
            if(a >= n || a < 0 || b >= m || b < 0){
                d = (d + 1) % 4;
                a = i + vi[d];
                b = j + vj[d];
            }
            i = a;
            j = b;
        }
        for(int p = 0; p < n; p++)
            for(int q = 0; q < m; q++){
                if(!flag[p][q])
                    board[p][q] = 'X';
            }
    }
    void dfs(int i, int j, int n, int m, char[][] board){
        flag[i][j] = true;
        for(int k = 0; k < 4; k++){
            int a = i + vi[k], b = j + vj[k];

            if(a >= 0 && a < n && b >= 0 && b < m && board[a][b] == 'O' && flag[a][b] == false)
                dfs(a, b, n, m, board);
        }
    }
}
