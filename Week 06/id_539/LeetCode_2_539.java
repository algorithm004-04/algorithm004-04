class Solution {
public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0||grid[0].length==0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int numOfIsland = rows * cols;
        int[][] directions = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        UnionFind set = new UnionFind(numOfIsland);
        int waterCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    for (int k = 0; k < directions.length; k++) {
                        int newX = i + directions[k][0];
                        int newY = j + directions[k][1];
                        if (newX >= 0 && newX < rows && newY >= 0 && newY < cols) {
                            int targetIndex1 = i * cols + j;
                            int targetIndex2 = newX * cols + newY;
                            if (grid[newX][newY] == '1') {
                                set.union(targetIndex1, targetIndex2);
                            }
                        }
                    }
                } else {
                    waterCount++;
                }
            }
        }

        return set.getCount() - waterCount;
    }

    class UnionFind {
        private int count = 0;
        private int[] parent;
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
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
            if (rootP == rootQ) return;
            parent[rootP] = rootQ;
            count--;
        }

        public int getCount() {
            return count;
        }
    }
}