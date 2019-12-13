package Algorithms.String;

//
//Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the t of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
//
//
// Example:
//
//Input: s = "abcdefg", k = 2
//Output: "bacdfeg"
//
//
//
//Restrictions:
//
// The string consists of lower English letters only.
// Length of the given string and k will in the range [1, 10000]
// Related Topics String


//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_541_334 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int t = 0; t < s.length(); t += 2 * k) {
            int i = t, j = Math.min(t + k - 1, s.length() - 1);
            while (i < j) {
                char tmp = chars[i];
                chars[i++] = chars[j];
                chars[j--] = tmp;
            }
        }
        return new String(chars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


