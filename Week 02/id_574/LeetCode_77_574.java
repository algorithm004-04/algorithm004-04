package SuanFa.Week02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_77_574 {
    public static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        System.out.println(combine(n,k));
    }

    private static List<List<Integer>> combine(int n, int k) {
        if(n<0 || k< 0 || n<k) return res;
        findCombinations(n,k,1,new Stack<>());
        return res;
    }

    private static void findCombinations(int n, int k, int begin, Stack<Integer> pre) {
        if (pre.size() == k) {
            res.add(new ArrayList<>(pre));
            return;
        }
        for (int i= begin;i<=n;i++) {
            pre.add(i);
            findCombinations(n,k,i+1,pre);
            pre.pop(); // remove the value which have been used just now
        }
    }

    /**
     * 剪枝，移除某些不可能存在组合的情况
     * URL:https://leetcode-cn.com/problems/combinations/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-ma-/
     * @param n
     * @param k
     * @param begin
     * @param pre
     */
    private static void findCombinations1(int n,int k,int begin, Stack<Integer> pre) {
        if (pre.size() == k) {
            res.add(new ArrayList<>(pre));
            return;
        }
        for (int i=begin;i<n-(k-pre.size())+1;i++) {
            pre.push(i);
            findCombinations1(n,k,i+1,pre);
            pre.pop();
        }
    }
}
