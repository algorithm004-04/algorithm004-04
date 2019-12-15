import java.util.Arrays;

/**
 * Created by Administrator on 2019/12/15 0015.
 */
public class LeetCode_242_2_有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}
