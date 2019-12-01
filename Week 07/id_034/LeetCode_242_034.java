/**
 * LeetCode_242_034
 *
 * @Author blackberry
 * @Date 2019/12/1 12:01 PM
 **/
public class LeetCode_242_034 {

    public boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int len = s1.length();
        int[] words = new int[26];
        for (int i = 0; i < len; i ++) {
            words[s1.charAt(i) - 'a'] ++;
            words[s2.charAt(i) - 'a'] --;
        }

        for (int counter : words) {
            if (counter >0) {
                return false;
            }
        }
        return true;
    }
}
