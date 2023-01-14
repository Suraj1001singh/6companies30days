import java.util.*;

//------------BRUTE FORCE

class Solution {
    public int[] getBiggestThree(int[][] g) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < g.length; i++){
            for(int j = 0; j < g[0].length; j++){
                q.offer(g[i][j]);
                for(int k = 1; k <= Math.min(g.length / 2, g[0].length / 2); k++){
                    if(i - k >= 0 && i + k < g.length && j - k >= 0 && j + k < g[0].length){
                        int sum = g[i][j - k] + g[i - k][j] + g[i + k][j] + g[i][j + k];
                        for(int l = 1; l < k; l++){
                            sum += g[i + l][j - k + l] + g[i - k + l][j + l];
                            sum += g[i - l][j - k + l] + g[i + k - l][j + l];
                        }
                        q.offer(sum);
                    }
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        while(q.size() > 0 && set.size() < 3){
            set.add(q.poll());
        }
        return set.stream().sorted(Comparator.reverseOrder()).limit(3).mapToInt(Integer::intValue).toArray();
    }
}
