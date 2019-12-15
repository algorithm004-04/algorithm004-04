/**
 * LeetCode_917_034
 * 仅仅反转字母
 * @Author blackberry
 * @Date 2019/12/8 6:59 PM
 **/
public class LeetCode_917_034 {

    public String reverseOnlyLetters(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        StringBuilder res = new StringBuilder();

        for (int i = 0, j = s.length() - 1; i < s.length(); ++ i) {
            if (Character.isLetter(s.charAt(i))) {
                while (!Character.isLetter(s.charAt(j))) {
                    j --;
                }
                res.append(s.charAt(j --));
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
