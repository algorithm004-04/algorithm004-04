/**
 * https://leetcode-cn.com/problems/number-of-1-bits/
 */
public class LeetCode_191_009 {
    public static void main(String[] args) {
        LeetCode_191_009 test = new LeetCode_191_009();
        System.out.println(test.hammingWeight(00000000000000000000000000001011));
    }

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
