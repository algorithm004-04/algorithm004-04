/*
	看了一眼题目，发现一脸懵逼，不知道怎么写了，就放哪了，不知道怎么办，结果过来一天以后又来看，还是不知道，看了一眼题解，发现用最笨的方法，一次次移动就行了
	自己一直以为要用时间负载度为O(1)的算法，仔细一看是空间复杂度是O(1)的算法，还是没有仔细看清楚题目就开始 做题了，不要怕懵逼，懵逼了就用最简单的方法解决，动手动手再动手。
	克服恐惧心理，不要害怕，一点点分析就行，给自己鼓励
	
	看了10分钟没有思路的话就看题解
*/

// 直接做k次向右移动
void rotate(int* nums, int numsSize, int k){
    int i;
    for (i = 0;i < k;k++) {
        rotateOnce(nums,numsSize);
    }
}

void rotateOnce(int *nums,int numsSize) {
    int j,temp;
    temp = a[numsSize-1];
    for (j = numsSize;j>=1;j--) {
        nums[j] = nums[j-1];
    }
    nums[0] = temp;
}