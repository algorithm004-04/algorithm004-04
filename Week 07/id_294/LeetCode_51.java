package week07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_51 {
	//位运算N皇后
	static int count = 0;
	static Map<Integer, String> rowStrings = new HashMap<>();

	public static List<List<String>> solveNQueens(int n) {
		//预处理代表占用每一列的皇后的字符串
		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; j++) {
				if (j == i) sb.append("Q");
				else sb.append(".");
			}
			//这里使用2的幂指数作为key来存储，方便后面查询
			rowStrings.put(1 << i, sb.toString());
		}
		List<List<String>> results = new ArrayList<>();
		solve(n, 0, 0, 0, 0, new ArrayList<>(), results);
		return results;
	}

	/**
	 * row pie na 三个整数的每一位，1表示格子被占用，0表示未被占用
	 * 但是available，1表示未被占用，0表示被占用
	 */
	public static void solve(int n, int row, int col, int pie, int na, List<String> oneSolve, List<List<String>> result) {
		if (row >= n) {
			//add一定是copy，不然在reverse_state阶段会把数据清空
			result.add(new ArrayList(oneSolve));
			return;
		}
		//此处转成用1表示空位，是因为位运算可以很方便取最后一个1（即x & (x-1)），但是无法取最后一个0
		int available = (~(col | pie | na)) & ((1 << n) - 1);
		while (available > 0) {
			int pick = available & (-available);
			available = available & (available - 1);
			oneSolve.add(rowStrings.get(pick));
			solve(n, row + 1, col | pick, (pie | pick) << 1, (na | pick) >> 1, oneSolve, result);
			oneSolve.remove(rowStrings.get(pick));
		}
	}


	public static void main(String[] args) {
		List<List<String>> r = solveNQueens(4);
		System.out.println(r);
	}
}
