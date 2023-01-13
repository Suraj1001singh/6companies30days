import java.util.Arrays;

//--------------MEMOIZATION SOLUTION

class Solution2 {
    int dirs[][] = { { -1, 2 }, { 1, 2 }, { -1, -2 }, { 1, -2 }, { -2, 1 }, { -2, -1 }, { 2, 1 }, { 2, -1 } };

    public double knightProbability(int n, int k, int row, int col) {
        double dp[][][] = new double[k + 1][n][n];
        for (double a[][] : dp) {
            for (double b[] : a)
                Arrays.fill(b, -1);
        }
        return f(k, row, col, n, dp);

    }

    double f(int k, int i, int j, int n, double dp[][][]) {
        if (k == 0) {
            if (i >= 0 && i < n && j >= 0 && j < n)
                return 1;
            else
                return 0;
        }
        if (dp[k][i][j] != -1)
            return dp[k][i][j];
        double prob = 0;
        for (int dir[] : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            // if point is inside then only consider it, for furthur prob calculation
            if (x >= 0 && x < n && y >= 0 && y < n)
                prob += 0.125 * f(k - 1, x, y, n, dp);
        }
        return dp[k][i][j] = prob;
    }
}
// Time complexity : O(k*n*n)