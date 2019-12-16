package Algorithms.String;

//A message containing letters from A-Z is being encoded to numbers using the following mapping:
//
//
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//
//
// Given a non-empty string containing only digits, determine the total number of ways to decode it.
//
// Example 1:
//
//
//Input: "12"
//Output: 2
//Explanation: It could be decoded as "AB" (1 2) or "L" (12).
//
//
// Example 2:
//
//
//Input: "226"
//Output: 3
//Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
// Related Topics String Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_91_334 {
    public int numDecodings(String s) {
        int s1 = 0, s2 = 0;
        for (int i = 0; i < s.length(); i++) {
            int temp = 0;
            if ((s.charAt(i) - '0') != 0) {
                temp += Math.max(1, s1);
            }
            if (i != 0) {
                int num = (s.charAt(i - 1) - '0') * 10 + s.charAt(i) - '0';
                if (10 <= num && num <= 26) {
                    temp += Math.max(1, s2);
                }
            }
            if (temp == 0) {
                return 0;
            }
            s2 = s1;
            s1 = temp;
        }
        return s1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


