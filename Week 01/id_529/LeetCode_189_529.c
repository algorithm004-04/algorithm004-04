#include <stdlib.h>
#include <string.h>
void rotate(int* nums, int numsSize, int k)
{
    int *temp = (int*)malloc(sizeof(int)*k);
    int i = 0;
    if (numsSize < k) {
        k = k % numsSize;
    }
    for (i = 0; i < k; i++) {
        temp[i] = nums[numsSize - k + i];
    }
    for (i = numsSize - 1; i > k - 1; i--) {
        nums[i] = nums[i-k]; 
    }
    for (i = 0; i < k; i++) {
        nums[i] = temp[i];
    }
    free(temp);
}

