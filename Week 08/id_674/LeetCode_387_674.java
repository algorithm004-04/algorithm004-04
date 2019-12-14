方法 1：暴力
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        
        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1) 
                return i;
        }
        return -1;
    }
}

方法 2：哈希 + Map
class Solution {
	var firstUniqChar = function(s) {
	   let hash = {};
	   let result = new Map(); 
	   for(let i = 0;i < s.length;i++){
		   if(!hash[s[i]]){
			   hash[s[i]] = 1;
			   result.set(s[i],i);
		   }else{
			   result.delete(s[i]);           
		   }
	   }
	   if(result.size == 0){
		   return -1;
	   }
	   return result.values().next().value;
	}
}

方法 3
public class Solution {
    public int firstUniqChar(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
}