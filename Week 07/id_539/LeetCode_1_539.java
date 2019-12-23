public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }

            //左移一位，准备在下次循环计算更靠右边一位是否为1
            mask <<= 1;
        }

        return count;
    }
}