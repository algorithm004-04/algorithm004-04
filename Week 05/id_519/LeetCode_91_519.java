package algorithm.chapter4.first.homework;

/**
 * 【91. 解码方法】一条包含字母 A-Z 的消息通过以下方式进行了编码： 'A' -> 1 'B' -> 2 ... 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class LeetCode_91_519 {
	// 拆成1位 或者2位，2位数 不能大于26，剪枝;有点类似上楼梯
	public int numDecodings(String s1) {
		char[] s = s1.toCharArray();
		if (s[0] == '0')
			return 0;
		int pre = 1, curr = 1;
		for (int i = 1; i < s.length; i++) {
			int tmp = curr;
			if (s[i] == '0')
				if (s[i - 1] == '1' || s[i - 1] == '2')
					curr = pre;
				else
					return 0;
			else if (s[i - 1] == '1' || (s[i - 1] == '2' && s[i] >= '1' && s[i] <= '6'))
				curr = curr + pre;
			pre = tmp;
		}
		return curr;
	}

	public static void main(String[] args) {
		LeetCode_91_519 a = new LeetCode_91_519();
		String s = "12";
		System.out.println(a.numDecodings(s));
	}
}
