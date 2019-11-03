package algorithm;

import java.util.Arrays;

/**
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 异位词：字符串字母顺序不一样
 *
 * https://leetcode-cn.com/problems/valid-anagram/description/
 */
public class LeetCode_242_299 {
    /**
     * 排序
     *
     * 思路： 如果是一样的字符串，排序后，字符编码一样
     * 边界条件: 字符串长度要一致
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram2(String s,String t){
        if(s.length() != t.length()){
            return false;
        }

        char[] ns = s.toCharArray();
        char[] nt = t.toCharArray();
        Arrays.sort(ns);
        Arrays.sort(nt);

        return Arrays.equals(ns,nt);
    }

    /**
     * 计数分类
     *
     * 保存26个字母表数组，下标对应相应的字母。
     * 处理：前个字符串每个字符多一个+1 后一个字符串多一个-1 判断是否0
     * 边界条件: 字符串长度要一致
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s,String t){
        if(s.length() != t.length()){
            return false;
        }
        int[] table = new int[26];
        int[] table2 = new int[26];

        for(int i =0; i< s.length();i++){
            table[s.charAt(i) -'a'] ++;
            table[t.charAt(i) -'a'] --;
        }

        return Arrays.equals(table, table2);
    }

    public static void main(String[] args) {
        boolean b = ValidAnagram.isAnagram("anagrama","nagarama");

        System.out.println("判断异位词结果---->"+b);
    }
}
