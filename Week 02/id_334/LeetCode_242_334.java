package Hash;

//Given two strings s and t , write a function to determine if t is an anagram of s.
//
// Example 1:
//
//
//Input: s = "anagram", t = "nagaram"
//Output: true
//
//
// Example 2:
//
//
//Input: s = "rat", t = "car"
//Output: false
//
//
// Note:
//You may assume the string contains only lowercase alphabets.
//
// Follow up:
//What if the inputs contain unicode characters? How would you adapt your solution to such case?
// Related Topics Hash Table Sort


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_242_334 {


    /**
     * O(nlogn)
     *Runtime: 7 ms, faster than 39.14% of Java online submissions for Valid Anagram.
     Memory Usage: 38.4 MB, less than 54.19% of Java online submissions for Valid Anagram.
     */
    public static boolean isAnagramV1(String s,String t){
        if (s.length() != t.length()) {
            return false;
        }
        char [] ss = s.toCharArray();
        char [] ts = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(ts);
        return Arrays.equals(ss,ts);
    }

    /**
     * O(n)
     * Runtime: 4 ms, faster than 79.37% of Java online submissions for Valid Anagram.
     Memory Usage: 37.2 MB, less than 97.42% of Java online submissions for Valid Anagram.
     */
    public static boolean isAnagramV2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (--arr[s.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


