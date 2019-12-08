public class Solution{

	public static boolean isAnagramSort(String s, String t) {
		if(s.length() != t.length()) return false;
		char[] str1 = s.toCharArray();
		char[] str2 = t.toCharArray();
		Arrays.sort(str1);
		Arrays.sort(str2);
		return Arrays.equals(str1, str2);
	}
	

	public static boolean isAnagramArray(String s, String t) {
		int[] chs = new int[26]; 
		for(int i = 0; i < s.length(); i++) {
			chs[s.charAt(i) - 'a']++;
		}
		
		for(int i = 0; i < t.length(); i++) {

			if(--chs[t.charAt(i)-'a'] < 0) {
				return false;
			}
		}
		return s.length() == t.length(); 
	}
	

	public static boolean isAnagramHashMap(String s, String t) {
		if(s == null || t == null) return false;
		if(s.length() == 0 && t.length() == 0) return true;
		if(s.length() == 0 || t.length() == 0 || s.length() != t.length()) return false;
		Map<Character,Integer> map = new HashMap<>();
		for(int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
		}
		for(int i = 0; i < t.length(); i++) {
			if(map.containsKey(t.charAt(i)) && map.get(t.charAt(i))>0) {
				map.put(t.charAt(i), map.get(t.charAt(i))-1);
			}else {  
				return false;
			}
		}
		return true;
	}
}
