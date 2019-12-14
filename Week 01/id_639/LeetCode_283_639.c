/*
	Move Zeroes
	
	1. 读题，审题，把题目理解清楚
	
	2. 思考更多的解法
	   解法1: 将非0所在的元素的位置标记出来放入一个数组当中，然后将循环数组，将非0元素位置对应的值放入进去，然后剩余位置补0
			 减少复杂度:不需要记录位置，直接记录该位置的值就可以
	   
	   解法2: 定义两个下标,1个用于向前走，标识非0的位置，1个从头开始，将非0位置的元素从前面开始放置
		
	3. 比较两种解法的时间复杂度和空间复杂度
	   解法1: 
			时间复杂度: O(n): 遍历两边数组，一遍进行标记非0元素，一遍进行放置元素
			空间复杂度: O(n): 需要存放非0元素所在位置的下标地址
			
	   解法2:
			时间复杂度: O(n): 遍历一遍数组
			空间复杂度: O(1): 存放临时变量
*/

// 解法1 

void moveZeroes(int* nums, int numsSize){
    int i;
    int j = 0;
    
    int *noZeros = malloc(numsSize * sizeof(int));
    
    for (i = 0;i < numsSize;i++) {
        if (nums[i]) {
             noZeros[j] = nums[i];       
             j++;
        }
    }
    
    for (i = 0;i < numsSize;i++) {
        if (i < j) {
            nums[i] = noZeros[i];
        }else {
            nums[i] = 0;
        }
    }
}

// 解法2
void moveZeroes(int* nums, int numsSize){
    int i,j=0;

    for (i = 0;i < numsSize;i++) {
        if (nums[i]) {
            nums[j] = nums[i];
            j++;
        }
    }
    
    for (i = j;i < numsSize;i++) {
        nums[i] = 0;
    }
    
}

