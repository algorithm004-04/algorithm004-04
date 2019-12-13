package algorithm.chapter8.first.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 【387. 字符串中的第一个唯一字符】给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 案例: s =
 * "leetcode" 返回 0. s = "loveleetcode", 返回 2. 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class LeetCode_387_519 {

	public int firstUniqChar(String s) {
		if (s == null || s.length() == 0)
			return -1;
		int slow = 0, fast = 0;
		char[] chs = s.toCharArray();
		int[] count = new int[26];
		int n = chs.length;
		while (fast < n) {
			count[chs[fast] - 'a']++;
			while (slow < n && count[chs[slow] - 'a'] > 1) {
				slow++;
			}
			if (slow == n)
				return -1;
			fast++;
		}
		return slow;
	}

	public int firstUniqChar_slowAndFast(String s) {
		if (s == null || s.length() == 0)
			return -1;
		int slow = 0, fast = 0;
		char[] arr = s.toCharArray();
		int[] count = new int[26];
		while (fast < arr.length) {
			count[arr[fast] - 'a']++;
			while (slow < arr.length && count[arr[slow] - 'a'] > 1) {
				slow++;
			}
			if (slow == arr.length) {
				return -1;
			}
			fast++;
		}
		return slow;
	}

	public int firstUniqChar_slowAndFast1(String s) {
		if (null != s) {
			char[] arr = s.toCharArray();
			int i = 0;
			int j = 0;
			int len = arr.length;
			int[] count = new int[26];
			while (j < len) {
				count[arr[j] - 'a']++;
				while (i < arr.length && count[arr[i] - 'a'] > 1) {
					i++;
				}
				if (i == arr.length) {
					return -1;
				}
				j++;
			}
			return i;
		}
		return -1;
	}

	public int firstUniqChar2(String s) {
		if (null != s) {
			char[] arr = s.toCharArray();
			Set<Character> set = new HashSet<>();
			for (int i = 0; i < arr.length; i++) {
				int loc = s.lastIndexOf(arr[i]);
				if (set.add(arr[i]) && i == loc) {
					return i;
				}
			}
		}
		return -1;
	}

	public int firstUniqChar1(String s) {
		int freq[] = new int[26];
		for (int i = 0; i < s.length(); i++)
			freq[s.charAt(i) - 'a']++;
		for (int i = 0; i < s.length(); i++)
			if (freq[s.charAt(i) - 'a'] == 1)
				return i;
		return -1;
	}

	public static void main(String[] args) {
		LeetCode_387_519 a = new LeetCode_387_519();
		String s = "lleetcode";
		System.out.println(a.firstUniqChar(s));
	}
}
