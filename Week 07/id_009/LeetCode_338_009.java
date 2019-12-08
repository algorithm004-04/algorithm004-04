import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/counting-bits/description/
 */
public class LeetCode_338_009 {
    public static void main(String[] args) {
        LeetCode_338_009 test = new LeetCode_338_009();
        System.out.println(Arrays.toString(test.countBits(2)));
    }

    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i < num + 1; i++) {
            if (i < 3) {
                result[i] = 1;
            } else {
                if ((i & 1) == 1) {
                    result[i] = result[i - 1] + 1;
                } else {
                    result[i] = result[i >> 1];
                }
            }
        }
        return result;
    }
}

