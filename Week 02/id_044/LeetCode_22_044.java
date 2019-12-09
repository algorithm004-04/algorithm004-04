package week_02.lesson7;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    /**
     * n代表括号的对数，所以用生成括号的组合就是2n的长度
     * 1.递归的终止条件
     * 2.当前要处理逻辑
     * 3.递归到下一层
     * 4.回到当前层后续要处理逻辑
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        //generate(2 * n, 0, "", combinations);
        generateLeftAndRight(n, 0, 0, "", combinations);
        return combinations;
    }

    /**
     * 只找有效的括号
     * 1.判断左括号小于等于当前括号对的数量，并且右括号小于等于当前括号对的数量。
     * 如果条件不成立，返回上一层
     * 2.左括号小于当前括号对的数量，继续向下一层
     * 3.右括号小于当前括号对的数量，继续向下一层
     * @param current
     * @param left
     * @param right
     * @param s
     * @param combinations
     */
    private static void generateLeftAndRight(int current, int left, int right,
                                             String s, List<String> combinations) {
        if (left >= current && right >= current) {
            combinations.add(s);
            return;
        }
        if (left < current) {
            generateLeftAndRight(current, left + 1, right, s + "(", combinations);
        }
        if (right < left) {
            generateLeftAndRight(current, left, right + 1, s + ")", combinations);
        }
    }

    /**
     * 生成所有可能性出现的括号
     *
     * @param current      总的括号数
     * @param pos          目前所在层数
     * @param s            括号字符串
     * @param combinations 生成括号的集合
     */
/*    private static void generate(int current, int pos, String s, List<String> combinations) {
        if (pos > current) {
            combinations.add(s);
            return;
        }
        String s1 = s + "(";
        String s2 = s + ")";
        generate(current, pos + 1, s1, combinations);
        generate(current, pos + 1, s2, combinations);
    }*/
    public static void main(String[] args) {
        List<String> parenthesis = generateParenthesis(3);
        for (String s :
                parenthesis) {
            System.out.println(s);
        }

    }

}
