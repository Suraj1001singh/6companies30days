import java.util.Arrays;

class Solution {
    int maxi;
    int res[];

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        maxi = Integer.MIN_VALUE;
        res = new int[12];
        f(11, numArrows, aliceArrows, new int[12], 0);
        return res;
    }

    public void f(int score, int arrow, int[] aliceArrows, int[] ans, int cost) {
        if (score == 0) {
            int k = ans[score];
            ans[score] = arrow;
            if (maxi < cost) {
                res = Arrays.copyOf(ans, ans.length);
                maxi = cost;
            }
            ans[score] = k;
            return;
        }
        if (aliceArrows[score] + 1 <= arrow) {
            ans[score] = aliceArrows[score] + 1;
            f(score - 1, arrow - aliceArrows[score] - 1, aliceArrows, ans, cost + score);
        }
        ans[score] = 0;
        f(score - 1, arrow, aliceArrows, ans, cost);
    }
}