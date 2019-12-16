package SuanFa.Week06;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 *
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 *
 * 示例 1:
 *
 * 输入:
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * 输出: 2
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。
 *
 *
 * 示例 2:
 *
 * 输入:
 * [[1,1,0],
 *  [1,1,1],
 *  [0,1,1]]
 * 输出: 1
 * 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
 *
 *
 * 注意：
 *
 *
 * 	N 在[1,200]的范围内。
 * 	对于所有学生，有M[i][i] = 1。
 * 	如果有M[i][j] = 1，则有M[j][i] = 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/friend-circles
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Neo
 */
public class LeetCode_547_574 {

    public static void main(String[] args) {
        int M[][] = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
        System.out.println(findCircleNum(M));
    }

    /**
     * DFS
     * @param M
     * @return
     */
    private static int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i<M.length;i++) {
            if (visited[i] == 0) {
                dfs(M,visited,i);
                count++;
            }
        }
        return count;
    }

    /**
     *  M[i][j] == 1 则M[j][i] ==1,所以遍历的时候记录访问的列，eg:访问第二行时发现之前第二列访问过则跳过
     * @param M
     * @param visited
     * @param i
     */
    private static void dfs(int[][] M, int[] visited, int i) {
        for (int j=0;j<M[i].length;j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M,visited,j);
            }
        }
    }

    /**
     *  BFS
     * @param M
     * @return
     */
    private static int findCircleNum1(int[][] M) {
        int []visited = new int[M.length];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<M.length;i++) {
            if (visited[i] == 0) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    visited[i] = 1;
                    for (int j=0;j<M[i].length;j++) {
                        if (M[i][j] == 1 && visited[j] == 0) {
                            queue.add(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }

    /**
     * 并查集
     * @param M
     * @return
     */
    private static int findCircleNum2(int[][] M) {
        int [] parent = new int [M.length];
        Arrays.fill(parent,-1);
        for (int i=0;i<M.length;i++) {
            for (int j=0;j<M[0].length;j++) {
                if (M[i][j] == 1 && i!=j) {
                    union(parent,i,j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1)
                count++;
        }
        return count;
    }

    private static void union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        if (xset != yset)
            parent[xset] = yset;
    }

    private static int find(int[] parent,int i) {
        if (parent[i] == -1) {
            return i;
        }
        return find(parent,parent[i]);
    }
}
