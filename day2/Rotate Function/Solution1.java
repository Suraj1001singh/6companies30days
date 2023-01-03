class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        long sum = 0, r_sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            r_sum += i * nums[i];
        }
        long ans = r_sum;
        for (int i = n - 1; i >= 0; i--) {
            r_sum = r_sum + sum - nums[i] * n;
            ans = Math.max(ans, r_sum);
        }
        return (int)ans;
    }
}
// Time complexity : O(n)
// Space complexity : O(1)