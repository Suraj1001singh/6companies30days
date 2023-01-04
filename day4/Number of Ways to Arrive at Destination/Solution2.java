import java.util.*;

//------------EFFICIENT APPROACH

class Solution2 {
    final int MOD = 1000000007;

    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] road : roads) {
            adj.get(road[0]).add(new int[] { road[1], road[2] });
            adj.get(road[1]).add(new int[] { road[0], road[2] });
        }
        int[] dist = new int[n];// shortest dist
        int[] ways = new int[n];// number of ways node i can be reached with shortest dist
        Arrays.fill(dist, Integer.MAX_VALUE);
        ways[0] = 1;
        dist[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] { 0, 0 });

        while (!pq.isEmpty()) {
            int dis = pq.peek()[0];
            int node = pq.peek()[1];
            pq.poll();

            for (int it[] : adj.get(node)) {
                int adjnode = it[0];
                int adjwe = it[1];
                // first time comming with this shortest dist
                if (dist[adjnode] > dis + adjwe) {
                    ways[adjnode] = ways[node];
                    dist[adjnode] = dis + adjwe;
                    pq.add(new int[] { dis + adjwe, adjnode });
                } else if (dist[adjnode] == dis + adjwe)
                    // this is not first time comming with this shortest dist
                    ways[adjnode] = (ways[adjnode] + ways[node]) % MOD;
                // so add ways from where adjnode is reachable
            }
        }
        return ways[n - 1] % MOD;
    }
}
// Time complexity : O(V+E*logV) : Dijkstra's time complexity
