import java.util.*;

class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int res[] = new int[queries.length];
        int ind = 0;
        for (int[] query : queries) {
            List<Pair> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(new Pair(i, nums[i].substring(nums[i].length() - query[1])));
            }
            Collections.sort(list, (a, b) -> a.num.compareTo(b.num));
            res[ind++] = list.get(query[0] - 1).ind;
        }
        return res;

    }
}

class Pair {
    int ind;
    String num;

    Pair(int i, String s) {
        ind = i;
        num = s;
    }
}