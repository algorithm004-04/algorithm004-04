//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //方法1：字符串转字符数组，排序后比较是否相同
    //排序时间复杂度O(nlogn),空间复杂度O(n)
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.equals(sArr, tArr);
    }

    //方法2：哈希表统计每个字母出现的次数
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        //构建一个统计26字母次数的数组，每个元素表示每个字母出现的次数
        int[] counter = new int[26];
        //s和t的length相同，遍历同时遍历s和t
        for (int i = 0; i < s.length(); i++) {
            //先得到26个字母在字符串s中的下标,对应数组元素+1,然后在t中找到下标，对应数组元素-1;
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int j = 0; j<counter.length; j++) {
            if (counter[j] != 0) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
