class Solution {

    private int count = 0;
    private int[] parent;

    public void init_parent(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }
    }

    public int find( int i) {
        if (parent[i] == -1)
            return i;
        return find(parent[i]);
    }


    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        parent[rootP] = rootQ;
        count--;
    }


    public int findCircleNum(int[][] M) {

        if (M.length == 0) {
            return 0;
        }

        init_parent(M.length);

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (i != j && M[i][j] == 1) {
                    union(i, j);
                }
            }
        }


        int circleNum = 0;
        for (int i = 0 ; i < parent.length; i++){
            if (parent[i] == -1){
                circleNum ++;
            }
        }

        return circleNum;
    }
}