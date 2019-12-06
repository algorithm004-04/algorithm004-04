class Solution {
    public int findMin(int[] nums) {
        int mid;    
        int left =0;
        int right = nums.length-1;
        while (left <= right){
            mid = (left + right) / 2;
            if(nums[mid] == nums[right]){
                break;
            }else if(nums[mid] > nums[right]){
                left = mid + 1;
            }else{
                right = mid;
            }
        } 
        return nums[left];
    }
}