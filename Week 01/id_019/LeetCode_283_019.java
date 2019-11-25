class Solution {
    public void moveZeroes(int[] nums) {
        int index=0;
        int count=0;
        if(nums.length==0||nums==null)
        {
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=0)
            {
                nums[index]=nums[i];
                index++;
                count++;
                
            }
        }
        for(int j=index;j<nums.length;j++)
        {
            nums[j]=0;
        }
        
    }
}