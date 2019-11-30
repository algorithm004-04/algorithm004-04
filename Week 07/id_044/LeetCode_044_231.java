package week_07.lesson16;

public class PowerOfTwo {

    /**
     * 若 n = 2^x 且 x 为自然数（即 n 为 2 的幂）,则一定满足以下条件：
     * 1.恒有 n & (n - 1) == 0,这是因为：
     *      n 二进制最高位为1，其余所有位为0；
     *      2^0     --> 0001
     *      2^1     --> 0010
     *      2^2     --> 0100
     *      2^3     --> 1000
     *      n - 1 二进制最高位为0，其余所有位为1；
     * 2.一定满足 n > 0
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {

    }

}
