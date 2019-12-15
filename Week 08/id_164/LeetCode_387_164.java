class Solution {
    public int firstUniqChar(String s) {
        char[] chars=s.toCharArray();
        
        int[] times=new int[26];
        for(char c:chars){
            times[c-'a']++;
        }
        
        for(int i=0;i<chars.length;i++){
            if(times[chars[i]-'a']==1){
                return i;
               
            }
        }
        return -1;
    }
}
