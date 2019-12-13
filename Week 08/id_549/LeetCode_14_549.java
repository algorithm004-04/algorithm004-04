//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
// 示例 1:
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
//
//
// 示例 2:
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
//
//
// 说明:
//
// 所有输入只包含小写字母 a-z 。
// Related Topics 字符串
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        String prefix = solution.longestCommonPrefix(new String[]{"ab", "abc", "abcd","a"});
        System.out.println(prefix);
    }



    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {

            if(strs.length == 0) {
                return "";
            }

            int minLength = Integer.MAX_VALUE;
            for (String str : strs) {
                if(minLength > str.length()) {
                    minLength = str.length();
                }
            }

            StringBuilder sb = new StringBuilder();

            for(int i=0;i <minLength;i++) {
                for(int j=1;j < strs.length;j++) {
                    if(strs[0].charAt(i) != strs[j].charAt(i)) {
                        return sb.toString();
                    }
                }
                sb.append(strs[0].charAt(i));
            }

            return sb.toString();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
