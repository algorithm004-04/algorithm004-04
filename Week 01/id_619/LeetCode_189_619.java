class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int index = len-1;
        for (int i=0; i<k; i++) {
            int tmp = nums[len-1];
            for (int j=index; j>=1; j--) {
                nums[j] = nums[j-1];
            }
            nums[0]= tmp;
        }
    }
}