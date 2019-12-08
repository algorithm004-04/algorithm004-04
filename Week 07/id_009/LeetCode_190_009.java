/**
 * https://leetcode-cn.com/problems/reverse-bits/
 */
public class LeetCode_190_009 {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) + (n & 1);
            n >>= 1;
        }
        return result;
    }
}
