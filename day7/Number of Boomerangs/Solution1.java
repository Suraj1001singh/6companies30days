import java.util.*;

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length, ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        if (n < 3)
            return 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == i)
                    continue;
                int len = dist(points[i], points[j]);
                map.put(len, map.getOrDefault(len, 0) + 1);
            }
            for (int val : map.values())
                ans += val * (val - 1);

            map.clear();
        }
        return ans;
    }

    int dist(int p1[], int p2[]) {
        return (int) Math.pow(p1[0] - p2[0], 2) + (int) Math.pow(p1[1] - p2[1], 2);
    }
}
// Time complexity : O(n^3)