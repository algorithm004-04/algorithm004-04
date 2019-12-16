import java.util.HashMap;
import java.util.Map;

/*
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

异位词指的是字母出现次数一样的两个单词

两种解法的思想是一致的，都是通过哈希表思想来实现
*
*
 */
public class LeetCode_242_269 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        int length = s.length();

        for (int i = 0; i < length; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }

        for (Map.Entry<Character, Integer> c : map.entrySet()) {
            if (c.getValue() != 0) {
                return false;
            }
        }

        return true;
    }


    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] arr = new int[26];


        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        for (int value : arr) {
            if (value != 0) return false;
        }
        return true;
    }

}
