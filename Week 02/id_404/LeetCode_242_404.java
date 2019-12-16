/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] alphabets = new int[26];

        for (char c: s.toCharArray()) {
            alphabets[c - 'a']++;
        }
        for (char c: t.toCharArray()) {
            alphabets[c - 'a']--;
        }

        for (int count: alphabets) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] alphabets = new int[26];

        for (char c: s.toCharArray()) {
            alphabets[c - 'a']++;
        }

        for (char c: t.toCharArray()) {
            if (--alphabets[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
