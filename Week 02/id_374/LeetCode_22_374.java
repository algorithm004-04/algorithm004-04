package algorithm.homework.week02;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_22_374 {
    public static void main(String[] args) {
        LeetCode_22_374 l22 = new LeetCode_22_374();
        System.out.println(l22.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        generateInner(0, 0, n, "",ans);
        return ans;
    }

    private void generateInner(int left, int right, int max, String s,List<String> ans) {
        if (left == max && right ==max) {
            ans.add(s);
            return;
        }
        if (left < max)
            generateInner(left + 1, right, max, s + "(",ans);
        if (left > right)
            generateInner(left, right + 1, max, s + ")",ans);
    }
}
