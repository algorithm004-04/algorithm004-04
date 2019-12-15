
class Solution {

 
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int cur = 0;
        while(len >= 2*k){
            sb.append(new StringBuilder(s.substring(cur, cur+k)).reverse().append(s.substring(cur+k, cur+2*k)));
            len -= 2*k;
            cur += 2*k;
        }
        if(len < k){
            sb.append(new StringBuilder(s.substring(cur)).reverse());
        }else if(len < 2*k){
            sb.append(new StringBuilder(s.substring(cur, cur+k)).reverse().append(s.substring(cur+k)));
        }
        return sb.toString();
    }
}
