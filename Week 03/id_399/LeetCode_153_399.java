class Solution {
    public int findMin(int[] nums) {
        if(nums==null){
            return 0;
        }
        int low=0;
        int high=nums.length;
        int temp=nums[nums.length-1];
        while(low<high){
            int mid=low+((high-low)>>1);
            if(nums[mid]>temp){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return nums[low];
    }
}
