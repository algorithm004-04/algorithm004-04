/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 来源：https://leetcode-cn.com/problems/plus-one
 *
 * @author liqiuying
 * @date 2019-10-20
 */
public class LeetCode_66_429 {
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += 1;
            //不需要进位直接返回
            if (digits[i] <= 9) {
                return digits;
            }
            //需要进一位
            digits[i] = digits[i] % 10;
        }
        //能到这里，数组整个全部进了1.如99 -> 100
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    public static void main(String[] args) {
        int[] nums = {8, 9, 9, 9};
        int[] plusOne = plusOne(nums);
        for (int info : plusOne) {
            System.out.print(info);
        }
    }
}

