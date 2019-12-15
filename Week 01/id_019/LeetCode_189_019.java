class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length==0||nums==null)
        {
            return;
        }
        int len=nums.length;
        k=k%len;
        for(int i=0;i<(len-k)/2;i++)
        {
            int temp=nums[i];
            nums[i]=nums[len-k-1-i];
            nums[len-k-1-i]=temp;
        }
        for(int i=len-k;i<(len-k+len)/2;i++)
        {
             int temp=nums[i];
            nums[i]=nums[len-k+len-i-1];
            nums[len-k+len-i-1]=temp;
        }
        for(int i=0;i<len/2;i++)
        {
            int temp=nums[i];
            nums[i]=nums[len-i-1];
            nums[len-i-1]=temp;
        }
        
    }
}