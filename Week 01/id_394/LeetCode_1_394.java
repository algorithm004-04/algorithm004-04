class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] r = new int[]{-1, -1};
        for (int i = 0; i< nums.length - 1; i++) {
            for (int j = i + 1; j< nums.length; j++) {
                if ( nums[i] + nums[j] == target) {
                    r[0] = i;
                    r[1] = j;
                    return r;
                }
            }
        }
        return r;
    }
}