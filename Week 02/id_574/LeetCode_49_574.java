package SuanFa.Week02;

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
 *
 * 说明：
 *
 *
 * 	所有输入均为小写字母。
 * 	不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Neo
 */
public class LeetCode_49_574 {
    public static void main(String[] args) {
        String strs[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> newStrs = groupAnagrams1(strs);
        System.out.println(newStrs);
    }

    private static List<List<String>> groupAnagrams1(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String,List> map= new HashMap<>();
        for (int i=0;i<strs.length;i++) {
            char [] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String s = String.valueOf(temp);
            if (!map.containsKey(s)) {
                map.put(s,new ArrayList());
            }
            map.get(s).add(strs[i]);
        }
        return new ArrayList(map.values());
    }
}
