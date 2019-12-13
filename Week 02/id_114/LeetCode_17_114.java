/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> result = new ArrayList<>();
        helper(result, "", digits, map, 0);
        return result;
    }

    private void helper(List<String> result, String s, String digits, Map<Character, String> map, int i) {
        if (i == digits.length()) {
            result.add(s);
            return;
        }

        String letters = map.get(digits.charAt(i));
        for (int j = 0; j < letters.length(); j++) {
            helper(result, s + letters.charAt(j), digits, map, i + 1);
        }
    }
}
// @lc code=end

