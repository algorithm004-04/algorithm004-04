package algorithm;

/**
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: "Hello"
 * 输出: "hello"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/to-lower-case
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 位运算
 * 大写变小写、小写变大写 : ASCII码 ^= 32
 * 大写变小写、小写变小写 : ASCII码 |= 32
 * 小写变大写、大写变大写 : ASCII码 &= -33
 *
 */
public class LeetCode_709_299 {
    public static void main(String[] args) {
        LeetCode_709_299 toLowCase = new LeetCode_709_299();
        String str = toLowCase.toLowerCase("HELLO WORD");
    }

    public String toLowerCase(String str) {
        char[] c = new char[str.length()];
        for(int i =0;i< str.length();i++){
            c[i] = (char)(str.charAt(i) | 32);
        }

        return new String(c);
    }
}
