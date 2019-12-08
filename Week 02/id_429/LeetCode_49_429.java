package id_429;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 来源：https://leetcode-cn.com/problems/group-anagrams
 *
 * @author liqiuying
 * @date 2019-10-27
 */
public class LeetCode_49_429 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        Map<String, List<String>> result = new HashMap<>();
        for (String str : strs) {
            char[] charInfo = str.toCharArray();
            Arrays.sort(charInfo);
            String strInfo = String.valueOf(charInfo);
            if (result.get(strInfo) != null) {
                result.get(strInfo).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                result.put(strInfo, list);
            }
        }
        return new ArrayList(result.values());
    }

    public static void main(String[] args) {
        String[] t = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(t));
    }
}
