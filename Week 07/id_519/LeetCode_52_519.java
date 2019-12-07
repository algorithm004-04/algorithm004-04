package algorithm.chapter7.first;

/**
 * 【52. N皇后】n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * https://leetcode-cn.com/problems/n-queens-ii/description/
 * 
 * @author chying
 *
 */
public class LeetCode_52_519 {
	private int count;
	private int size;

	public int totalNQueens(int n) {
		count = 0;
		size = (1 << n) - 1;
		solve(0, 0, 0, 0, n);
		return count;
	}

	private void solve(int row, int column, int ld, int rd, int n) {
		if (row == n) {
			count++;
			return;
		}
		// 当前层 能放皇后的位置
		int pos = size & (~(column | ld | rd));
		while (pos != 0) {
			int p = pos & (-pos);
			pos -= p;
			solve(row + 1, column | p, (ld | p) << 1, (rd | p) >> 1, n);
		}
	}

	public static void main(String[] args) {
		LeetCode_52_519 a = new LeetCode_52_519();
		int result = a.totalNQueens(4);
		System.out.println(result);
	}
}
