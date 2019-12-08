/**
 * LeetCode_680
 *
 * @Author blackberry
 * @Date 2019/12/8 7:23 PM
 **/
public class LeetCode_680_034 {

    public boolean validPalindrome(String s) {
        int n = s.length();
        for (int i = 0, j = n - 1; i < j; ++ i, -- j) {
            if (s.charAt(i) == s.charAt(j)) {
                continue;
            }
            return isValid(s, i + 1, j) || isValid(s, i, j - 1);
        }
        return true;
    }

    private boolean isValid(String s, int i, int j) {

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i ++;
            j --;
        }
        return true;
    }
}
