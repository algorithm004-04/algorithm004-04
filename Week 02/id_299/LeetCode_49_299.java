package algorithm;


import java.util.*;

/**
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 异位词：字符串字母顺序不一样
 *
 * https://leetcode-cn.com/problems/group-anagrams/
 */
public class LeetCode_49_299 {

    /**c
     * 排序法
     * 边界条件： 长度为0 返回空
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs){
        if(strs.length ==0) return new ArrayList<>();

        Map<String,List> map = new HashMap<>();
        // 循环判断
        for(String s : strs){
            char[] a = s.toCharArray();
            Arrays.sort(a);
            String key = String.valueOf(a);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(s);
        }

        return new ArrayList(map.values());
    };

    /**
     * 计数法
     * 边界条件： 长度为0 返回空
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams2(String[] strs){
        if(strs.length ==0) return new ArrayList<>();

        Map<String,List> map = new HashMap<>();
        // 初始化 26字母表
        int[] abc = new int[26];
        // 循环判断
        for(String s : strs){
            Arrays.fill(abc,0);
            StringBuilder sb = new StringBuilder("");
            for(int i =0; i<s.length();i++){
                abc[s.charAt(i) - 'a'] ++;
            }

            for(int i =0; i<abc.length;i++){
                sb.append(abc[i]);
            }

            String key = sb.toString();
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(s);
        }

        return new ArrayList(map.values());
    };


    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = GroupAnagrams.groupAnagrams2(strs);

        for (int i = 0 ; i< list.size();i++){
            System.out.println("str[]========>"+list.get(i));
        }
    }
}
