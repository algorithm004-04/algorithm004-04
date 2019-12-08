package com.codertoy.week07;

public class Leecode_190_339 {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= n & 1;
            n >>= 1;
        }
        return result;
    }
}
