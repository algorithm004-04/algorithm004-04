/**
 * PlusOne 66
 * https://leetcode-cn.com/problems/plus-one/submissions/
 * @Author blackberry
 * @Date 2019/10/19 4:53 PM
 **/
public class PlusOne {

    /**
     * 自己最初想到的解法 第一个元素加1 如果有进位则 相加进一位
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int carry = 0;
        for (int i = len - 1; i >=0 ; i --) {
            int temp;
            if (i == len - 1) {
                temp = carry + digits[i] + 1;
            } else {
                temp = carry + digits[i];
            }

            digits[i] = temp %10;
            carry = temp / 10;
        }
        if (carry == 1) {
            int[] newArr = new int[len + 1];
            System.arraycopy(digits, 0, newArr, 1, len);
            newArr[0] =1;
            return newArr;
        }
        return digits;
    }

    /**
     * 看了题解之后
     * 当前数加1之后 如果不是10  就直接返回就好了
     * 最高加1之后如果是个10 则新建一个数组 长度是原数组长度 + 1 最高位为1 其他位 全部为0
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = 0; i < len; i ++) {
            digits[i] = ++digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }

}
