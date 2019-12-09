package algorithm.chapter6.first;

/**
 * 【200. 岛屿数量】给定一个由 '1'（陆地）和
 * '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * 示例 1: 输入: 11110 11010 11000 00000 输出: 1 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class LeetCode_200_519 {

	private int n;
	private int m;

	public int numIslands(char[][] grid) {
		int count = 0;
		n = grid.length;
		if (n == 0)
			return 0;
		m = grid[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				if (grid[i][j] == '1') {
					DFSMarking1(grid, i, j);
					++count;
				}
		}
		return count;
	}

	private void DFSMarking(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1')
			return;
		grid[i][j] = '0';
		DFSMarking(grid, i + 1, j);
		DFSMarking(grid, i - 1, j);
		DFSMarking(grid, i, j + 1);
		DFSMarking(grid, i, j - 1);
		// 循环 dx,dy
	}

	private void DFSMarking1(char[][] grid, int i, int j) {
		if (i < 0 || i == grid.length || j < 0 || j == grid[i].length || grid[i][j] == '0')
			return;
		grid[i][j] = '0';
		int[] d = { 0, 1, 0, -1, 0 };
		for (int k = 0; k < 4; k++)
			DFSMarking1(grid, i + d[k], j + d[k + 1]);
	}

	public static void main(String[] args) {
		LeetCode_200_519 a = new LeetCode_200_519();
		char[][] grid = new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
				{ '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } };
		System.out.println(a.numIslands1(grid));
	}

	/**
	 * 并查集实现
	 * 
	 * @param grid
	 * @return
	 */
	public int numIslands1(char[][] grid) {
		if (grid.length == 0 || grid[0].length == 0)
			return 0;
		int m = grid.length, n = grid[0].length;
		UF uf = new UF(m, n, grid);

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '0')
					continue;
				int p = i * n + j;
				int q;
				if (i > 0 && grid[i - 1][j] == '1') {
					q = p - n;
					uf.union(p, q);
				}
				if (i < m - 1 && grid[i + 1][j] == '1') {
					q = p + n;
					uf.union(p, q);
				}
				if (j > 0 && grid[i][j - 1] == '1') {
					q = p - 1;
					uf.union(p, q);
				}
				if (j < n - 1 && grid[i][j + 1] == '1') {
					q = p + 1;
					uf.union(p, q);
				}
			}
		}
		return uf.count;
	}

	class UF {
		public int count = 0;
		public int[] island = null;

		public UF(int m, int n, char[][] grid) {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (grid[i][j] == '1')
						count++;
				}
			}
			island = new int[m * n];
			for (int i = 0; i < m * n; i++) {
				island[i] = i;
			}
		}

		public int find(int p) {
			while (p != island[p]) {
				island[p] = island[island[p]];
				p = island[p];
			}
			return p;
		}

		public boolean isConnected(int p, int q) {
			int pRoot = find(p);
			int qRoot = find(q);
			if (pRoot != qRoot)
				return false;
			else
				return true;
		}

		public void union(int p, int q) {
			int pRoot = find(p);
			int qRoot = find(q);
			if (pRoot == qRoot)
				return;
			island[pRoot] = qRoot;
			count--;
		}
	}
}
