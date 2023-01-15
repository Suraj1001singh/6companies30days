
import java.util.*;
//--------------MEMOIZATION 

class Solution {
    int dirs[][];

    public int calculateMinimumHP(int[][] dungeon) {
        dirs = new int[][] { { 1, 0 }, { 0, 1 } };
        int m = dungeon.length;
        int n = dungeon[0].length;
        int dp[][] = new int[m][n];
        for (int r[] : dp)
            Arrays.fill(r, -1);
        return f(0, 0, dungeon, n, m, dp) + 1;
    }

    int f(int i, int j, int[][] mat, int n, int m, int[][] dp) {
        int mini = Integer.MAX_VALUE;
        if (dp[i][j] != -1)
            return dp[i][j];
        for (int dir[] : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x >= 0 && x < m && y >= 0 && y < n) {
                int health = f(x, y, mat, n, m, dp);
                mini = Math.min(mini, health);
            }
        }
        if (mini == Integer.MAX_VALUE)
            mini = 0;
        int required = mat[i][j] - mini;
        if (required <= 0)
            return dp[i][j] = -1 * required;
        else
            return dp[i][j] = 0;
    }
}
// Time complexity : O(m*n)