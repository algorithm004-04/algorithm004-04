class Solution {
	int[][] cor = {{1,0},{-1,0},{0,1},{0,-1}};	
	public int numIslands(char[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		int count = 0;
		for(int i = 0; i < m; i ++) {
			for(int j = 0; j < n; j ++) {
				if(!visited[i][j] && grid[i][j] == '1') {
					count ++;
					isIands2(grid, i, j, m, n, visited);	//判断该点的四周其他的点并将连着的陆地标记
				}
			}
		}
		return count;
	}
	private void isIands(char[][] grid, int i, int j, int m, int n, boolean[][] visited) {
		visited[i][j] = true;
		for(int s = 0; s < 4; s ++) {
			int newx = i + cor[s][0];
			int newy = j + cor[s][1];
			if(newx >= 0 && newx < m && newy >= 0 && newy < n && !visited[newx][newy] && grid[newx][newy] == '1') {
				isIands(grid, newx, newy, m, n, visited);
			}
		}
		return;
	}
	private void isIands2(char[][] grid, int i, int j, int m, int n, boolean[][] visited) {
		if(i >= 0 && i < m && j >= 0 && j < n && !visited[i][j] && grid[i][j] == '1') {
			visited[i][j] = true;
			isIands2(grid, i + 1, j, m, n, visited);
			isIands2(grid, i - 1, j, m, n, visited);
			isIands2(grid, i, j - 1, m, n, visited);
			isIands2(grid, i, j + 1, m, n, visited);
		}		
	}
}