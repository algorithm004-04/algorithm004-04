package com.zhk.Bit;

//leetcode 191
public class HammingWeight {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= n-1;
            count++;
        }
        return count;
    }
}
