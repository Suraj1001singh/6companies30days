import java.util.Arrays;

//-------------MEMOIZATION SOLUTION (Getting MLE)
class Solution2 {
    public int numMatchingSubseq(String s, String[] words) {
        int res = 0;
        for (String t : words) {
            int dp[][] = new int[s.length()][t.length()];
            for (int r[] : dp)
                Arrays.fill(r, -1);
            if (f(s, t, 0, 0, dp))
                res++;
        }
        return res;
    }

    boolean f(String s, String t, int i, int j, int dp[][]) {
        int n = s.length(), m = t.length();
        if (j == m)
            return true;
        if (i == n)
            return j >= m;
        if (dp[i][j] != -1)
            return dp[i][j] == 1;
        if (s.charAt(i) == t.charAt(j)) {
            if (f(s, t, i + 1, j + 1, dp) || f(s, t, i + 1, j, dp))
                dp[i][j] = 1;
            else
                dp[i][j] = 0;

            return dp[i][j] == 1;
        }
        if (f(s, t, i + 1, j, dp))
            dp[i][j] = 1;
        else
            dp[i][j] = 0;
        return dp[i][j] == 1;
    }
}
// Time complexity : O(n^2)
//give TLE