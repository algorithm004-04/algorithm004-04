/*
	给定两个整数n和k,返回 1...n中所有可能的k个数的组合
	
	n = 4, k = 2
	
	切题四件套:
			1. 分析题意 把题目意思理解透彻，然后考虑题目涉及到的特殊情况
			
			2. possible solution => find good solution  空间复杂度和时间复杂度都比较小的方法
			
			3. Code
			
			4. test case. 测试边界值
			
		这道题和老师讲的那道放左右括号的题目比较类似，有2个格子，把4个数字放进去，可以放也可以不放
		
		这道题会不会写，递归都是可以解决的，先把我们的代码模板写上去
		
		
		int recursive(int level,int param) {
			// terimator
			if () {
				return;
			}
			
			// process current logic,处理当前的逻辑
			
			// drill down
			
			recursive(level+1,int newParam)
			
			// reverse state
		}
	
	知道怎么分析了，最好发现还是自己写不出来，去国际站看看别人写的C代码参考了一下
	refer from https://leetcode.com/problems/combinations/discuss/411806/C-simple-solution
	https://leetcode.com/problems/combinations/discuss/405443/Accepted-C-code-beat-94
*/

// 计算C(n,k)
int comp(int n,int k) {
    // 分子
    long mol = 1;
    // 分母
    long den = 1;

    int i,j;

    for (i = 1;i <= k;i++) {
        den = den * i;
    }

    for (j = 0;j < k;j++) {
         mol = mol * (n - j);
    }

    int total = 0;

    if (den) {
        total =  mol / den;
    }
    return total;
}

void generateCombine(int **ret,int *arr,int arrLen,int n,int k,int *retLen,int idx) {
    // terminator
    if (arrLen == k) {
        ret[*retLen] = (int *)malloc(sizeof(int) * k);
        memcpy(ret[*retLen],arr,sizeof(int) * k);
        (*retLen) = (*retLen) + 1;
        return;
    }
    int i;
    for (i = idx;i <=n;i++) {
        arr[arrLen] = i;
        generateCombine(ret,arr,arrLen+1,n,k,retLen,i+1);
    }
}

int** combine(int n,int k,int* returnSize,int** returnColumnSizes) {
    long total;
    // 求 C (n,k)
    total = comp(n,k);
    int **ret = malloc((total + 1) * sizeof(int *));

    int *arr;
    arr = malloc(k * sizeof(int));
    int arrLen = 0;
    int retLen = 0;

    generateCombine(ret,arr,arrLen,n,k,&retLen,1);

    // 二维数组的长度
    *returnSize = retLen;
    *returnColumnSizes=malloc(sizeof(int)*(*returnSize));

    int i=(*returnSize) - 1;
    while (i >= 0) {
        (*returnColumnSizes)[i--] = k;
    }
    return ret;
}






