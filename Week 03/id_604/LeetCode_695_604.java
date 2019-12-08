import java.util.HashSet;

class Solution {

    private int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};

    private int R, C;//多少行，多少列
    private int [][] grid;

    private HashSet<Integer>[] G;//图的邻接表的表示
    private boolean[] visited;

    public int maxAreaOfIsland(int[][] grid) {

        if(grid == null) return 0; //如果是一个null数组，就返回岛屿数为零

        R = grid.length;
        if(R == 0) return 0;

        C = grid[0].length;//列数是固定的从0取就可以了
        if(C == 0)  return 0;

        this.grid = grid;


        //开始建模-进行建图这个操作
        G = constructGraph();

        //求出大G这张图中，那些顶点为v对应的联通分量，最大的联通分量值是多少
        int res = 0;
        //使用深度优先遍历
        visited = new boolean[G.length];
        for(int v = 0; v < G.length; v++){
            int x = v / C, y = v % C;
            //找到了一个是陆地的还没有遍历到的顶点
            if(!visited[v] && grid[x][y] ==1)
                res = Math.max(res,dfs(v));
        }

        return res;
    }

    private int dfs(int v){
        visited[v] = true;
        int res = 1;//因为当前遍历到小v这个顶点，且小v这个顶点从来没有被遍历过
        //查找这个小v所有相邻的节点
        for(int w:G[v]){
            if(!visited[w])
                res += dfs(w);
        }
        return res;
    }

    private HashSet<Integer>[] constructGraph() {

        HashSet<Integer>[] g = new HashSet[R*C];//在这个二维网格中有R×C这个顶点,这个其实是一个一维的，从0~n-1的坐标系；

        for(int i = 0; i < g.length; i++)
            g[i] = new HashSet<>();

       for(int v = 0; v < g.length; v++){
           int x = v / C, y = v % C;//将一维的坐标系转换为二维的坐标系
           if(grid[x][y] == 1){
               for(int d = 0; d < 4; d++){
                   int nextx = x + dirs[d][0];
                   int nexty = y + dirs[d][1];
                   if(inArea(nextx,nexty) && grid[nextx][nexty] == 1){
                       int next = nextx*C + nexty;
                       g[v].add(next);
                       g[next].add(v);
                   }
               }

           }

       }

        return g;
    }

    private boolean inArea(int x , int y){
        return x >= 0 && x < R && y>=0 && y < C;
    }
}
