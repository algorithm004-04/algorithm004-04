//LeetCode　72题编辑距离
class Solution {
    public int minDistance(String word1, String word2){
        int n = word1.length();
        int m = word2.length();

        //处理为空串的情况
        if( n == 0 && m == 0 )
            return 0;

        if(n == 0 && m != 0)
            return word2.length();

        if(n != 0 && m == 0)
            return word1.length();


        int[][] minDist = new int [n][m];

        for(int j = 0; j < m; ++j){
            if( word1.charAt(0)== word2.charAt(j) ) minDist[0][j] = j;
            else if ( j != 0) minDist[0][j] = minDist[0][j-1]+1;
            else  minDist[0][j] = 1;
        }

        for(int i = 0; i < n; ++i){
            if( word1.charAt(i) == word2.charAt(0) ) minDist[i][0] = i;
            else if (i != 0) minDist[i][0] = minDist[i-1][0]+1;
            else minDist[i][0] = 1;
        }

        for( int i = 1; i < n; ++i ){
            for( int j = 1; j <  m; ++j ){
                if(word1.charAt(i) == word2.charAt(j)) {
                    minDist[i][j] = min(minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1]);
                }
                else {
                    minDist[i][j] = min(minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1] + 1);
                }
            }
        }

        return minDist[n-1][m-1];

    }

    private int min(int x, int y, int z){
        int minv = Integer.MAX_VALUE;
        if( x < minv ) minv = x;
        if( y < minv)  minv = y;
        if (z < minv)  minv = z;

        return minv;
    }

    public static void main(String[] args){
        String word1 = "intention";
        String word2 = "execution";


       int ret = new Solution().misDistance(word1,word2);
       System.out.println(ret);
    }

}
