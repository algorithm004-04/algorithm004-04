class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums==null||nums.length==0)
        {
            return null;
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int temp=target-nums[i];
            if(map.containsKey(temp)){
                return new int[]{i,map.get(temp)};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}