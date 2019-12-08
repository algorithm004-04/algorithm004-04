import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */
public class LeetCode_387_009 {
    public static void main(String[] args) {
        LeetCode_387_009 test=new LeetCode_387_009();
        System.out.println(test.firstUniqCharForFun("leetcode"));
    }

    public int firstUniqCharForBaoLi(String s) {
        if (s.length() < 2) {
            return s.length() - 1;
        }
        for (int i = 0; i < s.length(); i++) {
            String c = "" + s.charAt(i);
            if (!s.substring(0, i).contains(c) && !s.substring(i + 1).contains(c)) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqCharForMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqCharForFun(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s.indexOf(c) == s.lastIndexOf(c)) {
                return i;
            }
        }
        return -1;
    }
}
