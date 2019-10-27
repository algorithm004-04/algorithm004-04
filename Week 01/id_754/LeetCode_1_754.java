class Solution {
    public int removeDuplicates(int[] nums) {
        int duplicateCount = 0;
    
        for (int i = 1; i < nums.length ; ++i) {
           if (nums[i] == nums[i-1]) {
               duplicateCount++;
           } else {
               nums[i-duplicateCount] = nums[i];   
           }
        }
        
        return nums.length - duplicateCount;
    }
}