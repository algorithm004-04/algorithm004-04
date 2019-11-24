int min(int a,int b) {
    if (a < b) {
        return a;
    }
    return b;
}

int minDistance(char *word1, char *word2)
{
	int x = strlen(word1);
	int y = strlen(word2);

	int dp[x+1][y+1];

	for (int i = 0; i <= x; i++)
	{
		for (int j = 0; j <= y; j++)
		{
			if (i == 0)
				dp[i][j] = j;
			else if (j == 0)
				dp[i][j] = i;
			else if (word1[i-1] == word2[j-1])
				dp[i][j] = dp[i-1][j-1];
			else
				dp[i][j] = 1 + min(min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
		}
	}

	return dp[x][y];
}
