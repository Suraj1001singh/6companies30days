import java.util.*;


//Intuition : what posssible choices you have with w capital , find best out of present choices , 
//increase the domain of choices as soon as you get profit, then find best out of them

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int[][] cap = new int[capital.length][2];
        int ind = 0;
        for (int i = 0; i < profits.length; i++) cap[i] = new int[] { profits[i], capital[i] };
        Arrays.sort(cap, (a, b) -> a[1] - b[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        while (k-- > 0) {
            while (ind < profits.length && cap[ind][1] <= w) pq.add(cap[ind++][0]);
            if (!pq.isEmpty()) w += pq.poll();
        }
        return w;
    }
}
//Time complexity : O(n*log n)