/**
 * LeetCode_190_034
 *
 * @Author blackberry
 * @Date 2019/12/1 10:45 AM
 **/
public class LeetCode_190_034 {

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i ++) {
            res <<= 1;
            res += n & 1;
            n >>= 1;
        }
        return res;
    }
}
