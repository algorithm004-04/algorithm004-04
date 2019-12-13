package algorithm.chapter8.first.string;

/**
 * 【8. 字符串转换整数 (atoi)】请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class LeetCode_8_519 {
	public int myAtoi(String str) {
		int result = 0;
		int flag = 1;
		if (null != str && str.length() > 0) {
			char[] arr = str.toCharArray();
			int loc = 0;
			while (loc < arr.length && arr[loc] == ' ') {
				loc++;
			}
			if (loc < arr.length && (arr[loc] == '-' || arr[loc] == '+')) {
				if (arr[loc] == '-') {
					flag = -1;
				}
				loc++;
			}
			for (int i = loc; i < arr.length; i++) {
				int a = arr[i] - '0';
				if (a >= 0 && a <= 9) {
					if (flag > 0 && result > Integer.MAX_VALUE / 10) {
						return Integer.MAX_VALUE;
					}
					if (flag > 0 && result == Integer.MAX_VALUE / 10) {
						if (a > Integer.MAX_VALUE % 10) {
							return Integer.MAX_VALUE;
						}
					}
					if (flag < 0 && -result < Integer.MIN_VALUE / 10)
						return Integer.MIN_VALUE;
					if (flag < 0 && -result == Integer.MIN_VALUE / 10) {
						if (a > Integer.MIN_VALUE % 10) {
							return Integer.MIN_VALUE;
						}
					}
					result = result * 10 + a;
				} else {
					break;
				}
			}
		}
		return result * flag;
	}

	public static void main(String[] args) {
		LeetCode_8_519 a = new LeetCode_8_519();
		String str = "-2147483649";
		System.out.println(a.myAtoi(str));
	}

	public int myAtoi1(String str) {
		if (str == null)
			return 0;
		str = str.trim();
		if (str.length() == 0)
			return 0;
		int i = 0;
		// 2.判断数字的符号
		int flag = 1;
		char ch = str.charAt(i);
		if (ch == '+') {
			i++;
		} else if (ch == '-') {
			flag = -1;
			i++;
		}
		// 3.找出数字部分
		int res = 0;
		for (; i < str.length(); i++) {
			ch = str.charAt(i);
			if (ch < '0' || ch > '9')
				break;
			// 溢出判断
			if (flag > 0 && res > Integer.MAX_VALUE / 10)
				return Integer.MAX_VALUE;
			if (flag > 0 && res == Integer.MAX_VALUE / 10 && ch - '0' > Integer.MAX_VALUE % 10)
				return Integer.MAX_VALUE;
			if (flag < 0 && -res < Integer.MIN_VALUE / 10)
				return Integer.MIN_VALUE;
			if (flag < 0 && -res == Integer.MIN_VALUE / 10 && -(ch - '0') < Integer.MIN_VALUE % 10)
				return Integer.MIN_VALUE;
			res = res * 10 + ch - '0';
		}
		return res * flag;
	}
}
