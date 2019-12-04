package week_07.lesson16;

public class ReverseBits {

    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            //右移i位
            int tmp = n >> i;
            //有效位是否为1
            tmp = tmp & 1;
            //反转位置
            tmp = tmp << (31 - i);
            //
            result = result | tmp;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
