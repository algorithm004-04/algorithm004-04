
// 1. �졢��˫ָ��
// 2. ��¼�ظ��ĸ�������֪��ÿ��copy��ƫ������
int removeDuplicates(int* nums, int numsSize) {
    int dupes = 0;

    for (int i = 1; i < numsSize; i++) {
        if (nums[i] == nums[i - 1]) 
            dupes++;
        nums[i - dupes] = nums[i];
    }
    return numsSize - dupes;
}

