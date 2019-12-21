class Solution {
    public void solve(char[][] board) {

        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        //构建两个并差集，一个是被X包围的网格元素，另一个是可以和边界连通的网格元素
        //判断：凡是和第二个并差集连通的，都标记为O，否则都标记为X
        int rows = board.length;
        int cols = board[0].length;
        int totalSizeOfUnionFind = rows * cols + 1;
        int dummyNodeParentPos = totalSizeOfUnionFind - 1;
        UnionFind unionFind = new UnionFind(totalSizeOfUnionFind);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || j == 0 || i == (rows - 1) || (j == (cols - 1))) {//边界
                        unionFind.union(i * cols + j, dummyNodeParentPos);
                    } else {
                        //在边界以内检查上下左右，如果为O，就合并为一个并查集
                        if (i > 0 && board[i - 1][j] == 'O') {
                            unionFind.union(i * cols + j, (i - 1) * cols + j);
                        }

                        if (i < (rows - 1) && board[i + 1][j] == 'O') {
                            unionFind.union(i * cols + j, (i + 1) * cols + j);
                        }

                        if (j > 0 && board[i][j - 1] == 'O') {
                            unionFind.union(i * cols + j, i * cols + j - 1);
                        }

                        if (j < (cols - 1) && board[i][j + 1] == 'O') {
                            unionFind.union(i * cols + j, i * cols + j + 1);
                        }
                    }
                }
            }
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (unionFind.isConnected(i * cols + j, dummyNodeParentPos)) {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }

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

        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }

        public int getCount() {
            return count;
        }
    }
}