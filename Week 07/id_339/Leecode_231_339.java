package com.codertoy.week07;

public class Leecode_231_339 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
