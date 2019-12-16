//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//
//输出: 3
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        return unionFind(grid);
    }

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    private boolean valid(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length) return false;
        if (j < 0 || j >= grid[0].length) return false;
        return grid[i][j] == '1';
    }

    public int unionFind(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (valid(grid, i, j)) {
                    int middle = i * grid[0].length + j;
                    for (int k = 0; k < 4; k++) {
                        if (valid(grid, i + dx[k], j + dy[k])) {
                            int around = (i + dx[k]) * grid[0].length + j + dy[k];
                            uf.union(around, middle);
                        }
                    }
                }
            }
        }
        return uf.count();
    }

}


class UnionFind {
    private int[] roots;
    private int count;

    public UnionFind(char[][] grid) {
        roots = new int[grid.length * grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    roots[i * grid[0].length + j] = i * grid[0].length + j;
                    count++;
                }
            }
        }
    }

    public int count() {
        return count;
    }

    public int findRoot(int i) {
        int root = i;
        while (root != roots[root]) root = roots[root];
        while (i != roots[i]) {
            int tmp = roots[i];
            roots[i] = root;
            i = tmp;
        }
        return root;
    }

    public void union(int p, int q) {
        int proot = findRoot(p);
        int qroot = findRoot(q);
        if (proot != qroot) {
            roots[proot] = qroot;
            count--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
