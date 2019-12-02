/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        rotate3(nums, k);
    }

    private void rotate1(int[] nums, int k) {
        int temp, prev;
        for (int i=0; i<k; i++){
            prev = nums[nums.length-1];
            for(int j=0; j<nums.length;j++){
                temp = nums[j];
                nums[j] = prev;
                prev = temp;
            }
        }
    }
    
    private void rotate2(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k ) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while(start != current);
        }
        
    }
    
    private void rotate3(int[] nums, int k) {
        k = k%nums.length;
        reverse(nums,0,nums.length - 1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        
    }
    
    public void reverse(int[] nums, int start, int end){
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
// @lc code=end

