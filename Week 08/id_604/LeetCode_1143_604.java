class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        //如果传递进来的是空串，直接返回0，没有公共子串
        if(n == 0 || m == 0)
            return 0;

        char[] a = text1.toCharArray();
        char[] b = text2.toCharArray();

        int[][] maxlcs = new int[n][m];


        for( int j = 0; j < m; ++j ){
            if( a[0] == b[j] ) maxlcs[0][j] = 1;
            else if ( j != 0) maxlcs[0][j] = maxlcs[0][j-1];
            else maxlcs[0][j] = 0;
        }

        for( int i = 0; i < n; ++i ){
            if( a[i] == b[0]) maxlcs[i][0] = 1;
            else if (i != 0) maxlcs[i][0] = maxlcs[i-1][0];
            else maxlcs[i][0] = 0;
         }

        //根据状态转移方程进行递推
        for( int i = 1; i < n; ++i ){
            for(int j = 1; j < m; ++j){
                if( a[i] == b[j])
                    maxlcs[i][j] = maxlcs[i-1][j-1] + 1;
                else

                    maxlcs[i][j] = Math.max(maxlcs[i-1][j],maxlcs[i][j-1]);
            }

        }

        return maxlcs[n-1][m-1];
    }
}
