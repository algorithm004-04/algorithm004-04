class Solution {
    public void moveZeroes(int[] nums) {
        int zeroCount = 0;        
        for (int i = 0; i < nums.length ; ++i) {
            if (nums[i] == 0) {
                zeroCount++; 
            } else {
                nums[i-zeroCount] = nums[i];
                if (zeroCount != 0){
                    nums[i] = 0;
                }                
            }    
        }        
    }
}