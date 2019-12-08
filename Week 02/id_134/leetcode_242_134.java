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



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        //哈希表法
        //用长度为26的数组记录字母出现次数
        //时间复杂度：O(n)，空间复杂度：O(1)
        if (s.length() != t.length()) {
            return false;
        }
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i ++) {
            nums[s.charAt(i) - 'a'] ++;
            nums[t.charAt(i) - 'a'] --;
        }
        for (int num : nums) {
            if (num != 0) {
                return false;
            }
        }
        return true;


        //哈希表法
        //统计s字符串中每个字母出现次数，以字母为key，出现次数为value放入map中
        //t中出现字母若在map中，value-1；
        //时间复杂度：O(n)，空间复杂度：O(k),k为字符串的长度
        //
        /*Map<Character,Integer> map = new HashMap<Character,Integer>();
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i ++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i),0);
            }
            map.put(s.charAt(i),map.get(s.charAt(i)) + 1);
        }
        for (int i = 0; i < t.length(); i ++) {
            if (!map.containsKey(t.charAt(i))) {
                return false;
            }
             map.put(t.charAt(i),map.get(t.charAt(i)) - 1);
                if (map.get(t.charAt(i)) < 0) {
                    return false;
                }
        }
        return true;*/


        //排序法
        //先通过Array.sort将字符串排序，再判断是否相等
        //时间复杂度：O(nlogn)，空间复杂度：O(1)
        /*空间复杂度取决于排序实现，如果使用 heapsort，通常需要 O(1)辅助空间。
        注意，在 Java 中，toCharArray() 制作了一个字符串的拷贝，所以它花费 O(n)额外的空间，
        但是我们忽略了这一复杂性分析，因为：
        这依赖于语言的细节。
        这取决于函数的设计方式。例如，可以将函数参数类型更改为 char[]。*/


       /* if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1,str2);*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)
