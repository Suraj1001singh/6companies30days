import java.util.*;

class Solution {
    int res = Integer.MIN_VALUE;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> path_b = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int edge[] : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        dfs1(bob, adj, path_b, new boolean[n]);

        dfs2(0, 0, adj, path_b, new boolean[n], amount, 0);
        // System.out.println(Arrays.toString(amount));
        return res;

    }

    boolean dfs1(int node, List<List<Integer>> adj, List<Integer> path_b, boolean[] seen) {
        seen[node] = true;
        path_b.add(node);
        if (node == 0)
            return true;
        for (int u : adj.get(node))
            if (!seen[u] && dfs1(u, adj, path_b, seen))
                return true;
        path_b.remove(path_b.size() - 1);
        return false;
    }

    void dfs2(int node, int time, List<List<Integer>> adj, List<Integer> path_b, boolean[] seen, int[] amount,
            int cost) {
        seen[node] = true;
        int bob_pos = time < path_b.size() ? path_b.get(time) : -1;
        if (node == bob_pos)
            cost += (amount[node] / 2);
        else
            cost += amount[node];
        // amount[node] = 0;
        if (bob_pos != -1)
            amount[bob_pos] = 0;

        // check for leaf node
        if (adj.get(node).size() == 1 && seen[adj.get(node).get(0)]) {
            if (cost == 17034)
                System.out.println(cost);
            res = Math.max(res, cost);
            return;
        }

        int maxi = Integer.MIN_VALUE;
        for (int u : adj.get(node)) {
            if (!seen[u]) {
                dfs2(u, time + 1, adj, path_b, seen, amount, cost);
                // maxi = Math.max(maxi, cost + val);
            }
        }
    }

}