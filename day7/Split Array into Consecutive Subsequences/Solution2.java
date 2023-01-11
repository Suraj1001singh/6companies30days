import java.util.*;

//-------EFFICIENT APPROACH
//HINT : Observation sort by increaing end point, 

class Solution2 {
    public boolean isPossible(int[] nums) {
        // [len , endpoint]
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        pq.add(new int[] { 1, nums[0] });

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            while (!pq.isEmpty() && num > pq.peek()[1] + 1)
                if (pq.poll()[0] < 3)
                    return false;

            if (pq.isEmpty() || num == pq.peek()[1])
                pq.add(new int[] { 1, num });
            else if (num == pq.peek()[1] + 1) {
                int point[] = pq.poll();
                point[0]++;
                point[1]++;
                pq.add(point);
            }
        }
        while (!pq.isEmpty()) {
            if (pq.poll()[0] < 3)
                return false;
        }
        return true;

    }
}
// Time complexity : O(n*log n )