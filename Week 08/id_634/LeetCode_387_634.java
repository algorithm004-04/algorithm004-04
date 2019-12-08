class Solution {
    
    //1使用hashmap
		// public int firstUniqChar(String s) {
		// Map<Character, Integer> map = new HashMap<>();
		// // 统计每个字符次数到hashmap
		// for(int i=0; i<s.length(); i++) {
		// map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		// }
		// // 返回第一个唯一字符
		// for(int i=0; i<s.length(); i++) {
		// if(map.get(s.charAt(i)) == 1) return i;
		// }
		// // 没有则返回-1
		// return -1;
		// }
    
    //2使用数组
    public int firstUniqChar(String s) {
        int[] table = new int[26];
        // 统计每个字符次数到数组
        for (char c : s.toCharArray()) {
            table[c - 'a']++;
        }
        // 返回第一个唯一字符
        for (int i = 0; i < s.length(); i++) {
            if (table[s.charAt(i) - 'a'] == 1) return i;
        }
        // 没有则返回-1
        return -1;
    }
    
}