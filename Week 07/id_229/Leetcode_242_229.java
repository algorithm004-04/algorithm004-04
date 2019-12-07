/**
 * Created by Administrator on 2019/12/1 0001.
 */
public class Leetcode_242_229 {
    /*
        使用计数器计算s字母的频率  用t减少计数器标中的每个字母的计数器，然后检查计数器是否回到零
     */
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
