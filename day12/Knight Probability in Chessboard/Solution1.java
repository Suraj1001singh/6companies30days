
//--------------RECURSIVE SOLUTION

class Solution {
    int dirs[][] = { { -1, 2 }, { 1, 2 }, { -1, -2 }, { 1, -2 }, { -2, 1 }, { -2, -1 }, { 2, 1 }, { 2, -1 } };

    public double knightProbability(int n, int k, int row, int col) {
        return f(k, row, col, n);

    }

    double f(int k, int i, int j, int n) {
        if (k == 0) {
            if (i >= 0 && i < n && j >= 0 && j < n)
                return 1;
            else
                return 0;
        }
        double prob = 0;
        for (int dir[] : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            // if point is inside then only consider it, for furthur prob calculation
            if (x >= 0 && x < n && y >= 0 && y < n)
                prob += 0.125 * f(k - 1, x, y, n);
        }
        return prob;
    }
}
// Time complexity : exponential