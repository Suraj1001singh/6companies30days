
//------ALGO
//1) keep track of smallest number to the right side and
//   largest number to left side

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] smallest_right = new int[n];
        smallest_right[n - 1] = nums[n - 1];
        int[] largest_left = new int[n];
        largest_left[0] = nums[0];
        for (int i = 1, j = n - 2; i < n && j >= 0; i++, j--) {
            smallest_right[j] = Math.min(nums[j], smallest_right[j + 1]);
            largest_left[i] = Math.max(nums[i], largest_left[i - 1]);
        }
        int s = n - 1;
        for (int i = 0; i < n - 1; i++) {
            if (smallest_right[i + 1] < nums[i]) {
                s = i;
                break;
            }
        }
        int e = 0;
        for (int i = n - 1; i >= 1; i--) {
            if (largest_left[i - 1] > nums[i]) {
                e = i;
                break;
            }
        }
        if (e <= s)
            return 0;
        return e - s + 1;

    }
}
// Time complexity : O(n)
// Spac complexity : O(n)