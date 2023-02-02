class Solution {
    int[][] dirs = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        boolean seen[][] = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!seen[i][j] && grid[i][j] == 1) {
                    seen[i][j] = true;
                    ans = Math.max(ans, dfs(i, j, grid, seen));
                }

            }
        }
        return ans;
    }

    int dfs(int i, int j, int[][] grid, boolean seen[][]) {
        int n = grid.length;
        int m = grid[0].length;
        int sum = 1;
        for (int dir[] : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < n && y >= 0 && y < m && !seen[x][y] && grid[x][y] == 1) {
                seen[x][y] = true;
                sum += dfs(x, y, grid, seen);
            }
        }
        return sum;
    }
}
// Time complexity : O(n*m)