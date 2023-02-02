import java.util.*;

class Solution {
    public int[] closestPrimes(int left, int right) {
        List<Integer> list = new ArrayList<>();
        int ans[] = new int[] { -1, -1 };
        for (int i = left; i <= right; i++) {
            if (isPrime(i))
                list.add(i);
        }
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            if (mini > list.get(i + 1) - list.get(i)) {
                mini = list.get(i + 1) - list.get(i);
                ans[0] = list.get(i);
                ans[1] = list.get(i + 1);
            }
        }
        return ans;

    }

    public boolean isPrime(int n) {
        // Corner cases
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;

        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }
}