package week08;

public class LeetCode_1143 {

	//最长公共子序列
	public static int commonSubSequence(String str, String sub) {
		int[][] dp = new int[str.length() + 1][sub.length() + 1];
		int strLen = str.length();
		int subLen = sub.length();
		char[] strArr = str.toCharArray();
		char[] subArr = sub.toCharArray();
		for (int i = 1; i <= strLen; i++) {
			for (int j = 1; j <= subLen; j++) {
				if (strArr[i - 1] == subArr[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[str.length()][sub.length()];
	}

	//最长公共子串
	public static int commonSubString(String str, String sub) {
		int[][] dp = new int[str.length() + 1][sub.length() + 1];
		int max = 0;
		for (int i = 1; i <= str.length(); i++) {
			for (int j = 1; j <= sub.length(); j++) {
				if (str.charAt(i - 1) == sub.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = 0;
				}
				max = Math.max(max, dp[i][j]);
			}
		}
		return max;
	}


	public static void main(String[] args) {
		int ret = commonSubString("ababacdefc", "abc");
		System.out.println("ret " + ret);
	}
}
