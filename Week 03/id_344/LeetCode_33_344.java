class Solution {
    public int search(int[] nums, int target) {
        for (int i = 0, j = nums.length - 1; i <= j; i++, j--) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[j] == target) {
                return j;
            }
        }
        return -1;
    }
}