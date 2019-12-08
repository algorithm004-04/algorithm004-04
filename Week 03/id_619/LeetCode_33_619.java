class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left<right) {
            mid = (right+left)/2;
            if (nums[0]<=nums[mid]&&(target<nums[0]||target>nums[mid])) {
                left = mid+1;
            }else if (target<nums[0]&&target>nums[mid]) {
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return left==right&&nums[left]==target ? right:-1;
    }
}