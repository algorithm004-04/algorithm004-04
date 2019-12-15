/**
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class LeetCode_8_009 {
    public static void main(String[] args) {
        LeetCode_8_009 test = new LeetCode_8_009();
        System.out.println(test.myAtoi("4193 with words"));
    }

    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int idx = 0;
        boolean isZheng = true;
        if (str.charAt(idx) == '-') {
            isZheng = false;
        }
        if (str.charAt(idx) == '+' || str.charAt(idx) == '-') {
            idx++;
            str = str.substring(idx);
        }
        if (str.length() == 0) {
            return 0;
        }
        Long res = 0L;
        for (int i = 0; i < str.length(); i++) {
            String s = "" + str.charAt(i);
            if ("0123456789".contains(s)) {
                res = res * 10 + Long.parseLong(s);
                if (isZheng && res >= max) {
                    return max;
                }
                if (!isZheng && -res <= min) {
                    return min;
                }

            } else {
                break;
            }
        }
        return isZheng ? res.intValue() : -res.intValue();
    }
}

