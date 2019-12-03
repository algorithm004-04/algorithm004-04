package week07;

public class LeetCode_338 {


	/**
	 * 复用计算一个数1的位数的算法
	 */
	public static int[] countBits(int num) {
		int[] arr = new int[num + 1];
		for (int i = 0; i <= num; i++) {
			arr[i] = bits(i);
		}
		return arr;
	}

	public static int bits(int num) {
		int count = 0;
		while (num != 0) {
			num = num & (num - 1);
			count++;
		}
		return count;
	}

	/**
	 * 利用奇偶数1的个数的关系进行递推
	 * 奇数比小于1的偶数1个数多1
	 * 偶数count[x] = count[x/2]
	 */
	public static int[] countBits2(int num) {
		int[] count = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			count[i] = (i & 1) == 0 ? count[i >> 1] : count[i - 1] + 1;
		}
		return count;
	}


	/**
	 * dp
	 * dp[i] = dp[i & (i-1)] + 1
	 * 跟方法2类似，只是不再需要判断奇偶性，直接通过 x&(x-1)得到少一个1的数，
	 * 直接取它的计算结果加1，就得到当前数1的个数
	 */
	public static int[] countBits3(int num) {
		int[] dp = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			dp[i] = dp[i & (i - 1)] + 1;
		}
		return dp;
	}

	public static void main(String[] args) {

	}
}
