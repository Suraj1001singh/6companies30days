import java.util.*;

//-----------------NAIVE APPROACH

class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums1[i] - nums2[i];
        }
       
        return countPairs(arr, n, diff);

    }

    public long countPairs(int a[], int n, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int num = a[i] + k;
            for (int key : map.keySet()) {
                if (key > num)
                    break;
                cnt += map.get(key);
            }
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        return cnt;
    }
}