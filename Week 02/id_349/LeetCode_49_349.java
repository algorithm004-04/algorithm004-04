/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分�?
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        
        Arrays.sort(strs);
        for (int i = 0; i < strs.length; i++) {
            String temp = strs[i];
            char[] ch = temp.toCharArray();
            Arrays.sort(ch);
            if (map.containsKey(String.valueOf(ch))) {
                map.get(String.valueOf(ch)).add(strs[i]);
            } else {
                List<String> each = new ArrayList<>();
                each.add(strs[i]);
                map.put(String.valueOf(ch), each);
            }
        }
        for (List<String> item: map.values()) {
            res.add(item);
        }
        return res; 
    }
}
// @lc code=end

