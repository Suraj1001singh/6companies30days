import java.util.*;

//-------LIS type questions

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res= new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length, maxi = 0;
        int dp[] = new int[n];
        int hash[] = new int[n];
        for(int i=0; i<n; i++) hash[i]=i;

        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[i] % nums[prev] == 0) {
                    if (1 + dp[prev] > dp[i]) {
                        hash[i] = prev;
                        dp[i] = 1 + dp[prev];
                    }
                }
            }
            if (dp[i] > dp[maxi])
                maxi = i;
        }
        //now tracking back elements
        int ind=maxi;
        while(ind!=hash[ind]){
            res.add(nums[ind]);
            ind=hash[ind];
        }
        res.add(nums[ind]);
        return res;
    }

}
//Time complexity : O(n^2);