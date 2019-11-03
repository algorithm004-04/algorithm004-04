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
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> returnMap = new HashMap<>();
        for (String str : strs) {
            String key = this.getSortStr(str);
            if (!returnMap.containsKey(key)) {
                List<String> item = new ArrayList<>();
                returnMap.put(key, item);
            }
            returnMap.get(key).add(str);
        }

        return new ArrayList(returnMap.values());
    }

    private String getSortStr(String str) {
        char[] sChars = str.toCharArray();
        Arrays.sort(sChars);
        return String.valueOf(sChars);
    }
}



