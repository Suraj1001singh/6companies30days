import java.util.*;

//---------EFFICIENT APPROACH
// HINT : store the occurances of each alphabet in string s

class Solution3 {
    public int numMatchingSubseq(String s, String[] words) {
        List<Integer> occ[] = new ArrayList[26];
        for (int i = 0; i < 26; i++)
            occ[i] = new ArrayList<>();
        // store occurances of char in string s
        for (int i = 0; i < s.length(); i++) {
            occ[s.charAt(i) - 'a'].add(i);
        }
        int res = 0;
        for (String word : words) {
            int lastInd = -1;
            for (int i = 0; i < word.length(); i++) {
                lastInd = upper_bound(occ[word.charAt(i) - 'a'], lastInd);
                if (lastInd == -1) {
                    res++;
                    break;
                }
            }
        }
        return words.length - res;
    }

    // wrost case or avg case TC : O(logS) : S is the length of s
    int upper_bound(List<Integer> arr, int key) {
        int mid, N = arr.size();
        int low = 0;
        int high = N;

        while (low < high && low != N) {
            mid = low + (high - low) / 2;
            if (key >= arr.get(mid))
                low = mid + 1;
            else
                high = mid;
        }
        if (low == N)
            return -1;
        return arr.get(low);
    }
}

// Time complexity : O(N*log S)
// N = length of array of string i.e words
// S = length of String s
