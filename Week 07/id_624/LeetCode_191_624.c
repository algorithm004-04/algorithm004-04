// 每次n和n-1相与会消去一个最右侧的二进制1
int hammingWeight(uint32_t n) {
    int count = 0;
    while (n) {
        count++;
        n &= (n - 1);
    }
    return count;
}