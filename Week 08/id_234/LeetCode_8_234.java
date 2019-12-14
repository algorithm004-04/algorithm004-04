package week_08;

public class LeetCode_8_234 {
  public int myAtoi(String str) {
    if (str.length() == 0) return 0;
    int index = 0;
    int sign = 1;
    int total = 0;
    // 找到第一个不是空格的字符
    while (str.charAt(index) == ' ' && index < str.length()) index++;
    // 找到正负号
    while (str.charAt(index) == '+' || str.charAt(index) == '-') {
      sign = str.charAt(index) == '+' ? 1 : -1;
      index++;
    }
    // 只考虑0-9
    while (index<str.length()&&( str.charAt(index) >= '0' || str.charAt(index) <= '9')) {
      total = total * 10 + str.charAt(index++) - '0';
      if (total >= Integer.MAX_VALUE) {
        if (sign == 1) {
          return Integer.MAX_VALUE;
        } else {
          return Integer.MIN_VALUE;
        }
      }
    }
    return sign*total;
  }
}
