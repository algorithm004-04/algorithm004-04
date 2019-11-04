package algorithm.chapter3.first.greedy;

import java.util.Arrays;

/**
 * 【455. 分发饼干】 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi
 * ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i
 * ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。 注意： 你可以假设胃口值为正。 一个小朋友最多只能拥有一块饼干。
 * 示例 1: 输入: [1,2,3], [1,1] 输出: 1 解释: 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。 所以你应该输出1。 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/assign-cookies
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class LeetCode_455_519 {
	// g 胃口值 s尺寸
	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int i = 0;
		int j = 0;
		int num = 0;
		while (i < g.length && j < s.length) {
			if (g[i] > s[j]) {
				j++;
			} else {
				i++;
				j++;
				num++;
			}
		}
		return num;
	}

	public static void main(String[] args) {
		LeetCode_455_519 a = new LeetCode_455_519();
		int[] g = new int[] { 1, 2, 3 };
		int[] s = new int[] { 1, 1 };
		System.out.println(a.findContentChildren(g, s));
	}
}