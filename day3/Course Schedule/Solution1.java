import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        createAdj(adj, prerequisites, numCourses);
        ArrayList<Integer> ans = TopologicalSort(numCourses, adj);
        return (ans.size() == numCourses);

    }

    public void createAdj(ArrayList<ArrayList<Integer>> adj, int[][] prerequisites, int numCourses) {
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] i : prerequisites) {
            adj.get(i[1]).add(i[0]);
        }
    }

    public ArrayList<Integer> TopologicalSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        ArrayList<Integer> ans = new ArrayList<>();
        // caluculating indegree
        for (ArrayList<Integer> x : adj) {
            for (int i : x) {
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        addInQueue(q, indegree);
        while (!q.isEmpty()) {
            int item = q.poll();
            ans.add(item);
            for (int x : adj.get(item)) {
                indegree[x]--;
                if (indegree[x] == 0) {
                    q.add(x);
                }
            }
        }
        return ans;

    }

    static public void addInQueue(Queue<Integer> q, int[] indegree) {
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
    }
}
// Time complexity : O(v+E)