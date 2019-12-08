package algorithm.chapter2.second;

import java.util.ArrayList;
import java.util.List;

/**
 * 【22 括号生成】给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。 例如，给出 n = 3，生成结果为： [
 * "((()))", "(()())", "(())()", "()(())", "()()()" ] 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 
 * @author chying
 *
 */
public class LeetCode_22_519 {
	// 分治
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		generateParenthesis(result, 0, 0, n, "");
		return result;
	}

	private void generateParenthesis(List<String> result, int left, int right, int n, String parenthesis) {
		if (left == n && right == n) {
			result.add(parenthesis);
			return;
		}
		if (left < n) {
			generateParenthesis(result, left + 1, right, n, parenthesis + "(");
		}
		if (right < left) {
			generateParenthesis(result, left, right + 1, n, parenthesis + ")");
		}

	}

	public static void main(String[] args) {
		LeetCode_22_519 a = new LeetCode_22_519();

		System.out.println(a.generateParenthesis(2));
	}
}
