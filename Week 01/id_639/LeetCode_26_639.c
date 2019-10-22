/*
	Remove Duplicates from Sorted Array
	
	1. 阅读题目，分析题意
		
	2. 大胆的想，想象所有可能的解法去实现它
		
		解法1: 使用3个游标指向第一个指向开始的元素，第二个指向它后面的元素，如果第二个和第一个指向的游标相等，则第二个游标向后移动，一直移动到不相等为止,不相等的元素放到第三个游标指向的位置上面
			  第3个游标用来标记不同元素放置的位置，初始值为1  写了一半发现错了(这样做复杂了)
			  
			  正确的想法:
					  遍历一遍数组,定义下标i,每次将需要比较的值给下标i,如果不重复则i++,赋值给新的下标
					  
		想法：
			题目中是不需要考虑后面元素的变化的，如果需要考虑的话，只保留去重后的数组元素，是不是就需要借助于外部的数组了
			
	3. 时间复杂度分析: O(n)
*/


// 错误的写法，写了一个死循环，笑哭
int removeDuplicates(int* nums, int numsSize){
    int i,j,z = 1;
    
    if (numsSize == 1) {
        return 1;
    }
    
  
    for (i = 0;i < numsSize;) {
        for (j = i + 1;j < numsSize;j++) {
            if (nums[j] != nums[i]) {
                 // 遇到不想等的时候
                nums[z] = nums[j];
                i = j;
                z++;
                break;
            }
        }
       
    }
    return z;
}

// 正确的做法
int removeDuplicates(int* nums, int numsSize){
    if (numsSize == 0) {
        return 0;
    }    
    
    int i = 0;
    int j;
    
    for (j = 1;j < numsSize;j++) {
        if (nums[i] != nums[j]) {
            i++;
            nums[i] = nums[j];
        }
    }
    return i+1;
}

// 减少复制
int removeDuplicates(int* nums, int numsSize){
    if (numsSize == 0) {
        return 0;
    }    
    
    int i = 0;
    int j;
    
    for (j = 1;j < numsSize;j++) {
        if (nums[j] != nums[i]) {
			// 在想i++ 可以移动到这里么，因为if和else里面都有i++,试了一下不行，因为 if ()条件中使用到了i如果加到上面的话会影响的下边的结果
            if (j - i > 1) { 
                 i++;
                nums[i] = nums[j];
            }else {
                i++;
            }
        }
    }
    return i+1;
}

