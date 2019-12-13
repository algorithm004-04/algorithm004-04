class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int n = nums.length;
        nums = reverse(nums,0,n-1);
        nums = reverse(nums,0,k-1);
        nums = reverse(nums,k,n-1);

    }

    private static int[] reverse(int[] nums, int start, int end) {
        int temp;
        while(start < end){
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        return nums;
    }
}