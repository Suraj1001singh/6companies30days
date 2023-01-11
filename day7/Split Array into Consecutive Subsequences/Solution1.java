import java.util.*;

//-------Intutive approach

class Solution {
    public boolean isPossible(int[] nums) {
        PriorityQueue<int[]> pq1 = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq2 = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);

        pq1.add(new int[] { 1, nums[0] });

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            while (!pq1.isEmpty() && num - pq1.peek()[1] != 1)
                pq2.add(pq1.poll());

            if (pq1.isEmpty())
                pq2.add(new int[] { 1, num });
            else {
                int point[] = pq1.poll();
                point[0]++;
                point[1]++;
                pq2.add(point);
            }
            pq1.addAll(pq2);
            pq2.clear();
        }
        if (!pq1.isEmpty() && pq1.peek()[0] >= 3)
            return true;
        else
            return false;

    }
}
// Time complexity : O(n*logn ) but using two queues increases time complexity