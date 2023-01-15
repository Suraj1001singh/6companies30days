
class Solution {
    int MOD = (int) 1e9 + 7;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long dp[] = new long[n + 1];// people that found secrete on ith day
        long share = 0; // people that can share on ith day
        long res = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = share = (share + dp[Math.max(i - delay, 0)] - dp[Math.max(i - forget, 0)] + MOD) % MOD;
        }
        for (int i = n - forget + 1; i <= n; i++)
            res = (res + dp[i]) % MOD;
        return (int) res;
    }
}
// Time complexity : O(n)