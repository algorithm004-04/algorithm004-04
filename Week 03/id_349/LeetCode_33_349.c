/* 首先找出无序的点，然后再判断目标值在哪个范围，最后再用二分查找对相应范围内查找 */
int search(int* nums, int numsSize, int target){
    int disorder, mid;
    int left, right;

    if (nums == NULL || numsSize == 0) {
        return -1;
    }

    /* 定位到前半段有序的最后一个节点 */
    left = 0;
    right = numsSize - 1;
    while (left <= right) { 
        mid = left + (right - left) / 2;
        if (mid == (numsSize - 1)) {
            disorder = numsSize -1;
            break;
        }
        else if (nums[mid] > nums[mid + 1]) {
            disorder = mid;
            break;
        }
        /* 不能忘记 nums[mid] == nums[left] 的情况*/
        else if (nums[mid] >= nums[left]) {
            left = mid + 1;
        }
        else {
            right = mid - 1;
        }
    }

    /* 找出目标值在哪一个部分 */
    if (target >= nums[0] && target <= nums[disorder]) {
        left = 0;
        right = disorder;
    }
    else if (disorder < (numsSize -1) && 
        target >= nums[disorder + 1] && 
        target <= nums[numsSize - 1]) {
        left = disorder + 1;
        right = numsSize - 1;
    }
    else {
        return -1;
    }

    /* 对目标值所在部分进行正常的二分查找 */
    while (left <= right) {
        mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            break;
        }
        else if (nums[mid] < target) {
            left = mid + 1;
        }
        else {
            right = mid - 1;
        }
    }

    /* 需要考虑找不到目标值的情况 */
    return left > right ? -1 : mid;
}


// @lc code=end

