//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
//
//具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。

//示例 1:
//输入: "abc"
//输出: 3
//解释: 三个回文子串: "a", "b", "c".




class Solution {
    public int countSubstrings(String s) {
        int length = s.length();
        if (length < 1) return length;
        boolean[][] dp = new boolean[length][length];
        int i ,j;
        int row,column;
        boolean current;
        int count = 0;
        for (i = 0; i < length; i++) {
            dp[i][i] = true;
            count++;
        }
        for (i = 1; i < length;i++){
            for (j = 0; j <= length - i -1;j++) {
                row = j;
                column = i + j;
                current = s.charAt(row) == s.charAt(column);
                if(current && (i == 1 || dp[row + 1][column - 1])){
                    dp[row][column] = true;
                    count++;
                }


            }
        }
        return count;

    }

}
