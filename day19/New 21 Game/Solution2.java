import java.util.*;
//---------MEMOIZATION SOLUTION

class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double dp[] = new double[k];
        Arrays.fill(dp, -1);
        return f(n, k, 0, maxPts, dp);
    }

    public double f(int n, int k, int currPts, int maxPts, double[] dp) {
        if (currPts >= k)
            return 1;
        if (dp[currPts] != -1)
            return dp[currPts];
        double prob = 0;
        for (int i = 1; i <= Math.min(maxPts, n - currPts); i++) {
            double currProb = (1.0 / maxPts) * f(n, k, currPts + i, maxPts, dp);
            prob += currProb;
        }
        return dp[currPts] = prob;
    }
}
// Time complexity : O(k)