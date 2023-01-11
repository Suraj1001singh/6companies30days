import java.util.*;
//IDEA : find the slope 

class Solution {
    public int maxPoints(int[][] points) {
        HashMap<Double, Integer> map = new HashMap<>();
        int n = points.length, maxi = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // find slope
                int p1[] = points[i];
                int p2[] = points[j];
                double slope = ((p1[1] - p2[1]) * 1.0) / (p1[0] - p2[0]);
                if (p1[1] - p2[1] == 0 || p1[0] - p2[0] == 0)
                    slope = Math.abs(slope);
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                maxi = Math.max(map.get(slope), maxi);
            }

            map.clear();
        }
        return maxi + 1;// include master point itself
    }
}
// Time complexity : O(n^2)