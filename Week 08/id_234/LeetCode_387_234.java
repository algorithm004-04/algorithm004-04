package week_08;

import java.util.HashMap;

public class LeetCode_387_234 {
  public int firstUniqChar(String s) {

    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    }
    for (int i = 0; i < s.length(); i++) {
      if (map.get(s.charAt(i)) == 1) return i;
    }
    return -1;
  }
}
