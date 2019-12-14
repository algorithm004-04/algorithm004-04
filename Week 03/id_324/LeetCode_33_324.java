class Solution {
    public int search(int[] nums, int target) {
        return binSearch(nums, 0, nums.length -1, target);
    }

    private int binSearch(int[] nums, int begin, int end, int target) {
        int mid = (end - begin) / 2 + begin;

        if (mid < begin || mid > end) {
            return -1;
        }

        // 递归终止条件
        if (nums[mid] == target) {
            return mid;
        } else if (nums[begin] == target) {
            return begin;
        } else if (nums[end] == target) {
            return end;
        }

        if (mid == begin || mid == end) {
            return -1;
        }

        // 判断旋转节点 [4,5,6,7,0,1,2]
        if (target > nums[mid]) {
            if (nums[mid] > nums[begin]) {
                return binSearch(nums, mid, end, target);
            }

            if (target > nums[end]) {
                return binSearch(nums, begin, mid, target);
            }

            return binSearch(nums, mid, end, target);
        }

        // target < nums[mid]
        if (nums[mid] > nums[begin]) {
            if (target < nums[begin]) {
                return binSearch(nums, mid, end, target);
            }

            return binSearch(nums, begin, mid, target);
        }

        return binSearch(nums, begin, mid, target);
    }
}