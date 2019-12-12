class Solution {
  public boolean isIsomorphic(String s, String t) {
     // 如果字符串长度不一致直接返回false
     if(s.length()!=t.length()) return false;
     HashMap<Character, Character> map = new HashMap<>();
     boolean flg = true;
     for(int i=0;i<s.length();i++){
      // 判断字符串的当前字符是否在map中
      if(map.containsKey(s.charAt(i)))
       if(map.get(s.charAt(i))!=t.charAt(i)){
        return false;
       }
      }else{
       if(map.containsValue(t.charAt(i))){
        return false;
       }else{
        map.put(s.charAt(i), t.charAt(i));
       }
      }
     }
     return flg;
    }        
}
