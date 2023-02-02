//---------TABULATION SOLUTION

class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double dp[] = new double[k + 1];
        for (int currPts = k; currPts >= 0; currPts--) {
            double prob = 0;
            for (int i = 1; i <= Math.min(maxPts, n - currPts); i++) {
                double currProb = (1.0 / maxPts);
                if (currPts + i < k)
                    currProb *= dp[currPts + i];
                prob += currProb;
            }
            dp[currPts] = prob;
        }
        return dp[0];
    }
}
// Time complexity : O(k*maxPts)