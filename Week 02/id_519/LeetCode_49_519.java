package algorithm.chapter2.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 * ��49��ĸ��λ�ʷ��顿����һ���ַ������飬����ĸ��λ�������һ����ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ����� ʾ��: ����: ["eat", "tea",
 * "tan", "ate", "nat", "bat"], ���: [ ["ate","eat","tea"], ["nat","tan"],
 * ["bat"] ] ���ӣ�https://leetcode-cn.com/problems/group-anagrams
 * 
 * @author chying
 *
 */
public class LeetCode_49_519 {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<>();
		HashMap<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] c = str.toCharArray();
			Arrays.sort(c);
			String key = Arrays.toString(c);
			if (map.containsKey(key)) {
				map.get(key).add(str);
			} else {
				List<String> strList = new ArrayList<>();
				strList.add(str);
				map.put(key, strList);
			}
		}
		for (Entry<String, List<String>> list : map.entrySet()) {
			result.add(list.getValue());
		}
		return result;
	}

	public List<List<String>> groupAnagrams2(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			String key = getKey(str);
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<>());
			}
			map.get(key).add(str);
		}

		return new ArrayList<List<String>>(map.values());
	}

	private String getKey(String str) {
		char[] arr = str.toCharArray();
		int[] num = new int[26];
		for (char c : arr) {
			num[c - 'a'] = num[c - 'a'] + 1;
		}
		return Arrays.toString(num);
	}

	public static void main(String[] args) {
		LeetCode_49_519 a = new LeetCode_49_519();
		String[] strs = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> result = a.groupAnagrams2(strs);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}

	}
}
