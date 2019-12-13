import java.util.ArrayList;
import java.util.List;

public class LeetCode_22_generate_parentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateOneByOne("", result, n, n);
        return result;
    }

    private void generateOneByOne(String sublist, List<String> result, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(sublist);
            return;
        }
        if (left > 0)
            generateOneByOne(sublist + "(", result, left - 1, right);
        if (right > left)
            generateOneByOne(sublist + ")", result, left, right - 1);
    }

    public static void main(String[] args) {
        List<String> resultList = new LeetCode_22_generate_parentheses().generateParenthesis(1);
        for (String str : resultList) {
            System.out.println("str = " + str);
        }

    }

}
