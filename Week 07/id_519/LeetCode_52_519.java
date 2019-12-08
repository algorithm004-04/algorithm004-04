package algorithm.chapter7.first;

/**
 * ��52. N�ʺ�n �ʺ������о�������ν� n ���ʺ������ n��n �������ϣ�����ʹ�ʺ�˴�֮�䲻���໥������
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
		// ��ǰ�� �ܷŻʺ��λ��
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
