import java.util.Arrays;

//--------- OPTIMZATION OVER TABULATION SOLUTION

class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double dp[] = new double[k + 1];
        Arrays.fill(dp, 1);
        double sum[] = new double[k + maxPts + 1];
        sum[k + maxPts] = 1;
        for (int i = k + maxPts - 1; i >= 0; i--)
            sum[i] = sum[i + 1] + 1;

        for (int currPts = k - 1; currPts >= 0; currPts--) {
            double prob = sum[currPts + 1] - sum[currPts + Math.min(maxPts, n - currPts) + 1];
            double currProb = (1.0 / maxPts);
            prob *= currProb;
            dp[currPts] = prob;
            sum[currPts] = sum[currPts + 1] + dp[currPts];
        }
        return dp[0];
    }
}
// Time complexity : O(k + maxPts)