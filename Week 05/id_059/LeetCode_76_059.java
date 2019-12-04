//给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
//输入: S = "ADOBECODEBANC", T = "ABC"
//输出: "BANC"

class Solution {
    public String minWindow(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int[]hash = new int[256];
        int minlength = s.length();
        String results = "";
        for(char smallt:tt)
        {
            hash[smallt-'0']++;
        }
        int left = 0;
        int right = 0;
        int count = tt.length;
        for(;right<ss.length;right++)
        {
            hash[ss[right]-'0']--;
            if(hash[ss[right]-'0']>=0)
            {
                count--;
            }
            while(left<right&&hash[ss[left]-'0']<0)
            {
                hash[ss[left]-'0']++;
                left++;
            }
            if(count==0&&minlength>=right-left+1)
            {
                minlength = right-left+1;
                results = s.substring(left,right+1);
            }
        }
        return results;

    }
}