package com.kkkkkk.demovvorld.leetcode191;

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = n & (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int a = 0b11111111111111111111111111111101;
        System.out.println(new Solution().hammingWeight(a));
    }
}
