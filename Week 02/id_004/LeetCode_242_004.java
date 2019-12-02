import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()){
            return false;
        }

        int[] counter = new int[26];
        for (int i =0; i < s.length(); i++){
            counter[s.charAt(i) - 'a'] ++;
            counter[t.charAt(i) - 'a'] --;
        }

        for (int i = 0; i < counter.length; i++){
            if (counter[i] != 0){
                return false;
            }
        }

        return true;


    }
}