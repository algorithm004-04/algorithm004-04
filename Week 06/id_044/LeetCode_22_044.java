package week_06.lesson14;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        generateLeftAndRight(n, 0, 0, "", combinations);
        return combinations;
    }

    private void generateLeftAndRight(int current, int left, int right,
                                      String s, List<String> combinations) {
        if (left >= current && right >= current) {
            combinations.add(s);
        }
        if (left < current) {
            generateLeftAndRight(current,left + 1,right, s + "(", combinations);
        }
        if (right < left) {
            generateLeftAndRight(current, left, right + 1, s + ")", combinations);
        }
    }

}
