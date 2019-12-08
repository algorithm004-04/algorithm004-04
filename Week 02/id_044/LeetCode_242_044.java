package week_02.lesson5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        //暴力法，先把字符串字符排序，然后比较是否相等
        /*
        if (s.length() != t.length()) {
            return false;
        }
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        return Arrays.equals(sc,tc);*/

        //用HashMap来处理
        /*
        if (s.length() != t.length()) {
            return false;
        }
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Map<Character,Integer> scm = new HashMap<>();
        for (Character sct : sc) {
            if (scm.containsKey(sct)) {
                scm.put(sct,(scm.get(sct) + 1));
            } else {
                scm.put(sct,1);
            }
        }
        for (Character ctr :
                tc) {
            if (scm.containsKey(ctr)) {
                scm.put(ctr,scm.get(ctr) - 1);
            } else {
                return false;
            }
        }
        return scm.values().stream().allMatch(v -> v == 0);*/

        if (s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];
        int[] diffcount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        /*for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;*/
        return Arrays.equals(counter,diffcount);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram" ,"nagaram"));
    }

}
