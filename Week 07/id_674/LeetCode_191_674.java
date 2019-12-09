方法 1：循环和位移动
public static int hammingWeight(int n) {
	int ones = 0;
    while(n!=0) {
    	ones = ones + (n & 1);
    	n = n>>>1;
    }
    	return ones;
}


方法 2：位操作的小技巧
public int hammingWeight(int n) {
    int sum = 0;
    while (n != 0) {
        sum++;
        n &= (n - 1);
    }
    return sum;
}

