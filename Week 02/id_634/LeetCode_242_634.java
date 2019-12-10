class Solution {
    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length()) {
            return false;
        }
        //1. 暴力, sort, sorted_str 相等O(NlogN)
        // int[] counter = new int[26];
        // for (int i = 0; i < s.length(); i++) {
        //    counter[s.charAt(i) - 'a']++;
        //    counter[t.charAt(i) - 'a']--;
        // }
        // for (int count : counter) {
        //    if (count != 0) {
        //        return false;
        //    }
        // }
        
        //2. hash, map --> 统计每个字符的频次
        // HashMap<Integer, Integer> counter = new HashMap<Integer, Integer>();
        // for (int i = 0; i < s.length(); i++) {
        //     Integer add = counter.get(s.charAt(i) - 'a') == null ? 0 : counter.get(s.charAt(i) - 'a');
        //     counter.put(s.charAt(i) - 'a', add + 1);
        //     Integer sub = counter.get(t.charAt(i) - 'a') == null ? 0 : counter.get(t.charAt(i) - 'a');
        //     counter.put(t.charAt(i) - 'a', sub - 1);
        // }
        // for (int count : counter.values()) {
        //     if (count != 0) {
        //         return false;
        //     }
        // }
        
        //3. 最优解
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) counter[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) counter[t.charAt(i) - 'a']--;
        for (int i : counter) if (i != 0) return false;
        
        return true;
    }
}