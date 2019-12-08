package algorithm.homework.week02;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_49_374 {
    public static void main(String[] args) {
        LeetCode_49_374 l49 = new LeetCode_49_374();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(l49.groupAnagrams(strs));
    }

    /**
     * map:key为排序好的字符串，value为符合的list
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<List<String>>();
        }
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; ++i) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
              map.put(key,new ArrayList<String>());
            }
            map.get(key).add(strs[i]);
        }
        return new ArrayList<List<String>>(map.values());
    }

    /**
     * 将字符串转化为有顺序的（排序好的）hash值，比较hash值是否相等
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<List<String>>();
        }
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        int[] counter = new int[26];
        for (int i = 0; i < strs.length; ++i) {
            Arrays.fill(counter, 0);
            char[] chars = strs[i].toCharArray();
            for (int j = 0; j < chars.length; ++j) {
                counter[chars[j] - 'a']++;
            }
            StringBuilder sb =new StringBuilder();
            for (int j = 0; j < 26; ++j) {
                sb.append(counter[j]).append("#");
            }
            String key = sb.toString();
            List<String> values = null;
            if (map.containsKey(key)) {
                values = map.get(key);
            }else {
                values = new ArrayList<String>();
            }
            values.add(strs[i]);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
