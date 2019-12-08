//暴力
class Solution {
    private int ans;
    private int n, m;
    private void dfs(int[] nums, int i, int cntSubarrays, int curSum, int curMax) {
        if (i == n && cntSubarrays == m) {
            ans = Math.min(ans, curMax);
            return;
        }
        if (i == n) {
            return;
        }
        if (i > 0) {
            dfs(nums, i + 1, cntSubarrays, curSum + nums[i], Math.max(curMax, curSum + nums[i]));
        }
        if (cntSubarrays < m) {
            dfs(nums, i + 1, cntSubarrays + 1, nums[i], Math.max(curMax, nums[i]));
        }
    }
    public int splitArray(int[] nums, int M) {
        ans = Integer.MAX_VALUE;
        n = nums.length;
        m = M;
        dfs(nums, 0, 0, 0, 0);
        return ans;
    }
}
// 动态规划
class Solution {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] f = new int[n + 1][m + 1];
        int[] sub = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }
        f[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k < i; k++) {
                    f[i][j] = Math.min(f[i][j], Math.max(f[k][j - 1], sub[i] - sub[k]));
                }
            }
        }
        return f[n][m];        
    }
}

class Solution {
	public int splitArray(int[] nums, int m)
	{
		int L = nums.length;
		int[] S = new int[L+1];
		S[0]=0;
		for(int i=0; i<L; i++)
			S[i+1] = S[i]+nums[i];

		int[] dp = new int[L];
		for(int i=0; i<L; i++)
			dp[i] = S[L]-S[i];

		for(int s=1; s<m; s++)
		{
			for(int i=0; i<L-s; i++)
			{
				dp[i]=Integer.MAX_VALUE;
				for(int j=i+1; j<=L-s; j++)
				{
					int t = Math.max(dp[j], S[j]-S[i]);
					if(t<=dp[i])
						dp[i]=t;
					else
						break;
				}
			}
		}

		return dp[0];
	}
}