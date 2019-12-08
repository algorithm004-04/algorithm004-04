int search(int* nums, int numsSize, int target) {
    int left  = 0;
    int right = numsSize-1;
    int mid;
    while(left <= right) {
     
        mid = (left + right) / 2;
   
        if (target == nums[mid]) {
           return mid;
        }
        if (nums[mid] < nums[right]) {
            // 右边有序
           
            if (target > nums[mid] && target <= nums[right]) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        } else {
           
            if (target >= nums[left] && target < nums[mid]) {
                
                right = mid - 1;
            } else {
               
                left = mid + 1;
            }
        }
    }
    return -1;
}