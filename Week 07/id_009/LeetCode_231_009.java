/**
 * https://leetcode-cn.com/problems/power-of-two/
 */
public class LeetCode_231_009 {
    public static void main(String[] args) {
        LeetCode_231_009 test = new LeetCode_231_009();
        System.out.println(test.isPowerOfTwo(1));
    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
