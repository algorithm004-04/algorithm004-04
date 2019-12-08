package week_07.lesson16;

public class NumberOfOneBits {

    public int hammingWeight(int n) {
        /*int bits = 0;
        //循环加标记法，每次把标记左移一位，然后&上n，是否为1
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if (0 != (n & mask)) {
                bits++;
            }
            mask = mask << 1;
        }
        return bits;*/

        //用n&(n-1)来运算，在二进制表示中，总是会把最低位(也可理解成最后一位)的1变成0
        int sum = 0;
        while (n != 0) {
            sum++;
            n = n & (n - 1);
        }
        return sum;
    }

    public static void main(String[] args) {

    }

}
