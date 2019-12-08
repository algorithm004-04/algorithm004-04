import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<String> result;

    public List<String> generateParenthesis(int n){
//        _generate(0, 2 * n, "");
        result = new ArrayList<String>();
        _generate2(0,0, n, "");
        return result;
    }

    //解题思路，第一步，考虑6个格子，每个格子可以放"("或")",生成所有情况
    private void _generate(int level, int max, String s) {
        // terminator
        if (level>=max) {
            System.out.println(s);
            return;
        }

        // process:
        // current level logic: add left parenthesis or right parenthesis
        String s1 = s + "(";
        String s2 = s + ")";

        // drill down
        _generate(level + 1, max, s1);
        _generate(level + 1, max, s2);

        //reverse states

    }

    //解题思路，第二步，在第一步基础上判断括号的合法性，level改为左右括号的个数
    /*
    合法的字符串：
    1. 左括号：随时可以加，只要不超过允许的最大数量；
    2. 右括号：必须已经有左括号了，并且左括号的个数>右括号的个数

    */
    private void _generate2(int left, int right, int n, String s) {
        // terminator
        if (left == n && right == n) {
            //System.out.println(s);
            result.add(s);
            return;
        }

        // process:
        // current level logic: add left parenthesis or right parenthesis
        String s1 = s + "(";
        String s2 = s + ")";

        // drill down
        if (left < n)
            _generate2(left + 1, right, n, s1);
        if (left > right && right < n)
            _generate2( left, right+1, n, s2);


        //reverse states

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.generateParenthesis(3));

    }
}
