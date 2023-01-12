import java.util.Arrays;

//-------MEMOIZATION

class Solution2 {
    int glb_delay;
    int glb_forget;
    int MOD = (int) 1e9 + 7;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        glb_delay = delay;
        glb_forget = forget;
        int dp[][][] = new int[n + 1][delay + 1][forget + 1];
        for (int a[][] : dp) {
            for (int b[] : a) {
                Arrays.fill(b, -1);
            }
        }
        return f(n, delay, forget, dp);

    }

    int f(int n, int delay, int forget, int[][][] dp) {
        if (n == 1)
            return 1;
        if (forget == 1)
            return 0;
        if (dp[n][delay][forget] != -1)
            return dp[n][delay][forget];
        if (delay == 1)
            return dp[n][delay][forget] = (f(n - 1, 1, forget - 1, dp) + f(n - 1, glb_delay, glb_forget, dp)) % MOD;
        return dp[n][delay][forget] = f(n - 1, delay - 1, forget - 1, dp) % MOD;
    }
}