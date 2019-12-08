package SuanFa.Week07;

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
    private static int size;
    private static int count;

    private static int totalNQueens(int n) {
        count = 0;
        size = (1 << n) - 1; // 可以放皇后的位置 先左移N个位置导致后面N个位置全是0，然后减一让后面N个位置全是1
        solve(0,0,0);
        return count;
    }

    private static void solve(int row, int ld, int rd) {
        if (row == size) {
            count++;
            return;
        }
        int pos = size & ( ~(row | ld | rd)); // 取到当前层皇后可以存放的位置
        while (pos != 0) {
            int p = pos & (-pos); //取到最低位的1
            pos &= pos -1; // pos -= p;  放上皇后到当前位置
            solve(row | p, (ld | p) << 1, (rd | p) >> 1);
        }
    }
}
