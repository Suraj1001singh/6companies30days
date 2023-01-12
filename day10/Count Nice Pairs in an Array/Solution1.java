import java.util.*;

class Solution {
    int MOD = (int) 1e9 + 7;

    public int countNicePairs(int[] nums) {
        int n = nums.length, ans = 0;
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = nums[i] - reverse(nums[i]);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : a) {
            if (map.containsKey(num))
                ans = (ans + map.get(num)) % MOD;
            map.put(num, (map.getOrDefault(num, 0) + 1) % MOD);
        }
        return ans;
    }

    public int reverse(int num) {
        int a = 0;
        while (num > 0) {
            a *= 10;
            a += num % 10;
            num /= 10;
        }
        return a;
    }
}
// Time complexity : O(n)
// Space complexity : O(n)