class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        if (nums.length == 0) {
            return j;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            } 
        }
        return  j + 1;
    }
}