
// 1. 快、慢双指针
// 2. 记录重复的个数，即知道每次copy的偏移量了
int removeDuplicates(int* nums, int numsSize) {
    int dupes = 0;

    for (int i = 1; i < numsSize; i++) {
        if (nums[i] == nums[i - 1]) 
            dupes++;
        nums[i - dupes] = nums[i];
    }
    return numsSize - dupes;
}

