//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//        输入: s = "anagram", t = "nagaram"
//        输出: true

import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    //方法1
//    public boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) {
//            return false;
//        }
//        char[] str1 = s.toCharArray();
//        char[] str2 = t.toCharArray();
//        Arrays.sort(str1);
//        Arrays.sort(str2);
//        return Arrays.equals(str1,str2);
//    }

// 方法二
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}