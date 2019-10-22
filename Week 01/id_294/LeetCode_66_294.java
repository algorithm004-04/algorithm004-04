package week01;

public class LeetCode_66_294 {

    /**
     * 从最后向前遍历，如果值小于9，则该位+1，运算结束
     * 如果值等于9，则加1变为0，且需要进位，
     * 这里的进位就是继续循环就可以了
     * 特殊的地方是判断最后一位是否也进位了，是的话，说明位数溢出了，需要增加一位
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
            }
        }
        if (digits[0] == 0) {
            digits = new int[digits.length+1];
            digits[0] = 1;
        }
        return digits;
    }
}
