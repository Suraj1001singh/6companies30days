
//---------------RECURSIVE APPROACH (Getting TLE)
//IDEA : from each subtree find minimum health to be need to reach their
//      if required health if -ve means we have to make is  postive
//      if its +ve means no need of health health need is 0

class Solution {
    int dirs[][];

    public int calculateMinimumHP(int[][] dungeon) {
        dirs = new int[][] { { 1, 0 }, { 0, 1 } };
        int m = dungeon.length;
        int n = dungeon[0].length;
        return f(0, 0, dungeon, n, m) + 1;
    }

    int f(int i, int j, int[][] mat, int n, int m) {
        int mini = Integer.MAX_VALUE;
        for (int dir[] : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x >= 0 && x < m && y >= 0 && y < n) {
                int health = f(x, y, mat, n, m);
                mini = Math.min(mini, health);
            }
        }
        if (mini == Integer.MAX_VALUE)
            mini = 0;
        int required = mat[i][j] - mini;
        if (required <= 0)
            return -1 * required;
        else
            return 0;
    }
}
// Time complexity :exponential