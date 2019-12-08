class Solution {
 public int numDecodings(String str){
        int len = str.length();
        if(len == 0 || (len == 1 && str.charAt(0) == '0')) return 0;
        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 0; i < len;i++){
            int temp = 0;
            if(str.charAt(i) != '0') temp += dp[1];
            if(i > 0 && (str.charAt(i-1) == '1' || (str.charAt(i-1) == '2' && str.charAt(i) <= '6')))
                temp += dp[0];
            dp[0] = dp[1];
            dp[1] = temp;
        }
        
        return dp[1];
    }
}
