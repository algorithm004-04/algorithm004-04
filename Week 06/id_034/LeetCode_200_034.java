/**
 * LeetCode_200_034
 *
 * @Author blackberry
 * @Date 2019/11/24 8:04 PM
 **/
public class LeetCode_200_034 {

    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};

    private int m;
    private int n;

    // dfs
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        m = grid.length;
        n = grid[0].length;

        int count = 0;

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (grid[i][j] == '1') {
                    sink(i, j, grid);
                    count ++;
                }
            }
        }
        return count;
    }

    private void sink(int i, int j, char[][] grid) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';

        for (int k = 0; k < dx.length; k ++) {
            sink(i + dx[k], j + dy[k], grid);
        }
    }

    // 并查集
    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        UnionFind unionFind = new UnionFind(grid);

        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j ++) {
                if (grid[i][j] == '1') {
                    for (int k = 0; k < dx.length; k ++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == '1') {
                            int id1 = i * col + j;
                            int id2 = x * col + y;
                            unionFind.union(id1, id2);
                        }
                    }
                }
            }
        }
        return unionFind.count;
    }

    class UnionFind {
        private int[] parent;
        private int count;

        private int m;
        private int n;

        public UnionFind(char[][] grid) {
            m = grid.length;
            n = grid[0].length;

            parent = new int[m * n];

            for (int i = 0; i < m; i ++) {
                for (int j = 0; j < n; j ++) {
                    if (grid[i][j] == '1') {
                        int id = i * n + j;
                        parent[id] = id;
                        count ++;
                    }
                }
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            parent[rootP] = rootQ;
            count --;
        }
    }
}
