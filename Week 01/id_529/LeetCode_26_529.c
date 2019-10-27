int removeDuplicates(int* nums, int numsSize){
    int j =  0;
    int i = 0;
    if (numsSize == 0) {
        return 0;
    }
    for(i = 1; i < numsSize; i++) {
        if (nums[j] != nums[i]) {
            if (++j != i) {
                nums[j] = nums[i];                  
            }                
        }
    }
    return j+1;
}

