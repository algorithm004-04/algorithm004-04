class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int diff_temp = 0;
        for(int i = 1;i< len;i++) {
            if(nums[i] != nums[diff_temp]) {
                diff_temp++;
                nums[diff_temp] = nums[i];
            }
        }
        return diff_temp+1 ;
    }
}