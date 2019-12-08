class Solution {
    public void rotate(int[] nums, int k) {
        int[] nums2 = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            nums2[(i + k) % nums.length] = nums[i];           
        }
        for (int i = 0; i < nums2.length; i++) {
            nums[i] = nums2[i];
        }
    }
}