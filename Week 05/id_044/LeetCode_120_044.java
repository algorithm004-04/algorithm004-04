package week_05.lesson12;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

    private static int row;

    private static Integer[][] memo;

    public static int minimumTotal(List<List<Integer>> triangle) {
        /*row = triangle.size();
        memo = new Integer[row][row];
        return helper(0, 0, triangle);*/
        int row = triangle.size();
        int[] minlen = new int[row + 1];
        for (int level = row - 1; level >= 0; level--) {
            for (int i = 0; i <= level; i++) {
                minlen[i] = Math.min(minlen[i],minlen[i + 1]) + triangle.get(level).get(i);
            }
        }
        return minlen[0];
    }

    //自顶向下，记忆化搜索
    private static int helper(int level, int c, List<List<Integer>> triangle) {
        if (null != memo[level][c]) {
            return memo[level][c];
        }
        if (level == row - 1) {
            return memo[level][c] = triangle.get(level).get(c);
        }
        int left = helper(level + 1, c, triangle);
        int right = helper(level + 1, c + 1, triangle);
        return memo[level][c] = Math.min(left, right) + triangle.get(level).get(c);
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        c.add(2);
        triangle.add(c);
        c = new ArrayList<>();
        c.add(3);
        c.add(4);
        triangle.add(c);
        c = new ArrayList<>();
        c.add(6);
        c.add(5);
        c.add(7);
        triangle.add(c);
        c = new ArrayList<>();
        c.add(4);
        c.add(1);
        c.add(8);
        c.add(3);
        triangle.add(c);
        System.out.println(minimumTotal(triangle));
    }
}
