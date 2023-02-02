
//------------BACKTRACKING (NAIVE APPROACH) 

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0, n = nums.length;
        for (int i = 0; i < n; i++)
            sum += nums[i];
        if (sum % k != 0)
            return false;
        sum /= k;
        return f(0, k, 0, sum, nums, new boolean[n]);
    }

    public boolean f(int start, int k, int currSum, int targetSum, int nums[], boolean seen[]) {
        if (k == 0)
            return true;
        if (currSum > targetSum)
            return false;
        if (currSum == targetSum)
            return f(0, k - 1, 0, targetSum, nums, seen);
        for (int i = start; i < nums.length; i++) {
            if (seen[i])
                continue;
            seen[i] = true;
            if (f(i + 1, k, currSum + nums[i], targetSum, nums, seen))
                return true;
            seen[i] = false;
        }
        return false;
    }
}