/*
	1. 读题分析和理解题目:返回数组中和为target的数组元素的下标
	
	2. 思考更多的解法
		解法1: 暴力求解
		
		解法2: hash 将每个元素构建一个hash表，然后 targe - 元素 = 需要的元素，判断需要的元素是否在hash表当中

		解法3: 使用结构体数组，将每一个数组元素记录它的下标，然后对结构体数组进行排序，保持对应下标，然后使用左右夹逼进行查找记录
			 
	3. 对比分析时间复杂度和空间复杂度
	
		暴力求解: 
			   时间复杂度: O(n^2)
			   空间复杂度: O(1)
		hash表:
			  时间复杂度:O(n)
			  空间复杂度:O(n):需要一个同等大小的数组存放hash表中的值
			  
		保持数组索引下标进行排序后查找:
			  时间复杂度: O(nlogn) 需要进行排序
			  空间复杂度: O(1)
	
		优化思路:
				空间换时间
				升维
*/


// 解法1 
int* twoSum(int* nums, int numsSize, int target, int* returnSize){
    
    int i,j;
    
    int *ret = malloc(sizeof(int) * numsSize);
    *returnSize = 0;
    
    for (i = 0;i < numsSize;i++) {
        for (j = i+1;j < numsSize;j++) {
            if (target == nums[i] + nums[j]) {
                ret[0] = i;
                ret[1] = j;
                
                *returnSize =2;
            } 
        }
    }
    
    return ret;
}

// 解法2  hash table todo




// 解法3  构造索引数组，然后保持索引下标进行排序
struct arrIndex{
    int index;
    int data;
};

int comp(const void *s1,const void *s2) {
    return ((const struct arrIndex*)s1)->data - ((const struct arrIndex*)s2)->data;
}

int* twoSum(int *nums,int numsSize,int target,int* returnSize) {
    struct arrIndex newArr[numsSize];
    int i;

    for (i = 0;i < numsSize;i++) {
        newArr[i].index = i;
        newArr[i].data = nums[i];
    }

    int *ret = malloc(numsSize * sizeof(int));
    *returnSize = 0;

    qsort(newArr,numsSize,sizeof(struct arrIndex),comp);

    int left = 0,right = numsSize - 1;
    int sum;
    while (left < right) {
        sum = newArr[left].data + newArr[right].data;
        
       
        if (sum > target) {
            right--;
        }else if (sum < target) {
            left++;
        }else {
            ret[0] = newArr[left].index;
            ret[1] = newArr[right].index;
            *returnSize = 2;
            break;
        }
    }
    
    return ret;
}
