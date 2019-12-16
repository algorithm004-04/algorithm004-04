import java.util.ArrayList;
import java.util.List;

/*
给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

规则
1. 左括号必须先出现
2. 左括号用完后全都是右括号
3. 左右括号都用完之后结束-递归终止条件
4. 左括号数字大于右括号时才能放右括号
 */
public class LeetCode_22_269 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        generate(0, 0, n, "", res);
        return res;
    }

    private void generate(int left, int right, int max, String str, List<String> res) {
        if (str.length() == max * 2) {
            res.add(str);
            return;
        }

        if (left < max) {
            generate(left + 1, right, max, str + "(", res);
        }

        if (left > right) {
            generate(left, right + 1, max, str + ")", res);
        }
    }

    public static void main(String[] args) {
        new LeetCode_22_269().generateParenthesis(3);
    }
}
