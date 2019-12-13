package week08;

public class LeetCode_115 {

	static int count = 0;

	public static int numDistinct(String s, String t) {
		findChar(s, 0, t, 0);
		return count;
	}

	/**
	 * 穷举剪枝
	 * 超时
	 * O(n! * m)
	 */
	public static void findChar(String str, int start, String sub, int index) {
		if (index >= sub.length()) {
			count++;
			return;
		}
		char target = sub.charAt(index);
		int pos = -1;
		for (int i = start; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == target) {
				pos = i;
				break;
			}
		}
		if (pos > -1) {
			findChar(str, pos + 1, sub, index + 1);
			findChar(str, pos + 1, sub, index);
		}
	}

	/**
	 * dp
	 * O(mn)
	 */
	public static int findDP(String str, String sub) {
		int[][] dp = new int[str.length() + 1][sub.length() + 1];
		for (int i = 0; i <= str.length(); i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i <= str.length(); i++) {
			for (int j = 1; j <= sub.length(); j++) {
				if (str.charAt(i - 1) == sub.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[str.length()][sub.length()];
	}

	public static void main(String[] args) {
		//700531452
		int result = findDP("adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc", "bcddceeeebecbc");
		System.out.println("result " + result);
	}
}
