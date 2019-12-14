package week_08.lesson20;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    public int firstUniqChar(String s) {
        if (null == s || "".equals(s)) {
            return -1;
        }
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            map.put(key,map.getOrDefault(key,0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

}
