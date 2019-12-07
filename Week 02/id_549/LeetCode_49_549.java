
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


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] count = new int[26];
            for(int j = 0;j < strs[i].length();j++) {
                count[strs[i].charAt(j) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i1 = 0; i1 < count.length; i1++) {
                sb.append(count[i1]);
            }
            map.putIfAbsent(sb.toString(),new ArrayList<>());
            map.get(sb.toString()).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }
}

//class Solution3 {
//    public List<List<String>> groupAnagrams(String[] strs) {
//        HashMap<String,List<String>> map = new HashMap<>();
//        for (int i = 0; i < strs.length; i++) {
//            char[] arr = strs[i].toCharArray();
//            Arrays.sort(arr);
//            String sortStr = Arrays.toString(arr);
//            map.putIfAbsent(sortStr,new ArrayList<>());
//            map.get(sortStr).add(strs[i]);
//        }
//
//        return new ArrayList<>(map.values());
//
//    }
//}