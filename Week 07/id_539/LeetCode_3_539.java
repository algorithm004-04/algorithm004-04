public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        // int result = 0;

        // for (int i = 0; i < 32; i++) {
        //     //挑选最低位
        //     int lowestBit = n & 1;
        //     //把最低位右移到正确的位置上
        //     result = result + (lowestBit << (31 - i));
        //     n >>= 1;
        // }

        // return result;
        int result = 0;
        int count = 0;
        while (count < 32) {

            result <<= 1;//结果左移动一位，留下一个空位
            result |= n&1;//在最右边的空位上填上n的最低比特位内容
            n >>= 1;//右移是为了下次循环找到n左边数的下一个比特位
            count++;
        }

        return result;
    }
}