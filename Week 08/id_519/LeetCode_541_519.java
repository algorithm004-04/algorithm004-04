package algorithm.chapter8.template.string;

/**
 * 【541. 反转字符串 II】给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k
 * 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。 示例: 输入: s =
 * "abcdefg", k = 2 输出: "bacdfeg" 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class LeetCode_541_519 {

	public String reverseStr(String s, int k) {
		char[] a = s.toCharArray();
		for (int start = 0; start < a.length; start += 2 * k) {
			int i = start, j = Math.min(start + k - 1, a.length - 1);
			while (i < j) {
				char tmp = a[i];
				a[i++] = a[j];
				a[j--] = tmp;
			}
		}
		return new String(a);
	}

	public String reverseStr1(String s, int k) {
		if (null != s) {
			int len = s.length();
			int n = 0;
			boolean reverse = true;
			char[] arr = s.toCharArray();
			while (len - n * k >= 0) {
				int i = n * k;
				int j = (n + 1) * k - 1;
				j = j < len ? j : len - 1;
				while (i < j && reverse) {
					char temp = arr[j];
					arr[j--] = arr[i];
					arr[i++] = temp;
				}
				n++;
				reverse = !reverse;
			}
			return new String(arr);
		}
		return "";
	}

	public static void main(String[] args) {
		LeetCode_541_519 a = new LeetCode_541_519();
		String s = "abcd";
		int k = 8;
		System.out.println(a.reverseStr(s, k));
	}
}
