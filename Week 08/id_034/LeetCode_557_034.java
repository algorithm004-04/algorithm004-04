/**
 * LeetCode_557_034
 *
 * @Author blackberry
 * @Date 2019/12/8 6:54 PM
 **/
public class LeetCode_557_034 {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        String[] words = s.split(" +");
        StringBuilder res = new StringBuilder();
        for (String word : words) {
            res.append(new StringBuilder(word).reverse().toString() + " ");
        }
        return res.toString().trim();
    }
}
