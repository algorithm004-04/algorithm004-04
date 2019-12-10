// 将res左移一位，读取n的最末位二进制并设置给res，n右移一位
uint32_t reverseBits(uint32_t n) {
    uint32_t res = 0;
    for (int i=0; i<32; i++) {
        res <<= 1;
        res += n&1;
        n >>= 1;
    }
    return res;
}