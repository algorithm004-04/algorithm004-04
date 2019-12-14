class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k= k% len;
        reverse(nums,0,len-1);
        reverse(nums,0,k-1);
        reverse(nums,k,len-1);
    }
    
    public static void reverse(int[] nums,int start,int end){
        int temp;
        while(start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end]= temp;
            start++;
            end--;
            
        }
    }
}