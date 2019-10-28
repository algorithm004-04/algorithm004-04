class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        
        helper(new ArrayList<>(),n,k,1);
        return res;
    }
    public void helper(List<Integer> list, int n,int k,int index)
    {
        if(list.size()==k)
        {
            res.add(new ArrayList(list));
            return;
        }
        for(int i=index;i<=n;i++)
        {
            list.add(i);
            helper(list,n,k,i+1);
            list.remove(list.size()-1);
        }
    }
}