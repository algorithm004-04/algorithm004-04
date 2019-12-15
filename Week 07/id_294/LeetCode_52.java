package week07;

public class LeetCode_52 {
	//位运算N皇后II
	static int count = 0;

	public static int solveNQueens(int n) {
//		solve(n, 0, 0, 0, 0);
		solveArray(n, 0, new int[n], new int[n], new int[n]);
		return count;
	}

	/**
	 * row pie na 三个整数的每一位，1表示格子被占用，0表示未被占用
	 * 但是available，1表示未被占用，0表示被占用
	 */
	public static void solve(int n, int row, int col, int pie, int na) {
		if (row >= n) {
			count++;
			return;
		}
		//此处转成用1表示空位，是因为位运算可以很方便取最后一个1（即x & (x-1)），但是无法取最后一个0
		int available = (~(col | pie | na)) & ((1 << n) - 1);
		while (available > 0) {
			int pick = available & (-available);
			available = available & (available - 1);
			solve(n, row + 1, col | pick, (pie | pick) << 1, (na | pick) >> 1);
		}
	}

	/**
	 * 用一维数组模拟整数位，用来理解位运算的过程
	 * 数组中0表示未占用，1表示占用
	 */
	public static void solveArray(int n, int row, int[] colArr, int[] pieArr, int[] naArr) {
		if (row >= n) {
			count++;
			return;
		}
		int[] colCopy = colArr.clone();
		int[] pieCopy = pieArr.clone();
		int[] naCopy = naArr.clone();

		for (int i = 0; i < n; i++) {
			int col = (colArr[i] == 1 || pieArr[i] == 1 || naArr[i] == 1) ? 1 : 0;
			if (col == 0) {
				colCopy[i] = 1;
				pieCopy[i] = 1;
				naCopy[i] = 1;
				for (int j = 0; j < n - 1; j++) {
					pieCopy[j] = pieCopy[j + 1];
				}
				pieCopy[n - 1] = 0;
				for (int j = n - 1; j > 0; j--) {
					naCopy[j] = naCopy[j - 1];
				}
				naCopy[0] = 0;
				solveArray(n, row + 1, colCopy, pieCopy, naCopy);
			}
		}
	}

	public static void main(String[] args) {
		int c = solveNQueens(4);
		System.out.println(c);
	}
}
