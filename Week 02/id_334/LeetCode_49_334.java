package Hash;

//Given an array of strings, group anagrams together.
//
// Example:
//
//
//Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//Output:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// Note:
//
//
// All inputs will be in lowercase.
// The order of your output does not matter.
//
// Related Topics Hash Table String

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_49_334 {

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> s = groupAnagramsV2(strs);
        System.out.println(s);
    }

    /**
     * Runtime: 16 ms, faster than 26.08% of Java online submissions for Group Anagrams.
     Memory Usage: 43.6 MB, less than 60.82% of Java online submissions for Group Anagrams.
     * O(nk) O(nk)
     */
    public  static List<List<String>> groupAnagramsV2(String[] strs) {

        Map<String, List<String>> map = new HashMap();
        for(String s : strs){
            int[] a = new int[26];
            for(char c : s.toCharArray()) a[c-'a']++;
            String key = Arrays.toString(a);
            if(!map.containsKey(key)) map.put(key, new LinkedList<String>());
            map.get(key).add(s);
        }

        return new ArrayList<List<String>>(map.values());
    }



    /**
     * Runtime: 9 ms, faster than 82.44% of Java online submissions for Group Anagrams.
     * Memory Usage: 45 MB, less than 39.18% of Java online submissions for Group Anagrams.
     * O(nlogn) O(nk)
     */
    public static List<List<String>> groupAnagramsV1(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            if (!hashMap.containsKey(key)) {
                hashMap.put(key, new ArrayList<String>());
            }
            hashMap.get(key).add(s);
        }
        return new ArrayList<List<String>>(hashMap.values());
    }


    /**
     * wrong -> 没有考虑内部含有重复元素的场景
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            int total = 0;
            for (int i = 0; i < arr.length; i++) {
                total += arr[i];
            }
            List<String> list = hashMap.get(String.valueOf(total));
            if (list == null) {
                list = new ArrayList<String>();
                hashMap.put(String.valueOf(total), list);
            }
            list.add(s);
        }
        return new ArrayList<List<String>>(hashMap.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)


