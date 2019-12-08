/**
 * LeetCode_231_034
 *
 * @Author blackberry
 * @Date 2019/12/1 10:39 AM
 **/
public class LeetCode_231_034 {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }
}
