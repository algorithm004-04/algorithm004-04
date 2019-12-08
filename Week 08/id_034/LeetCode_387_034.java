import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode_387_034
 * blackberry
 * @Author blackberry
 * @Date 2019/12/8 5:52 PM
 **/
public class LeetCode_387_034 {

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        Map<Character, Integer> map = new HashMap<>();
        char[] chs = s.toCharArray();

        for (char c : chs) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i <chs.length; i ++) {
            if (map.get(s.charAt(i)) == 1 ) {
                return i;
            }
        }

        return -1;
    }

    public int firstUniqChar1(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        char[] mem = new char[256];
        char[] chs = s.toCharArray();
        for (char c : chs) {
            mem[c]++;
        }

        for ( int i = 0; i < chs.length; i ++) {
            if (mem[s.charAt(i)] == 1) {
                return i;
            }
        }

        return -1;
    }
}
