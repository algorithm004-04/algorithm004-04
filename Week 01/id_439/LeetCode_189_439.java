class Solution {
    public void rotate(int[] nums, int k) {
        for(int j = 0; j<k; j++) {
            int last = nums[nums.length-1];
            for ( int i = 0; i < nums.length; i++) {                
                int temp = nums[i];
                nums[i] = last;
                last = temp;
            }
        }
    }
}