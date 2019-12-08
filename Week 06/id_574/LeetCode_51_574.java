package SuanFa.Week06;

import java.util.ArrayList;
import java.util.List;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Neo
 */
public class LeetCode_51_574 {
    public static void main(String[] args) {
        int n = 4;
        LeetCode_51_574 l = new LeetCode_51_574();
        System.out.println(l.solveNQueue(n));
    }

    public List<List<String>> solveNQueue(int n) {
        List<List<String>> ret = new ArrayList<>();
        char[][] curr = new char[n][n];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                curr[i][j] = '.';
            }
        }
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];
        solve(curr, 0, n, ret, col, diag1, diag2);
        return ret;
    }

    private void solve(char[][] curr, int index, int n, List<List<String>> ret, boolean[] col, boolean[] diag1, boolean[] diag2) {
        if (index == n) {
            List<String> toAdd = new ArrayList<>();
            for (int i=0;i<n;i++) {
                toAdd.add(String.valueOf(curr[i]));
            }
            ret.add(toAdd);
            return;
        }

        for (int j=0;j<n;j++) {
            if (col[j] || diag1[index + n -j -1] || diag2[index + j]) {
                continue;
            }
            col[j] = true;
            diag1[index + n -j -1] = true;
            diag2[index + j] = true;
            curr[index][j] = 'Q';
            solve(curr, index + 1, n, ret, col, diag1, diag2);
            curr[index][j] = '.';
            col[j] = false;
            diag1[index + n -j -1] = false;
            diag2[index + j] = false;
        }

    }

}
