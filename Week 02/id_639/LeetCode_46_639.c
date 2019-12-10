/*
	切题四件套:
		1. 分析题目，仔细理解题意，需要注意的地方多多注意
		
		2. 思考更多的解法 possible solution,选择其中一个解法进行求解 选择空间复杂度和时间复杂度都比较低的进行求解
		
		3. code
		
		4. test case
		
		这道题的意思就是有n个格子，n个不同的数，求它的排列组合
		
		也就是用过接着走，然后回来换一个顺序可以继续使用，所以这里需要记录元素是否使用过这个笔记
		
		感觉过程就是回溯

		一开始先把我们的标准递归写出来
		
		int recursive(int level,int param) {
			// terminator
			if (level > MAXSIZE) {
				
				return;
			}
			
			// process current logic
			
			// drill down
			
			// restore current status
		}
		
		不同的地方在于我们处理 restore current status的时候
*/



int comp(int num) {
    if (num <= 1) {
        return 1;
    }
    int total = 1;
    int i;
    for (i = 1;i <= num;i++) {
        total = total * i;
    }
    return total;
}

void generatePermute(int *nums,int numsSize,int *mark,int *tmp,int index, int **ret,int *retLen) {
    int i;
    for (i = 0;i < numsSize;i++) {
        if (mark[i] == 0) {
            continue;
        }
        mark[i] = 0;
        tmp[index] = nums[i];
        index++;

        if (index == numsSize) {
            ret[*retLen] = (int *)malloc(sizeof(int) * numsSize);
            //memcpy(ret[*retLen],tmp,sizeof(int) * numsSize);
            int j;
            for (j = 0;j < numsSize;j++) {
                ret[*retLen][j] = tmp[j];
            }
            (*retLen) = (*retLen) + 1;
        }
        generatePermute(nums,numsSize,mark,tmp,index,ret,retLen);
        mark[i] = 1;
        index--;
    }
}

int **permute(int *nums,int numsSize,int *returnSize,int** returnColumnSizes) {
    long total;

    total = comp(numsSize);
    
    int **ret = malloc((total + 1) * sizeof(int *));
    int retLen = 0;

    int *mark = malloc(numsSize * sizeof(int));
    int i;
    for (i = 0;i < numsSize;i++) {
        mark[i] = 1;
    }
    int *tmp = malloc(numsSize * sizeof(int));
    int index = 0;
    generatePermute(nums,numsSize,mark,tmp,index,ret,&retLen);
 
    *returnSize = retLen;
    
    *returnColumnSizes = malloc(sizeof(int)*(*returnSize));
    i = (*returnSize)-1;
    while(i >= 0) {
        (*returnColumnSizes)[i--] = numsSize;
    }
    
    return ret;
}
