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



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //数组存储法
        //用一个长度为26的int数组，按特定格式拼凑成map的key
        Map<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();

        for (String word : strs) {
            int[] count = new int[26];
            for (int i = 0; i < word.length(); i ++) {
                count[word.charAt(i) - 'a'] ++;
            }
            StringBuilder key = new StringBuilder("");
            for (int i : count) {
                key.append(i + "#");
            }
            String sb = key.toString();
            if (!map.containsKey(sb.toString())) {
                map.put(sb.toString(),new ArrayList<String>());
            }
            map.get(sb.toString()).add(word);
        }
        return new ArrayList(map.values());



        //排序法
        //将每一个字符串的字母排序，再对比判断是否为异位词,将互为异位词的字符串放在同一个list中
        //Map<String,ArrayList<String>>,排序后的字符串为key,分组为value
       /* Map<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<String>());
            }
            map.get(s).add(word);
        }
        return new ArrayList(map.values());*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)
