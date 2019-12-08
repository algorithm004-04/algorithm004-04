package SuanFa.Week02;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 *
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Neo
 */
public class LeetCode_242_574 {
    public static void main(String[] args) {
        String str1 = "anagram";
        String str2 = "nagaram";
        System.out.println(isAnaGram2(str1,str2));

    }

    /***
     * 用函数先排好序
     * @param str1
     * @param str2
     * @return
     */
    private static boolean isAnaGram1(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        String newStr1 = SortString(str1);
        String newStr2 = SortString(str2);
        return newStr1.equalsIgnoreCase(newStr2);
    }

    private static String SortString(String str) {
        char[] s = str.toCharArray();
        Arrays.sort(s);
        return String.valueOf(s);
    }

    /***
     * 统计各个字母出现的次数，一个加，一个减，最终为0则证明两个字符串的字母数量一样
     * @param str1
     * @param str2
     * @return
     */
    private static boolean isAnaGram2(String str1,String str2) {
        if (str1.length() != str2.length()) return false;
        int count[] = new int [26];
        for (int i=0;i<str1.length();i++) {
            count[str1.charAt(i)-'a']++;
            count[str2.charAt(i)-'a']--;
        }
        for (int i= 0;i<count.length;i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }


}
