package medium;

//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例:
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class LC77 {

    public static void main(String[] args) {
        LC77 lc77 = new LC77();
        lc77.combine(4,2);
    }

    /**
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        //loop_recall(n,k,1,new Stack(),ret);
        //print(ret);

        //ret.clear();
        rank_loop(n,k,1,new Stack(),ret);
        print(ret);
        return ret;
    }

    private static void print(List<List<Integer>> ret) {
        System.out.println("------------------------");

        for(int i=0;i<ret.size();i++){
            List<Integer> tmp = ret.get(i);
            System.out.print("[");
            for(int j=0;j<tmp.size();j++){
                System.out.print(tmp.get(j)+",");
            }
            System.out.println("]");
        }
    }

    /**
     *
     * @param n
     * @param k
     * @param begin
     * @param pre
     * @param ret
     */
    private void loop_recall(int n, int k, int begin, Stack<Integer> pre, List<List<Integer>> ret) {
        if(pre.size() == k){
            ret.add(new ArrayList<>(pre));
            return;
        }
        //这里i的边界非常重要，通过剪枝来处理
        for(int i=begin;i<=(n - (k - pre.size()) + 1);i++){
            pre.add(i);
            loop_recall(n,k,i+1, pre,ret);
            pre.pop();
        }
    }

    /**
     * 全排列
     * 从1开始：1,2;1,3;1,4
     * 从2开始：2,3;2,4
     * 从3开始：3,4
     * 思路来源于回溯算法，使用stack来存储全排列的起始位置，每次相当于深度递归
     * @param n
     * @param k
     * @param begin
     * @param stack
     * @param ret
     */
    private  void rank_loop(int n, int k, int begin, Stack<Integer> stack, List<List<Integer>> ret){
        for(int i=1;i<n;i++){
            rank_recursion(n,k,i,stack,ret);
            stack.clear();
        }
    }

    /**
     * 循环推入栈中，判断到达K之后，退出。
     * @param n
     * @param k
     * @param begin
     * @param stack
     * @param ret
     */
    private void rank_recursion(int n, int k, int begin, Stack<Integer> stack, List<List<Integer>> ret){
        stack.add(begin);
        if(stack.size() == k){
            ret.add(new ArrayList<>(stack));
            return;
        }

        for(int i=begin+1;i<=n;i++){
            rank_recursion(n,k,i,stack,ret);
            stack.pop();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
