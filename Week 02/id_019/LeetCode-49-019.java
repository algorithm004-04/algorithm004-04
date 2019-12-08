class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        List<List<String>> list=new ArrayList<>();
        if(strs==null||strs.length==0)
        {
            return list;
        }
        for(String s:strs)
        {
            char[] arr=s.toCharArray();
            Arrays.sort(arr);
            String str=String.valueOf(arr);
            if(!map.containsKey(str)){
                map.put(str,new ArrayList<>());
                
            }
            map.get(str).add(s);
            
        }
         return new ArrayList<>(map.values());
    }
}