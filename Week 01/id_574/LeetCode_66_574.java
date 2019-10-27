package SuanFa;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 *
 *
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Neo
 */

public class LeetCode_66_574 {
    public static void main(String[] args) {
        int nums[] = {1,2,3,4};
        System.out.println(Arrays.toString(plusone1(nums)));


    }

    private static int[] plusone1(int[] digits) {
        for (int i=digits.length-1; i>=0;i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int [digits.length +1];
        digits[0] =1;
        return digits;
    }

    private static int[] plusone(int[] digits) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<digits.length; i++) {
            sb.append(digits[i]);
        }
        int temp = Integer.valueOf(sb.toString()) + 1;
        String str = String.valueOf(temp);
        String  result[] = str.split("");
        int [] a = new int[result.length];
        for (int i=0;i<result.length;i++) {
            a[i] = Integer.valueOf(result[i]);
        }
        return a;
    }
}
