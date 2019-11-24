/**
 * LeetCode_547_034
 *
 * @Author blackberry
 * @Date 2019/11/24 7:22 PM
 **/
public class LeetCode_547_034 {

    // 并查集
    public int findCircleNum(int[][] M) {

        int n = M.length;
        UnionFind unionFind = new UnionFind(n);

        for (int i = 0; i < n - 1; i ++) {
            for (int j = i + 1; j < n; j ++) {
                if (M[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.count;
    }

    class UnionFind {
        private int[] parent;
        private int count = 0;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i ++) {
                parent[i] = i;
            }
            count = n;
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
