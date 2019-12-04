package SuanFa.Week02;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Neo
 */
public class LeetCode_22_574 {
    public static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        int n = 3;
        generateKuoHao(n);
        System.out.println(list);

    }

    private static void generateKuoHao(int n) {
        int left = 0;
        int right = 0;
        String str = "";
        generateK(left,right,n,str);
    }

    private static void generateK(int left, int right, int n,String str) {
        if (left + right == 2*n) {
            list.add(str);
        }
        if (left < n) generateK(left+1,right,n,str+"(");
        if (right < left) generateK(left,right+1,n,str+")");
    }

}
