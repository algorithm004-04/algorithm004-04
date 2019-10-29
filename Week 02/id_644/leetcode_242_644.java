package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class anagram {
    public static void main(String[] args) {
        String s1 = "aer";
        String s2 = "ear";
        System.out.println(isAnagram_sort(s1,s2));
        System.out.println(isAnagram_map(s1,s2));

    }
    //排序法
    public static boolean isAnagram_sort(String s, String t) {
        if(s.length() != t.length())
            return false;
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);

        return Arrays.equals(str1, str2);
    }
    //简单map 到数组内
    public static boolean isAnagram_map(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] countAlphbet = new int[26];
        for(int i = 0; i< s.length(); i++){
            countAlphbet[s.charAt(i) - 'a']++;
        }
        for(int j= 0; j<s.length();j++){
            countAlphbet[t.charAt(j)-'a']--;
            if(countAlphbet[t.charAt(j)-'a'] < 0)
                return false;
        }
        return true;
    }

}
