//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例:
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// 说明：
//
//
// 所有输入均为小写字母。
// 不考虑答案输出的顺序。
//
// Related Topics 哈希表 字符串


import java.util.*;

public class LeetCode_49_154 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> ans = new HashMap<>();
        int[] counter = new int[26];

        for (String str : strs) {
            Arrays.fill(counter, 0);

            for (char c : str.toCharArray()) {
                counter[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(counter[i]);
            }

            if (!ans.containsKey(sb.toString())) ans.put(sb.toString(), new ArrayList<String>());
            ans.get(sb.toString()).add(str);
        }

        return new ArrayList<>(ans.values());
    }
}
