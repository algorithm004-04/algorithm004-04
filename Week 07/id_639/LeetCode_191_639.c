/*
   方法1
   模拟手动计算0的个数
*/
int hammingWeight(uint32_t n) {
    // 转化为二进制数
    if (n <= 0) {
        return 0;
    }

    int count = 0,b;

    while (n) {
        b = n % 2;
        if (b == 1) {
            count++;
        }
        n = n / 2;
    }
    return count;
}

/*
  方法2
  循环和位移动
*/
int hammingWeight(uint32_t n) {
    int bits = 0;
    uint32_t mask = 1;
    
    int i;
    for (i = 0;i < 32;i++) {
        if ((n & mask) != 0) {
            bits++;
        }
        mask = mask << 1;
    }
    return bits;
}


/*
  方法3
  位操作的技巧,n 与 n-1 做与运算，会把最后一个1变成0
*/
int hammingWeight(uint32_t n) {
    int count = 0;
    
    while (n != 0) {
        count++;
        n &= (n - 1);
    }
    return count;
}
