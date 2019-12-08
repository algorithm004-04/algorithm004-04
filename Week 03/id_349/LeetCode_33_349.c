/* �����ҳ�����ĵ㣬Ȼ�����ж�Ŀ��ֵ���ĸ���Χ��������ö��ֲ��Ҷ���Ӧ��Χ�ڲ��� */
int search(int* nums, int numsSize, int target){
    int disorder, mid;
    int left, right;

    if (nums == NULL || numsSize == 0) {
        return -1;
    }

    /* ��λ��ǰ�����������һ���ڵ� */
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
        /* �������� nums[mid] == nums[left] �����*/
        else if (nums[mid] >= nums[left]) {
            left = mid + 1;
        }
        else {
            right = mid - 1;
        }
    }

    /* �ҳ�Ŀ��ֵ����һ������ */
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

    /* ��Ŀ��ֵ���ڲ��ֽ��������Ķ��ֲ��� */
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

    /* ��Ҫ�����Ҳ���Ŀ��ֵ����� */
    return left > right ? -1 : mid;
}


// @lc code=end

