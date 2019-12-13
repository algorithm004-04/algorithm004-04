/**
 * LeetCode_8_034
 * 8. 字符串转换整数 (atoi)
 * @Author blackberry
 * @Date 2019/12/8 6:19 PM
 **/
public class LeetCode_8_034 {

    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int index = 0;
        int sign = 1;
        int total = 0;

        // 去除掉前面的空格
        while (index < str.length() && str.charAt(index) == ' ') {
            index ++;
        }

        // 全部都是空格
        if (index == str.length()) {
            return 0;
        }

        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index ++;
        }

        while (index < str.length()) {
            int digist = str.charAt(index) - '0';
            if (digist < 0 || digist > 9) {
                break;
            }

            // 处理y溢出
            if (Integer.MAX_VALUE / 10 < total || (Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE%10 < digist)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = total * 10 +digist;
            index ++;
        }

        return total * sign;
    }
}
