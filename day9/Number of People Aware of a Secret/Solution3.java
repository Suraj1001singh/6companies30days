class Solution3 {
    int MOD = (int) 1e9 + 7;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int dp[][][] = new int[n + 1][delay + 1][forget + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= delay; j++) {
                for (int k = 1; k <= forget; k++) {
                    if (i == 1)
                        dp[i][j][k] = 1;
                    else if (k == 1)
                        dp[i][j][k] = 0;
                    else if (j == 1)
                        dp[i][j][k] = (dp[i - 1][j][k - 1] + dp[i - 1][delay][forget]) % MOD;
                    else
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] % MOD;
                }
            }
        }
        return dp[n][delay][forget];
    }
}