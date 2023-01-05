import java.util.Arrays;

class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        int gcd = 0;
        for (int i : numsDivide)
            gcd = GCD(gcd, i);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (gcd % nums[i] == 0)
                return i;
        }
        return -1;
    }

    int GCD(int a, int b) {
        if (a == 0)
            return b;
        return GCD(b % a, a);
    }
}
// Time complexity : O(n*log n)