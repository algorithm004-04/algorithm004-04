class Solution {
    public boolean isAnagram(String s, String t) {
        //记录出s中字母的个数
        int[] b = new int[26];
        for(int i = 0; i < s.length(); i++) b[s.charAt(i) - 'a']++;
        for(int i = 0; i < t.length(); i++) if(--b[t.charAt(i) - 'a'] < 0) return false;
        return s.length() == t.length();
    }
}
