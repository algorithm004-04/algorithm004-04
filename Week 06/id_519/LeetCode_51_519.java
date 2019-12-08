package algorithm.chapter6.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 【51. N皇后】n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * https://leetcode-cn.com/problems/n-queens/
 * 
 * @author chying
 *
 */
public class LeetCode_51_519 {

	public static void main(String[] args) {
		LeetCode_51_519 a = new LeetCode_51_519();
		List<List<String>> result = a.solveNQueens_DFS(4);
		for (List<String> list : result) {
			System.out.println(list.toString());
		}
	}

	/**
	 * 执行用时 : 3 ms , 在所有 java 提交中击败了 95.93% 的用户 内存消耗 : 37.4 MB , 在所有 java 提交中击败了
	 * 99.64% 的用户 本质思想 ，剪枝
	 * 
	 * @param n
	 * @return
	 */
	public List<List<String>> solveNQueens_DFS(int n) {
		List<List<String>> result = new ArrayList<>();
		if (n <= 0)
			return result;

		boolean[] cols = new boolean[n];
		boolean[] d1 = new boolean[2 * n - 1];// diagonal 1, from upper left to lower right. d1idx = cidx - ridx + n - 1
		boolean[] d2 = new boolean[2 * n - 1];// diagonal 2, from upper right to lower left d2idx = (n-cidx) - ridx + n
												// - 2
		solveNQueens(0, cols, d1, d2, new ArrayList<String>(), n, result);
		return result;
	}

	private void solveNQueens(int rowid, boolean[] cols, boolean[] d1, boolean[] d2, List<String> subList, int n,
			List<List<String>> result) {
		if (rowid == n) {
			result.add(new ArrayList<String>(subList));
			return;
		}

		char[] row = new char[n];
		Arrays.fill(row, '.');
		for (int colid = 0; colid < n; colid++) {

			int d1id = colid - rowid + n - 1;
			int d2id = (n - colid) - rowid + n - 2;

			if (!cols[colid] && !d1[d1id] && !d2[d2id]) {
				row[colid] = 'Q';
				subList.add(new String(row));
				cols[colid] = d1[d1id] = d2[d2id] = true;

				solveNQueens(rowid + 1, cols, d1, d2, subList, n, result);

				row[colid] = '.';
				subList.remove(subList.size() - 1);
				cols[colid] = d1[d1id] = d2[d2id] = false;
			}
		}
	}
}
