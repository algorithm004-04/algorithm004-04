package algorithm;

import java.util.LinkedList;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_200_299 {
    // 定义方向数组
    private static final int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    // 标记数组 grid中的格子是否已经访问过
    private static boolean[][] marked;
    private static int rows;
    private static int cols;

    public static void main(String[] args) {
        char[][] grid1 = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };

//        int nums = numIslands(grid1);
        // 并查集
        int nr = grid1.length;
        int nc = grid1[0].length;
        UnionFind uf = new UnionFind(grid1);
        for (int r=0;r <nr;r++){
            for(int c=0;c<nc;c++){
                if(grid1[r][c]=='1'){
                    grid1[r][c]='0';

                    if (r - 1 >= 0 && grid1[r-1][c] == '1') {
                        uf.union(r * nc + c, (r-1) * nc + c);
                    }
                    if (r + 1 < nr && grid1[r+1][c] == '1') {
                        uf.union(r * nc + c, (r+1) * nc + c);
                    }
                    if (c - 1 >= 0 && grid1[r][c-1] == '1') {
                        uf.union(r * nc + c, r * nc + c - 1);
                    }
                    if (c + 1 < nc && grid1[r][c+1] == '1') {
                        uf.union(r * nc + c, r * nc + c + 1);
                    }
                }
            }
        }

        System.out.println("nums---------------->"+uf.getCount());
//        System.out.println("nums---------------->"+nums);
    }

    // 并查集
    static class UnionFind{
        int count;
        int[] parent;
        int[] rank;

        public UnionFind(char[][] grid){
            count=0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for(int i =0;i< m;i++){
                for(int j =0; j<n; j++){
                    if(grid[i][j]=='1'){
                        parent[i  * n + j] = i * n +j;
                        count++;
                    }
                    rank[i*n + j] = 0;
                }
            }
        }

        public int find(int i){
            if(parent[i] != i){
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public void union(int x ,int y){
            int rootx = find(x);
            int rooty = find(y);
            if(rootx != rooty){
                if(rank[rootx] > rank[rooty]){
                    parent[rooty] = rootx;
                } else if(rank[rootx]< rank[rooty]){
                    parent[rootx] =rooty;
                }else {
                    parent[rooty] =rootx;
                    rank[rootx] +=1;
                }
                count--;
            }
        }
        public int getCount(){
            return count;
        }

    }



//    // BFS
//    public static int numIslands(char[][] grid){
//        rows = grid.length;
//        if(grid.length ==0){
//            return 0;
//        }
//
//        cols = grid[0].length;
//        marked = new boolean[rows][cols];
//        int count = 0;
//        for (int i = 0; i < rows; i++){
//            for(int j = 0; j < cols; j++){
//                if (!marked[i][j] && grid[i][j] == '1') {
//                    count++;
//                    LinkedList<Integer> queue = new LinkedList<>();
//                    queue.addLast(i * cols + j);
//                    marked[i][j] = true;
//                    while (!queue.isEmpty()) {
//                        int cur = queue.removeFirst();
//                        int curX = cur / cols;
//                        int curY = cur % cols;
//                        // 得到该点的4个方向
//                        for (int k = 0; k < 4; k++) {
//                            int newX = curX + directions[k][0];
//                            int newY = curY + directions[k][1];
//
//                            // 处理边界
//                            if((newX >= 0 && newX < rows && newY >= 0 && newY < cols)  && grid[newX][newY] =='1' && !marked[newX][newY]){
//                                queue.addLast(newX * cols + newY);
//                                marked[newX][newY] = true;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        return count;
//    }


//    // DFS
//    public static int numIslands(char[][] grid){
//        rows = grid.length;
//        if(grid.length == 0){
//            return 0;
//        }
//        cols = grid[0].length;
//        marked = new boolean[rows][cols];
//        int count = 0;
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                // 如果是岛屿中的一个点，并且没有被访问过
//                // 就进行深度优先遍历
//                if (!marked[i][j] && grid[i][j] == '1') {
//                    count++;
//                    DFS(grid,i, j);
//                }
//            }
//        }
//        return count;
//    };
//
//    // 开始从i,j 遍历
//    private static void DFS(char[][] grid, int i, int j){
//        marked[i][j] = true;// 走过了该点,标记它
//        // 得到4个方向的选择
//        for(int k = 0;k < 4;k++){
//            int newX = i + directions[k][0];
//            int newY = j + directions[k][1];
//            // proccess 限定条件,不能越界 没有访问过、还要是陆地
//            if((newX >=0 && newX < rows && newY >= 0 && newY < cols) && grid[newX][newY] =='1' && !marked[newX][newY]){
//                DFS(grid, newX, newY);
//            }
//        }
//    }
}
