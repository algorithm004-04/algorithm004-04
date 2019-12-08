import java.util.Arrays;
import java.util.Collections;

/**
 * LeetCode_151_034
 *
 * @Author blackberry
 * @Date 2019/12/8 6:52 PM
 **/
public class LeetCode_151_034 {

    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}
