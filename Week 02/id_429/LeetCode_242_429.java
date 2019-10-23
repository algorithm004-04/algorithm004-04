package id_429;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <pre>
 *      示例 1:
 *      输入: s = "anagram", t = "nagaram"
 *      输出: true
 *      示例 2:
 *      输入: s = "rat", t = "car"
 *      输出: false
 * </pre>
 * 来源：https://leetcode-cn.com/problems/valid-anagram
 *
 * @author liqiuying
 * @date 2019-10-22
 */
public class LeetCode_242_429 {

    /**
     * 数组排序
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        for (int i = 0; i < sChar.length; i++) {
            if (sChar[i] != tChar[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
}