import java.util.*;

/*

49. 字母异位词分组
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

在这里使用两种解法
第一种解法中 循环遍历数组中的每个元素，然后和结果集中的元素比较，是否是异位词，如果是，则加入这个集合中
如果不是，则新创建一个集合加入

第二种解法使用哈希表

在循环遍历过程中，先将字符串进行排序，然后存入哈希表中对应的位置下面即可。
核心是使用排序做了单个字符串的异位词判断
*
*
 */
public class LeetCode_48_269 {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
                List<String> item = new ArrayList<>();
                item.add(strs[i]);
                map.put(key, item);
            }
        }

        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams1(String[] strs) {


        List<List<String>> res = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {

            boolean add = true;

            for (int j = 0; j < res.size(); j++) {
                List<String> t = res.get(j);
                if (isAnagram(strs[i], t.get(0))) {
                    t.add(strs[i]);
                    add = false;
                    break;
                }
            }

            if (add) {
                List<String> item = new ArrayList<>();
                item.add(strs[i]);
                res.add(item);
            }
        }

        return res;
    }

    public boolean isAnagram(String s1, String s2) {
        int[] arr = new int[26];

        if (s1.length() != s2.length()) return false;

        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a']++;
            arr[s2.charAt(i) - 'a']--;
        }

        for (int value : arr) {
            if (value != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        new LeetCode_48_269().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}
