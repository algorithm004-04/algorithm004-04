class Solution {
    public boolean isAnagram(String s, String t) {
        if(s==null||t==null)
        {
            return false;
        }
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(map.get(c)==null)
            {
                map.put(c,1);
            }
            else
            {map.put(c,map.get(c)+1);}
        }
        for(int i=0;i<t.length();i++)
        {
            char c=t.charAt(i);
            if(map.get(c)==null)
            {
                return false;
            }
            map.put(c,map.get(c)-1);
        }
       Set set=map.keySet();
		Iterator it=set.iterator();
		while(it.hasNext())
		{
			if((int)map.get(it.next())!=0)
			{
				return false;
			}
		}
        return true;
    }
}