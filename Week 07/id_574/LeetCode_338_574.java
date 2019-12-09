package SuanFa.Week07;

import java.util.Arrays;

/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 *
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Neo
 */
public class LeetCode_338_574 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }
    private static int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; ++i)
            ans[i] = hammingWeight1(i);
        return ans;
    }

    private static int hammingWeight1(int n) {
        int counts = 0;
        while (n != 0) {
            counts ++;
            n &= (n-1);
        }
        return counts;
    }
}
