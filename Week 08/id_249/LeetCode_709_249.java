//实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入: "Hello"
//输出: "hello" 
//
// 示例 2： 
//
// 
//输入: "here"
//输出: "here" 
//
// 示例 3： 
//
// 
//输入: "LOVELY"
//输出: "lovely"
// 
// Related Topics 字符串



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String toLowerCase(String str) {
        String ans = "";
        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            a = tolowercase(a);
            ans += a;
        }
        return ans;
    }

    public char tolowercase(char t) {
        if (t >= 'A' && t <= 'Z') {
            t = (char)(t+32);
        }
        return t;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
