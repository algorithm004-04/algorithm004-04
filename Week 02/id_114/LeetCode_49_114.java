/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 * 
 * Given an array of strings, group anagrams together.
 * 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 */
import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String string : strs) {
            String key = sortString(string);
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(string);
        }
        return new ArrayList<>(map.values());
    }

    private String sortString(String string) {
        char[] ch = string.toCharArray();
        Arrays.sort(ch);
        return String.valueOf(ch);
    }
}

