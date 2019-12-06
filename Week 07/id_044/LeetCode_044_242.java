package week_07.lesson18;

import java.util.Arrays;

public class ValidAnagram {


    public static boolean isAnagram(String s, String t) {

        /*if (s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];
        int[] diffcount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        return Arrays.equals(counter,diffcount);*/

        if (s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < s.length(); i++) {
            if (counter[s.charAt(i) - 'a'] != 0) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {

    }

}
