
//---------Optimzation to linear time complexity----------------

class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        int gcd = 0;
        for (int i : numsDivide)
            gcd = GCD(gcd, i);
        int sm_div = Integer.MAX_VALUE;
        // find smallest divisor
        for (int i = 0; i < nums.length; i++) {
            if (gcd % nums[i] == 0 && nums[i] < sm_div)
                sm_div = nums[i];
        }
        // find number of elements less the sm_div;
        int cnt = 0;
        for (int i : nums) {
            if (i < sm_div)
                cnt++;
        }
        if (cnt == nums.length)
            return -1;
        return cnt;
    }

    int GCD(int a, int b) {
        if (a == 0)
            return b;
        return GCD(b % a, a);
    }
}
// Time complexity : O(n+m + gcd), gcd= log(max(numsDivide))