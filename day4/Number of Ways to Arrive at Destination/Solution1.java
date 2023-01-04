import java.util.*;;

//--------------------NAIVE 

class Solution {
    final int MOD = 1000000007;

    public int countPaths(int n, int[][] roads) {
        boolean[] vis = new boolean[n];
        // initialize adjacency list
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            adjList.get(road[0]).add(new int[] { road[1], road[2] });
            adjList.get(road[1]).add(new int[] { road[0], road[2] });
        }
        int[] dist = dijkstra(n, roads, 0, adjList);
        return (int) f(0, dist[n - 1], adjList, vis, n) % MOD;

    }

    // TC : exponential
    long f(int node, int target_sum, List<List<int[]>> adjList, boolean[] vis, int n) {
        if (node == n - 1) {
            if (target_sum == 0)
                return 1;
            else
                return 0;
        }
        long ans = 0;
        for (int u[] : adjList.get(node)) {
            if (vis[u[0]] == false && target_sum - u[1] >= 0) {
                vis[u[0]] = true;
                ans += f(u[0], target_sum - u[1], adjList, vis, n) % MOD;
                vis[u[0]] = false;
            }
        }
        return ans % MOD;
    }

    // dijkstra
    public int[] dijkstra(int n, int[][] roads, int source, List<List<int[]>> adjList) {
        // initialize distance array
        int[] distance = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;

        // initialize visited array
        boolean[] visited = new boolean[n];
        visited[source] = true;

        // initialize priority queue
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] { source, 0 });

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currNode = curr[0];
            int currDist = curr[1];
            if (currDist > distance[currNode]) {
                continue;
            }
            for (int[] neighbor : adjList.get(currNode)) {
                int neighborNode = neighbor[0];
                int neighborDist = neighbor[1];
                if (distance[neighborNode] > currDist + neighborDist) {
                    distance[neighborNode] = currDist + neighborDist;
                    pq.add(new int[] { neighborNode, distance[neighborNode] });
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (distance[i] != Integer.MAX_VALUE) {
                count++;
            }
        }
        return distance;
    }
}