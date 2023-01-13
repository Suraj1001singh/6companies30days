//NAIVE SOLUTION

class Solution {
    public int findIntegers(int n) {
        int res = 0;
        for (int i = 0; i <= n; i++) {
            for (int k = 0; k < 31; k++) {
                if ((i & (1 << k)) != 0 && (i & (1 << (k + 1))) != 0) {
                    res++;
                    break;
                }
            }
        }
        return n + 1 - res;
    }
}
// Time complexity : O(32 * n)
// Give TLE because n<=1e9