class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0||nums==null)
        {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while(start+1<end)
        {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[start] < nums[mid]) {
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
        }
    
}