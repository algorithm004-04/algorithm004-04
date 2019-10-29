package com.company;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class groupAnagram {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = new ArrayList<>();

        res = groupAnagrams(strs);
        System.out.println(res);


    }

    //normal  熟悉hashmap的用法 O(nklogk)
    public static List<List<String>> groupAnagrams_normal(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List> ans = new HashMap<String, List>();
        for (String str : strs) {
            char[] tempc = str.toCharArray();
            Arrays.sort(tempc);
            String keys = String.valueOf(tempc);
            if (!ans.containsKey(keys))
                ans.put(keys, new ArrayList());
            ans.get(keys).add(str);
        }
        return new ArrayList(ans.values());
    }

    // key 节省生成key的时间 O(nk)
    public static List<List<String>> groupAnagrams_alph(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List> ans = new HashMap<String, List>();
        int[] alph = new int[26];
        for (String str : strs) {
            Arrays.fill(alph,0);
            for (char c : str.toCharArray()) {
                alph[c - 'a']++;
            }
            StringBuilder bkey = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                bkey.append('#');
                bkey.append(alph[i]);
            }
            String key = bkey.toString();
            System.out.println(key);
            if (!ans.containsKey(key))
                ans.put(key, new ArrayList());
            ans.get(key).add(str);

        }
        return new ArrayList(ans.values());

    }

    //质数方法 O(nk)
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<Integer, List> ans = new HashMap<Integer, List>();
        int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103 };
        for(String str: strs){
            int key =1;
            for(char c : str.toCharArray()) {
                key *= prime[c - 'a'];
            }
            System.out.println(key);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(str);
        }
        return new ArrayList(ans.values());
    }


}




