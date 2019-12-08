import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode_438_034
 *
 * @Author blackberry
 * @Date 2019/12/8 7:07 PM
 **/
public class LeetCode_438_034 {

    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        int[] needs =  new int[26];
        int[] window = new int[26];

        int left = 0;
        int right = 0;
        int total = p.length();

        for (char c : p.toCharArray()) {
            needs[c - 'a'] ++;
        }

        while (right < s.length()) {
            char chr = s.charAt(right);
            if (needs[chr - 'a'] > 0) {
                window[chr - 'a'] ++;
                if (window[chr - 'a'] <= needs[chr - 'a']) {
                    total --;
                }
            }

            while (total == 0) {
                if (right - left + 1 == p.length()) {
                    res.add(left);
                }

                char chl = s.charAt(left);
                if (needs[chl - 'a'] > 0) {
                    window[chl - 'a'] --;
                    if (window[chl - 'a'] < needs[chl - 'a']) {
                        total ++;
                    }
                }
                left ++;
            }
            right ++;
        }
        return res;
    }
}
