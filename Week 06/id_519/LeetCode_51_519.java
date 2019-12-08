package algorithm.chapter6.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ��51. N�ʺ�n �ʺ������о�������ν� n ���ʺ������ n��n �������ϣ�����ʹ�ʺ�˴�֮�䲻���໥������
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
	 * ִ����ʱ : 3 ms , ������ java �ύ�л����� 95.93% ���û� �ڴ����� : 37.4 MB , ������ java �ύ�л�����
	 * 99.64% ���û� ����˼�� ����֦
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
