//NOTE : case two cases when odd number of -ve numbers and when even number of -ve numbers

class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length, neg = 0;
        long ans = 0, mini = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = Math.abs(matrix[i][j]);
                ans += num;
                mini = Math.min(mini, num);
                if (matrix[i][j] < 0)
                    neg++;
            }
        }
        if ((neg & 1) == 1)
            return ans - 2 * mini;
        else
            return ans;
    }
}
// Time complexity : O(n*n)