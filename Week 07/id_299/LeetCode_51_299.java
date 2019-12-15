package algorithm;


import java.util.*;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */
public class LeetCode_51_299 {
    public static void main(String[] args) {
        int n = 4;
        LeetCode_51_299 nQueens = new LeetCode_51_299();
        List<List<String>> result = nQueens.solveNQueens(n);
        System.out.println("n---------->"+result);
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> boards = new ArrayList<>();
        if(n < 1) return boards;
        int col = 0, pie = 0, na = 0;

        dfs(n, 0, new ArrayList<>(), boards, col, pie, na);
        return boards;
    }

    private void dfs(int n, int row, List<String> board, List<List<String>> boards,int col, int pie, int na){
        if(row >= n) {
            boards.add(new ArrayList<>(board));
            return;
        }
        int bits = (~(col | pie | na)) & ((1 << n) - 1);

        while(bits > 0){
            int p = bits & -bits;
            int pos = Integer.toBinaryString(p).length();

            // 转换棋盘的行
            char[] boardRow = new char[n];
            Arrays.fill(boardRow, '.');
            boardRow[n - pos] = 'Q';

            board.add(String.valueOf(boardRow));
            dfs(n, row + 1, board, boards, col | p, (pie | p) << 1, (na | p) >> 1);
            board.remove(board.size() - 1);

            bits &= bits - 1;
        }
    }
}
