package week02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>示例:
 * <p>输入: n = 4, k = 2 输出: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 */


public class LeetCode_77_294 {

    public List<List<Integer>> combine(int n, int k) {
        Stack<Integer> ret = new Stack<>();
        helper(n, k, 1, ret);
        return null;
    }

    public void helper(int n, int k, int cur, Stack<Integer> ret) {
        if (ret.size() == k) {
            System.out.println(ret);
            return;
        }
        for (int i = cur; i <= n; i++) {
            ret.add(i);
            helper(n, k, i + 1, ret);
            ret.pop();
        }
    }

  public static void main(String[] args) {
    new LeetCode_77_294().combine(6, 3);
  }
}
