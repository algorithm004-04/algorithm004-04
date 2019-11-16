class Solution {
    public boolean canJump(int[] nums) {


        int n = nums.length - 1;
        int start = n - 1;
        int end = n;
        while (start >= 0) {
            if (start + nums[start] >= end) {
                end = start;
            }

            start--;
        }
        return end <= 0;


    }
}